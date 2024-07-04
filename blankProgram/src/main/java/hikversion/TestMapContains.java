package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @author:jinyandong
 * @description:测试mapcontains
 * @Date:2024/1/22
 */
public class TestMapContains {
    public static void main(String[] args) {
        String str= "{\n" +
                "    \"drv_vss_acs_ehome_allinone_1.13.0\":{\n" +
                "        \"max\":20000,\n" +
                "        \"remain\":20000,\n" +
                "        \"protocols\":[\n" +
                "            \"ehome_reg\"\n" +
                "        ],\n" +
                "        \"status\":\"enable\"\n" +
                "    },\n" +
                "    \"drv_acs_hiksdk_net_general_1.11.0\":{\n" +
                "        \"max\":20000,\n" +
                "        \"remain\":20000,\n" +
                "        \"protocols\":[\n" +
                "            \"hiksdk_net\"\n" +
                "        ],\n" +
                "        \"status\":\"enable\"\n" +
                "    }\n" +
                "}";
        JSONObject jsonobj = JSON.parseObject(str);
        Set<String> jsons = jsonobj.keySet();
        for (String one : jsons) {
            if (one.contains("drv_vss_acs_ehome_allinone_1.14")){
                System.out.println("wwwwwwwwwwwwww");
            }
        }
    }
}
