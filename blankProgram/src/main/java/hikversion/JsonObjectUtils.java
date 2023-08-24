package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Cheng JiYe
 * @description: json遍历工具类
 * @date 2021/9/10 17:40
 */
public class JsonObjectUtils {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String jsonString = "{\n" +
                "    \"Body\": {\n" +
                "        \"GetUserOrgPostResponse\": {\n" +
                "            \"GetUserOrgPostResult\": {\n" +
                "                \"NewDataSet\": {\n" +
                "                    \"@rowCount\": \"1234\",\n" +
                "                    \"ds\": {\n" +
                "                        \"Organization_FK\": \"6565\",\n" +
                "                        \"Organization_Dept_FK\": \"768786\",\n" +
                "                        \"Post_FK\": \"Pos11112222333\",\n" +
                "                        \"UserPostOID\": \"SPA2020656564\",\n" +
                "                        \"IsMaster\": \"true\",\n" +
                "                        \"User_FK\": \"USR45643543543435\",\n" +
                "                        \"IsVirtual\": \"false\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println("jsonObject是：" + jsonObject);
        BliuOaUserPostDto postDto = JsonObjectUtils.xmlToObjectOne("ds", jsonObject,     BliuOaUserPostDto.class);
        System.out.println(postDto);
    }



    /**
     * 获取Json 中某个节点的单个内容（实际是从Map中获取的）
     *
     * @param mapKey     Json中的某个节点
     * @param jsonObject Json对象
     * @param tClass     实体对象类型
     * @param <T>
     * @return
     */
    public static <T> T xmlToObjectOne(String mapKey, JSONObject jsonObject, Class<T> tClass) {
        Map<String, Object> map = JsonObjectUtils.jsonLoop(jsonObject, new HashMap<>(100));
        Object object = map.get(mapKey);
        T javaObject = null;
        if (object instanceof JSONObject) {
            JSONObject jsonObjectSun = (JSONObject) object;
            javaObject = jsonObjectSun.toJavaObject(tClass);
        }
        return javaObject;
    }


    /**
     * 使用递归的方式，把Json中的每个节点放到Map中
     *
     * @param object
     * @param map
     * @return
     */
    public static Map<String, Object> jsonLoop(Object object, Map<String, Object> map) {
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                String entryKey = entry.getKey();
                Object objValue = entry.getValue();
                map.put(entryKey, objValue);
                if (objValue instanceof JSONObject) {
                    JSONObject jsonObjectSun = (JSONObject) objValue;
                    if (jsonObjectSun.entrySet().size() >= 1) {
                        jsonLoop(objValue, map);
                    }
                }
            }
        }
        return map;
    }
}
