package hikversion;

import com.alibaba.fastjson.JSONObject;

/**
 * @author:jinyandong
 * @description:测试json转换
 * @Date:2021/9/30
 */
public class TestJsonConvert {
    public static void main(String[] args) {
        String str = "{\"code\":\"0\",\"delDevice\":null,\"regDevice\":{\"addr\":\"172.16.38.254\",\"devName\":\"Mammamia-NVR-.........\",\"devType\":\"DS-7708N-K4/8P\",\"deviceIndexCode\":\"C24611635\",\"deviceSerialNum\":\"DS-7708N-K4/8P0820180524CCRRC24611635WCVU\",\"port\":23649,\"treatyType\":\"isup5_reg\",\"treatyVersion\":\"isup5.0\"}]}";
        RegDeviceContentTest myclass = JSONObject.parseObject(str , RegDeviceContentTest.class);
        // JSONObject jsonObj = new JSONObject(content);
        System.out.println("jsonObject : " + myclass);
    }
}
