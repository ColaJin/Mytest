package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试返回
 * @Date:2023/10/11
 */
public class TestReturn {
    public static void main(String[] args) {
       /* JSONObject result = new JSONObject();
        Map<String, Object> outputData = new HashMap<>();
        result.put("result", "未执行");
        outputData.put("data", result.toString());
        outputData.put("code", 0);

        int iRet = 0;

        StringBuffer itemStrs = new StringBuffer();
        itemStrs.append("ITEM_NO=000");

        String fileName = "play00.lst";

        System.out.println(clearScreen(result,iRet,outputData,itemStrs,fileName));

        for (Map.Entry<String, Object> stringObjectEntry : outputData.entrySet()) {
            System.out.println(stringObjectEntry.getKey() );
            System.out.println(stringObjectEntry.getValue());
        }*/
        JSONObject result = new JSONObject();
        JSONObject dstPicQuality = new JSONObject();
        dstPicQuality.put("0","最好");
        dstPicQuality.put("1","次好");
        dstPicQuality.put("2","较好");
        dstPicQuality.put("3","一般");
        dstPicQuality.put("4","较差");
        dstPicQuality.put("5","差");
        result.put("dstPicQuality",dstPicQuality);

        System.out.println(result);


    }
    public static int clearScreen(JSONObject result,int iRet,Map<String, Object> outputData,StringBuffer itemStrs,String fileName){
        result.put("result", "clear ");
        outputData.put("data", result.toString());
        outputData.put("code", 0);
        iRet = -1;
        return iRet;
    }
}
