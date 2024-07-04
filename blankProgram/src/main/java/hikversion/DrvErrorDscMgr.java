package hikversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tengleilei
 * @Date: 2021/7/20 11 54
 * @Description:
 */
public class DrvErrorDscMgr {

    private DrvErrorDscMgr(){}

    private static class SingletonInstance{
        private static final DrvErrorDscMgr INSTANCE = new DrvErrorDscMgr();
    }

    public static DrvErrorDscMgr getInstance(){
        return SingletonInstance.INSTANCE;
    }

    private Map<Integer,String> codeMap = new HashMap<>();

    /**
     * 初始化错误码
     */
    private void initCode(){
        codeMap.put(0,"OK");
        codeMap.put(-1,"error");
    }


    /**
     * 获取错误详细信息
     * @param code
     * @return
     */
    public String getServerErrMsgByCode(int code){
        if (codeMap.size() == 0){
            initCode();
        }

        return codeMap.get(code) == null ?"null-unkown-error" :codeMap.get(code);
    }


}
