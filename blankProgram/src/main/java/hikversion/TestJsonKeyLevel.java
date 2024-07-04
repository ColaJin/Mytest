//package hikversion;
//
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author:jinyandong
// * @description:测试json中key所在的层级，key重复
// * @Date:2024/1/4
// */
//public class TestJsonKeyLevel {
//    public static void main(String[] args) {
//        /*String jsonStr = "{\"name\":\"John\", \"age\":30,\n" +
//                "\"address\": {\n" +
//                "   \"name\":\"123 Street\",\n" +
//                "   \"city\":\"New York\",\n" +
//                "   \"state\":\"NY\"\n" +
//                "}}";*/
//        String jsonStr = "{\n" +
//                "    \"channelIndexCode\":\"110110110110\",\n" +
//                "    \"record\":1,\n" +
//                "    \"TimeRange\":[\n" +
//                "        {\n" +
//                "            \"startTime\":\"17:30:08\",\n" +
//                "            \"endTime\":\"17:30:10\",\n" +
//                "            \"recordType\":0,\n" +
//                "            \"day\":\"Sunday\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"recordType\":0,\n" +
//                "    \"preRecord\":5,\n" +
//                "    \"postRecord\":5,\n" +
//                "    \"recordAudio\":0,\n" +
//                "    \"recordDuration\":30\n" +
//                "}";
//
//        // 创建JSONObject对象
//        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
//
//        // 调用自定义函数获取指定键所属的层级
//        int level = getKeyLevel("recordType", jsonObj);
//        System.out.println("The key 'name' is at level: " + level);
//
//       List<Integer> rs = new ArrayList<>();
//        getKeyLevelList("name",jsonObj,rs);
//        for (Integer r : rs) {
//            System.out.println(r);
//        }
//
//        findSameKeyLevels()
//    }
//
//    private static int getKeyLevel(String key, Object obj) {
//        if (obj instanceof JSONObject) {
//            JSONObject jsonObj = (JSONObject) obj;
//
//            for (String currentKey : jsonObj.keySet()) {
//                if (currentKey.equals(key)) {
//                    return 1; // 返回当前层级
//                } else {
//                    Object value = jsonObj.get(currentKey);
//
//                    if (value instanceof JSONObject || value instanceof JSONArray) {
//                        int childLevel = getKeyLevel(key, value);
//
//                        if (childLevel > 0) {
//                            return childLevel + 1; // 返回子节点的层级加上当前层级
//                        }
//                    }
//                }
//            }
//
//        } else if (obj instanceof JSONArray) {
//            JSONArray jsonArr = (JSONArray) obj;
//
//            for (int i = 0; i < jsonArr.size(); i++) {
//                Object item = jsonArr.get(i);
//
//                if (item instanceof JSONObject || item instanceof JSONArray) {
//                    int childLevel = getKeyLevel(key, item);
//
//                    if (childLevel > 0) {
//                        return childLevel + 1; // 返回子节点的层级加上当前层级
//                    }
//                }
//            }
//        }
//
//        return -1; // 未找到该键
//    }
//
//    private static int getKeyLevelList(String key, Object obj,List<Integer> temp) {
//        if (obj instanceof JSONObject) {
//            JSONObject jsonObj = (JSONObject) obj;
//
//            for (String currentKey : jsonObj.keySet()) {
//                if (currentKey.equals(key)) {
//                    temp.add(1);
//                    return 1; // 返回当前层级
//                } else {
//                    Object value = jsonObj.get(currentKey);
//
//                    if (value instanceof JSONObject || value instanceof JSONArray) {
//                        int childLevel = getKeyLevelList(key, value,temp);
//
//                        if (childLevel > 0) {
//                            temp.add(childLevel + 1);// 返回子节点的层级加上当前层级
//                            return childLevel + 1;
//                        }
//                    }
//                }
//            }
//
//        } else if (obj instanceof JSONArray) {
//            JSONArray jsonArr = (JSONArray) obj;
//
//            for (int i = 0; i < jsonArr.size(); i++) {
//                Object item = jsonArr.get(i);
//
//                if (item instanceof JSONObject || item instanceof JSONArray) {
//                    int childLevel = getKeyLevel(key, item);
//
//                    if (childLevel > 0) {
//                        temp.add(childLevel + 1);// 返回子节点的层级加上当前层级
//                        return childLevel + 1;
//                    }
//                }
//            }
//        }
//        temp.add(-1);
//        return -1; // 未找到该键
//    }
//
//
//    private static void findSameKeyLevels(String parentPath, Object obj) {
//        if (obj instanceof JSONArray) {
//            for (int i = 0; i < ((JSONArray) obj).size(); i++) {
//                findSameKeyLevels(parentPath + "[%d]".replace("%d", Integer.toString(i)), ((JSONArray) obj).get(i));
//            }
//        } else if (obj instanceof JSONObject) {
//            for (String key : ((JSONObject) obj).keySet()) {
//                findSameKeyLevels(parentPath + "." + key, ((JSONObject) obj).get(key));
//            }
//        } else {
//            System.out.println("Parent path: " + parentPath);
//        }
//    }
//}
