package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author:jinyandong
 * @description:测试String转换List
 * @Date:2023/8/22
 */
public class TestStringToList {
    public static void main(String[] args) {
        String items = "{\"items\":[\n" +
                "                {\n" +
                "                    \"_id\":\"74d4e60672834f2e85a9e2686a64f9e4\",\n" +
                "                    \"_program\":{\n" +
                "                        \"id\":\"1e7fc3a072054d8b883d9fc5dd8cdd55\",\n" +
                "                        \"totalSize\":167545,\n" +
                "                        \"name\":\"ehlitemProgram\",\n" +
                "                        \"width\":128,\n" +
                "                        \"height\":256,\n" +
                "                        \"layers\":[\n" +
                "                            {\n" +
                "                                \"repeat\":false,\n" +
                "                                \"sources\":[\n" +
                "                                    {\n" +
                "                                        \"_type\":\"Image\",\n" +
                "                                        \"md5\":\"888535d4f98ea557596839ca7ed4141e\",\n" +
                "                                        \"name\":\"1.png\",\n" +
                "                                        \"mime\":\"image/png\",\n" +
                "                                        \"size\":167545,\n" +
                "                                        \"fileExt\":\".png\",\n" +
                "                                        \"id\":\"5ca1d704ca37bbc01ebbdbc0\",\n" +
                "                                        \"url\":\"http://49.235.105.76:6095/sz1.png\",\n" +
                "                                        \"playTime\":0,\n" +
                "                                        \"timeSpan\":10,\n" +
                "                                        \"left\":0,\n" +
                "                                        \"top\":0,\n" +
                "                                        \"width\":128,\n" +
                "                                        \"height\":256,\n" +
                "                                        \"entryEffect\":\"None\",\n" +
                "                                        \"exitEffect\":\"None\",\n" +
                "                                        \"entryEffectTimeSpan\":0,\n" +
                "                                        \"exitEffectTimeSpan\":0\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    \"repeatTimes\":1,\n" +
                "                    \"schedules\":[\n" +
                "                        {\n" +
                "                            \"dateType\":\"All\",\n" +
                "                            \"timeType\":\"Range\",\n" +
                "                            \"startTime\":\"00:00\",\n" +
                "                            \"endTime\":\"23:59\",\n" +
                "                            \"filterType\":\"None\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]}";
        JSONObject param = JSONObject.parseObject(items);
        List<Item> rs = (List<Item>) param.get("items");
        System.out.println(JSONObject.toJSONString(rs));
    }
}
