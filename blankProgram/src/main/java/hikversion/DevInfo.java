package hikversion;

import lombok.Data;

import java.util.Map;

/**
 * @author tengleilei
 * @date 2022/3/3 16:17
 * @description: TODO
 */
@Data
public class DevInfo {
    //设备内码 dms生成
    private String indexCode;
    //设备IP
    private String addr;
    //设备端口
    private String port;
    //设备外码
    private String deviceIndexCode;
    //设备协议
    private String treatyType;
    //设备名称
    private String devName;
    //设备型号
    private String devType;
    //mac地址
    private String mac;
    //用户信息
    private Object userData = null;
    //报警回调
    private NotifyCbf alarmNotifyCby = null;
    // "netStatus": 2,//Integer，设备在线状态，1在线2不在线
    private Integer netStatus = 2;
    //是否已经添加  true：已经添加 false：未添加
    private boolean isAdd = false;


    public DevInfo(){}


    public void setDevInfo(Map<String, Object> pDevInfoMap,Object pUserData){
        if (pDevInfoMap.containsKey("indexCode")){
            indexCode = (String) pDevInfoMap.get("indexCode");
        }
        if (pDevInfoMap.containsKey("deviceIndexCode")){
            deviceIndexCode = (String) pDevInfoMap.get("deviceIndexCode");
        }

        if (pDevInfoMap.containsKey("port")){
            port = String.valueOf(pDevInfoMap.get("port"));
        }
        if (pDevInfoMap.containsKey("name")){
            devName = (String) pDevInfoMap.get("name");
        }
        if (pDevInfoMap.containsKey("addr")){
            addr = (String) pDevInfoMap.get("addr");
        }
        if (pDevInfoMap.containsKey("protocol")){
            treatyType = (String) pDevInfoMap.get("protocol");
        }
        devType = "DS-PWA32-UWB";
        userData = pUserData;
        isAdd = true;
    }

    public DevInfo(Map<String, Object> pDevInfoMap, Object pUserData){
        if (pDevInfoMap.containsKey("indexCode")){
            indexCode = (String) pDevInfoMap.get("indexCode");
        }
        if (pDevInfoMap.containsKey("deviceIndexCode")){
            deviceIndexCode = (String) pDevInfoMap.get("deviceIndexCode");
        }

        if (pDevInfoMap.containsKey("port")){
            port = String.valueOf(pDevInfoMap.get("port"));
        }
        if (pDevInfoMap.containsKey("name")){
            devName = (String) pDevInfoMap.get("name");
        }
        if (pDevInfoMap.containsKey("addr")){
            addr = (String) pDevInfoMap.get("addr");
        }
        if (pDevInfoMap.containsKey("protocol")){
            treatyType = (String) pDevInfoMap.get("protocol");
        }
        devType = "DS-PWA32-UWB";
        userData = pUserData;
        isAdd = true;
    }

}
