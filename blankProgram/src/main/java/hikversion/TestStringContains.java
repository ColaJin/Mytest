package hikversion;

import com.alibaba.fastjson.JSONObject;

/**
 * @author:jinyandong
 * @description:测试字符串的contains方法
 * @Date:2022/4/25
 */
public class TestStringContains {
    public static void main(String[] args) {
        /*String delChannelNo = "31e83761463040688dc7042412607779,5a53c541a15f4feaa80bcf57d3ba095d,1339a415c68f4d6995ea7f916ba9123d";

        if (delChannelNo.contains("5a53c541a15f4feaa80bcf57d3ba095d")) {
            System.out.println(true);
        }*/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("plateformDeviceType","waterPressure_61");
        String s = jsonObject.toString();
        if (s.contains("plateformDeviceType")) {
            System.out.println("plateformDeviceType contains");
        }
    }
}
