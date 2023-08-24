package hikversion;

/**
 * @author:jinyandong
 * @description:c++
 * @Date:2023/4/12
 */
/** @file       DagMqManager.cpp
 *  @copyright  HangZhou Hikvision System Technology Co., Ltd.
 *              All Right Reserved.
 *  @brief
 *
 *  @author     zhangqingwen  (zhangqingwen@hikvision.com.cn)
 *
 *  @note       History
 *  @par        08/28/2014  Created
 */

#include "MqMgr.h"
        #include "mq/Notify_api.h"
        #include "hprplus/StringTraits.h"
        #include "HPR_Atomic.h"
        #include <decaf/lang/System.h>
        #include "DrvThreadPoolMgr.h"

//解析mq订阅url，分解用户名密码
        bool ParseMqUrl(string& strMqUrl, string& strUserName ,string& strPassword,string& strRoutingkey)
        {
        try
        {
        vector<string> strResultVector1;
        vector<string> strResultVector2;

        StringTraits::Split(strMqUrl, "?", strResultVector1);
        if (strResultVector1.size() > 1)
        {
        strMqUrl = strResultVector1[0];
        StringTraits::Split(strResultVector1[1], "&", strResultVector2);
        if (strResultVector2.size() > 1)
        {
        size_t nPos = strResultVector2[0].find('=',0);
        if (nPos != string::npos)
        {
        strUserName = strResultVector2[0].substr(nPos+1);
        }
        nPos = strResultVector2[1].find('=',0);
        if (nPos != string::npos)
        {
        strPassword = strResultVector2[1].substr(nPos+1);
        }
        if (strResultVector2.size() > 2)
        {
        nPos = strResultVector2[2].find('=',0);
        if (nPos != string::npos)
        {
        strRoutingkey = strResultVector2[2].substr(nPos+1);
        }
        }
        }
        else
        {
        LOG_ERROR("[0x%08x] - [suburl=%S]ParseMqUrl can not find &", COMMON_E_PARSE_FAIL, strMqUrl.c_str());
        //return false;防止kafka不需要用户名密码时失败
        }
        }
        else
        {
        LOG_ERROR("[0x%08x] - [suburl=%S]ParseMqUrl can not find ?", COMMON_E_PARSE_FAIL, strMqUrl.c_str());
        //return false;
        }
        }
        catch (...)
        {
        LOG_ERROR("[0x%08x] - [suburl=%S]ParseMqUrl failed", COMMON_E_PARSE_FAIL, strMqUrl.c_str());
        return false;
        }
        return true;
        }

        HPR_VOIDPTR pfnMqReconn(HPR_INT32 hEvent, HPR_VOIDPTR pUsrData)
        {
        CMqMgrSingleton::instance()->Reconn();
        return NULL;
        }

        CMqMgr::CMqMgr(void)
        : m_bReConnThreadRunning(false)
        , m_cInitCount(0)
        , m_iTimer(-1)
        {
        }


        CMqMgr::~CMqMgr(void)
        {
        }

        bool CMqMgr::IsMqUrl(const string& sUrl)
        {
        return ( string::npos != sUrl.find("mq") );
        }

        int CMqMgr::Init()
        {
        if (m_cInitCount == 0)
        {
        MQ_INFO("- Init mq manager begin...");
        if (Notify_init() < 0)
        {
        LOG_ERROR("[0x%08x] - Notify_init failed", COMMON_E_THREAD_CREATE_FAIL);
        return COMMON_E_THREAD_CREATE_FAIL;
        }
        m_bReConnThreadRunning = true;
        HPR_AtomicInc((HPR_ATOMIC_T*)&m_cInitCount);

        if (HPR_OK != HPR_SetTimer(pfnMqReconn, this, 10*1000, &m_iTimer, HPR_FALSE))
        {
        LOG_ERROR("[0x%08x] - HPR_SetTimer failed", COMMON_E_THREAD_CREATE_FAIL);
        return COMMON_E_THREAD_CREATE_FAIL;
        }

        MQ_INFO("- Init mq manager succ.");
        }

        return DAG_MQ_NO_ERROR;
        }

        void CMqMgr::Fini()
        {
        if (m_iTimer != -1)
        {
        HPR_KillTimer(m_iTimer);
        m_iTimer = -1;
        }

        int iInitCount = 0;
        HPR_AtomicDec((HPR_ATOMIC_T*)&m_cInitCount);
        iInitCount = m_cInitCount;

        if (iInitCount == 0)
        {
        MQ_INFO("- Fini mq manager begin...");
        m_bReConnThreadRunning = false;
        m_lockMqSessionMap.Lock();
        map<string, CDagMqSessionAutoPtr>::iterator iter;
        for ( iter = m_mapMqSession.begin(); iter != m_mapMqSession.end(); iter++ )
        {
        if (iter->second)
        {
        iter->second->DestroyConn();
        }
        }
        m_mapMqSession.clear();
        m_lockMqSessionMap.Unlock();
        Notify_fini();
        MQ_INFO("- Fini mq manager succ.");
        }
        else if (iInitCount < 0)
        {
        HPR_AtomicSet((HPR_ATOMIC_T*)&m_cInitCount, 0);
        }
        }

        int CMqMgr::CreateConn(const string& strSubUrl, IDagMqConnSink* pConnSink)
        {
        if (m_cInitCount <= 0)
        {
        return COMMON_E_NO_INIT;
        }

        m_lockMqSessionMap.Lock();
        map<string, CDagMqSessionAutoPtr>::iterator iter = m_mapMqSession.find(strSubUrl);
        if (iter != m_mapMqSession.end())
        {
        iter->second->AddRef();
        m_lockMqSessionMap.Unlock();
        return DAG_MQ_NO_ERROR;
        }

        //解析url
        string strSubUrlReq = strSubUrl;
        string strUserName;
        string strPassword;
        string strRoutingkey;
        if(!ParseMqUrl(strSubUrlReq,strUserName,strPassword,strRoutingkey))
        {
        m_lockMqSessionMap.Unlock();
        return COMMON_E_PARSE_FAIL;
        }

        CDagMqSessionAutoPtr pSessionAutoPtr = CDagMqSessionAutoPtr(new (std::nothrow) CDagMqSession(strSubUrlReq, strUserName, strPassword, pConnSink,strRoutingkey));
        m_mapMqSession[strSubUrl] = pSessionAutoPtr;
        m_lockMqSessionMap.Unlock();

        return pSessionAutoPtr->CreateConn();
        }

        void CMqMgr::DestroyConn(const string& strSubUrl)
        {
        if (m_cInitCount <= 0)
        {
        return;
        }

        CDagMqSessionAutoPtr pSessionAutoPtr = CDagMqSessionAutoPtr(NULL);

        m_lockMqSessionMap.Lock();
        map<string, CDagMqSessionAutoPtr>::iterator iter = m_mapMqSession.find(strSubUrl);
        if (iter != m_mapMqSession.end())
        {
        if (iter->second->DelRef() == 1)
        {
        pSessionAutoPtr = iter->second;
        m_mapMqSession.erase(iter);
        }
        }
        m_lockMqSessionMap.Unlock();
        if (pSessionAutoPtr)
        {
        pSessionAutoPtr->DestroyConn();
        }
        }

        int CMqMgr::SendMessage(const string& strSubUrl, const char* szData, int iDataLen)
        {
        CDagMqSessionAutoPtr pSessionAutoPtr = CDagMqSessionAutoPtr(NULL);

        m_lockMqSessionMap.Lock();
        map<string, CDagMqSessionAutoPtr>::iterator iter = m_mapMqSession.find(strSubUrl);
        if (iter != m_mapMqSession.end())
        {
        pSessionAutoPtr = iter->second;
        }
        m_lockMqSessionMap.Unlock();

        if (pSessionAutoPtr)
        {
        return pSessionAutoPtr->SendMessage(szData, iDataLen);
        }
        return DAG_MQ_MQSESSION_NOTEXIST_ERROR;
        }

        int CMqMgr::Reconn()
        {
        m_lockMqSessionMap.Lock();
        map<string, CDagMqSessionAutoPtr>::iterator iter = m_mapMqSession.begin();
        while (iter != m_mapMqSession.end())
        {
        if (iter->second->Reconnect())
        {
        IDrvCustomizeEvent *pEvent = new (std::nothrow)CReconnEvent(iter->second);
        ELogEx_IfRet(pEvent == NULL, DAG_ERR, "new CReconnEvent failed");
        CDrvCtrlThreadPoolMgrSingleton::instance()->PostProcEvent(pEvent, ENUM_CTRLTYPE_DEFAULT);
        MQ_INFO("- [url=%s]DagMq Reconn PostEvent ok", iter->second->GetSubUrl().c_str());
        }

        iter++;
        }
        m_lockMqSessionMap.Unlock();
        return DAG_OK;
        }

        int CMqMgr::GetMqSessionStatus(const string& strSubUrl)
        {
        m_lockMqSessionMap.Lock();
        CDagMqSessionAutoPtr pSessionAutoPtr = NULL;
        map<string, CDagMqSessionAutoPtr>::iterator iter = m_mapMqSession.find(strSubUrl);
        if (iter != m_mapMqSession.end())
        {
        pSessionAutoPtr = iter->second;
        }
        m_lockMqSessionMap.Unlock();
        if (pSessionAutoPtr == NULL)
        {
        return DAG_MQ_MQSESSION_NOTEXIST_ERROR;
        }
        else
        {
        return pSessionAutoPtr->Reconnect() ? DAG_MQ_MQSESSION_NOTCONN_ERROR : DAG_MQ_NO_ERROR;

        }
        }