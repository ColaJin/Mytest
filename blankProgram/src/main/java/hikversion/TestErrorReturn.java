package hikversion;

import com.alibaba.fastjson.JSONObject;

/**
 * @author:jinyandong
 * @description:测试驱动错误码返回
 * @Date:2024/1/4
 */
public class TestErrorReturn {
    public static void main(String[] args) {
        JSONObject root = new JSONObject();
        int iErrorCode = 0x0190003e;
        if ((iErrorCode&0x80000000) == 0 || iErrorCode == 0 ) {
            root.put("message" , DrvErrorDscMgr.getInstance().getServerErrMsgByCode(iErrorCode));
            if (iErrorCode != 0) {
                root.put("code" , ConverErrorIntToString(iErrorCode));
            } else {
                root.put("code" , String.valueOf(iErrorCode));
            }

        }  else {
            root.put("code" , ConverErrorIntToString(iErrorCode));
        }
    }

    public static String ConverErrorIntToString(int nErrcode) {
        String strError;
        if (nErrcode != 0) {
            strError = "0x0" + Integer.toHexString(nErrcode);
        }
        else {
            strError = Integer.toHexString(nErrcode);
        }

        return strError;
    }
}
