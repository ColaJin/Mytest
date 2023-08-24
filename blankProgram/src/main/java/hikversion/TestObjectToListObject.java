package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试Object转换程List<Object>
 * @Date:2023/3/17
 */
public class TestObjectToListObject {
    public static int NotifyCallBack(Object pBuf){
        List<DATA_MODEL> result = new ArrayList<>();
        if (pBuf instanceof ArrayList<?>) {
            for (Object o : (List<?>) pBuf) {
                result.add(DATA_MODEL.class.cast(o));
            }
        }
        // List<DATA_MODEL> pCallBackDatas =  (List<DATA_MODEL>)pBuf;
        System.out.println(JSONObject.toJSONString(result));
        return 0;
    }

    public static void main(String[] args) {
        List<DATA_MODEL> stDataModels = new ArrayList<>();
        DATA_MODEL stDataModel = new DATA_MODEL();
        JSONObject jsonHeader = new JSONObject();
        String strDataHeader = jsonHeader.toJSONString();
        stDataModel.pJsonExtendData = strDataHeader;
        JSONObject data = new JSONObject();
        data.put("ipAddress", "127.0.0.1");
        data.put("ipv6Address", "127.0.0.1");
        data.put("port", "9222");
        data.put("eventType", "braceletCollection");
        data.put("eventDescription", "bracelet Collection");
        stDataModel.pJsonStructData = data.toJSONString();
        stDataModel.pUserData = new Object();
        // null toJsonString不显示
        // stDataModel.pUserData = null;
        stDataModels.add(stDataModel);
        int i = NotifyCallBack(stDataModels);
        System.out.println(i);
    }
}
