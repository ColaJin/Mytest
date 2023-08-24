package hikversion;

/**
 * @author:jinyandong
 * @description:测试错误码转换
 * @Date:2023/6/21
 */
public class TestError {

    public static final int ERR_COMMON_E_Base = 0x01900000;  ///<通用错误码基数
    public static final int ERR_COMMON_E_N_SUPPORT = ERR_COMMON_E_Base +21;
    public static final int ERR_COMMON_E_DEVINDEX_N_FOUND =    (ERR_COMMON_E_Base +0);
    public static void main(String[] args) {
        int i = ERR_COMMON_E_N_SUPPORT;
        int i1 = 26214423;
        int i2 = 26214421;
        System.out.println(ConverErrorIntToString(i));
        System.out.println(ConverErrorIntToString(i2));
        System.out.println(i);
        System.out.println(ConverErrorIntToString(i1));
        System.out.println(converErrorCode(ERR_COMMON_E_DEVINDEX_N_FOUND));
        int nRet = -1;
        System.out.println(converErrorCode(ToStandardErr(nRet)));
    }

    public static int ToStandardErr(int nErrcode) {
        int flag = nErrcode & 0x80000000;
        if (flag != 0) {
            nErrcode &= 0x7FFFFFFF;
        }
        return nErrcode;
    }

    public static String ConverErrorIntToString(int nErrcode) {
        String strError;
        if (nErrcode != 0) {
            strError = "0x0" + Integer.toHexString(nErrcode);
        } else {
            strError = Integer.toHexString(nErrcode);
        }

        return strError;
    }

    public static String converErrorCode(int nErrCode) {
        if (nErrCode == -1){
            return "-1";
        }
        String strErr = String.format("[0x%08x]", nErrCode);
        return strErr;
    }
}
