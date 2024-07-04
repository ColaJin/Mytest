package hikversion;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试JsonPath使用
 * @Date:2024/1/4
 */
public class TestJsonPath {
    public static void main(String[] args) {
        /*String content = "{\n" +
                "        \"channelIndexCode\": \"110110110110\",\n" +
                "        \"record\": 1,\n" +
                "        \"TimeRange\":\n" +
                "        [\n" +
                "            {\n" +
                "                \"startTime\": \"17:30:08\",\n" +
                "                \"endTime\": \"17:30:10\",\n" +
                "                \"recordType\": \"Abc123++\",\n" +
                "                \"day\": \"Sunday\"\n" +
                "            }\n" +
                "        ] ,\n" +
                "        \"recordType\": \"Abc123++\",\n" +
                "        \"preRecord\": 5,\n" +
                "        \"postRecord\": 5,\n" +
                "        \"recordAudio\": 0,\n" +
                "        \"recordDuration\": 30\n" +
                "    }\n";
        JSONObject bodyParam = JSONObject.parseObject(content);

        List<NetToolSensitiveKeyDto> sensitiveKeys = new ArrayList<>();
        NetToolSensitiveKeyDto temp = new NetToolSensitiveKeyDto();
        NetToolSensitiveKeyDto temp1 = new NetToolSensitiveKeyDto();
        temp1.setKey("recordType");
        temp1.setLevel("TimeRange");
        temp.setKey("recordType");
        temp.setLevel("");
        sensitiveKeys.add(temp1);
        sensitiveKeys.add(temp);*/
        String content = "{\n" +
                "    \"method\":\"SetOneRecordPlan\",\n" +
                "    \"params\":{\n" +
                "        \"channelIndexCode\":\"110110110110\",\n" +
                "        \"record\":1,\n" +
                "        \"TimeRange\":[\n" +
                "            {\n" +
                "                \"startTime\":\"17:30:08\",\n" +
                "                \"endTime\":\"17:30:10\",\n" +
                "                \"recordType\":\"Abc123++\",\n" +
                "                \"day\":\"Sunday\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"startTime\":\"17:30:08\",\n" +
                "                \"endTime\":\"17:30:10\",\n" +
                "                \"recordType\":\"zzzzzz++\",\n" +
                "                \"day\":\"Sunday\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"recordType\":\"Abc123++\",\n" +
                "        \"preRecord\":5,\n" +
                "        \"postRecord\":5,\n" +
                "        \"recordAudio\":0,\n" +
                "        \"recordDuration\":30\n" +
                "    }\n" +
                "}";
        JSONObject bodyParam = JSONObject.parseObject(content);

        List<NetToolSensitiveKeyDto> sensitiveKeys = new ArrayList<>();
        NetToolSensitiveKeyDto temp = new NetToolSensitiveKeyDto();
        NetToolSensitiveKeyDto temp1 = new NetToolSensitiveKeyDto();
        temp1.setKey("recordType");
        temp1.setLevel("params.TimeRange");
        temp.setKey("recordType");
        temp.setLevel("params");
        sensitiveKeys.add(temp1);
        sensitiveKeys.add(temp);
        for (NetToolSensitiveKeyDto sensitiveKey : sensitiveKeys) {
            String key = sensitiveKey.getKey();
            String level = sensitiveKey.getLevel();
            /*System.out.println(String.valueOf(JSONPath.eval(bodyParam, level + "." + key)));
            JSONPath.set(bodyParam, level + "." + key, "update");*/
            if ((JSONPath.contains(bodyParam, level + "." + key))) {
                Object eval = JSONPath.eval(bodyParam, level + "." + key);
                if (eval instanceof String) {
                    JSONPath.set(bodyParam, level + "." + key, "update1");
                } else if (eval instanceof List) {
                    List<String> del = (List) eval;
                    for (int i = 0; i < del.size(); i++) {

                        JSONPath.set(bodyParam, level + "." + key + "[" + i + "]", del.get(i));
                    }
                }
            }
        }

        System.out.println(JSONObject.toJSONString(bodyParam));
    }
}
