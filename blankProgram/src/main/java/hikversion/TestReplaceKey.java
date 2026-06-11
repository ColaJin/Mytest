package hikversion;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试根据key替换类字段
 * @Date:2025/3/24
 */
public class TestReplaceKey {
    public static void main(String[] args) throws Exception {
        String templateJson = "{\n" +
                "    \"targetAttrs\": {\n" +
                "        \"deviceIndexCode\": \"58d797831633459c858f24fa54a062e6\",\n" +
                "        \"camer\": \"也不对\"\n" +
                "    },\n" +
                "    \"name\": \"xxxxx\",\n" +
                "    \"other\": \"不换\",\n" +
                "    \"replaceKey\": [\n" +
                "        {\n" +
                "            \"targetAttrs.deviceIndexCode\": \"indexCode\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"devName\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        DevInfo devInfo = new DevInfo();
        devInfo.setIndexCode("12345676");
        devInfo.setDevName("设备1");
        System.out.println(replaceFields(devInfo, templateJson));
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String replaceFields(DevInfo devInfo, String templateJson) throws Exception {
        // 1. 解析原始JSON模板并创建深拷贝
        JsonNode rootNode = mapper.readTree(templateJson);
        ObjectNode result = (ObjectNode) rootNode.deepCopy();

        // 2. 移除替换配置节点（防止出现在最终结果中）
        result.remove("replaceKey");

        // 3. 获取替换规则配置
        JsonNode replaceNodes = rootNode.get("replaceKey");
        if (replaceNodes ==  null){
            return templateJson;
        }
        List<Map<String, String>> mappings = mapper.convertValue(
                replaceNodes,
                mapper.getTypeFactory().constructCollectionType(
                        List.class,
                        mapper.getTypeFactory().constructMapType(Map.class, String.class, String.class)
                )
        );

        // 4. 应用替换规则
        for (Map<String, String> mapping : mappings) {
            for (Map.Entry<String, String> entry : mapping.entrySet()) {
                String jsonPath = entry.getKey(); // 如 "targetAttrs.deviceIndexCode"
                String fieldName = entry.getValue(); // 如 "indexCode"

                applyReplacement(result, devInfo, jsonPath, fieldName);
            }
        }

        return mapper.writeValueAsString(result);
    }

    private static void applyReplacement(ObjectNode root, DevInfo devInfo, String jsonPath, String fieldName) {
        String[] pathSegments = jsonPath.split("\\.");
        ObjectNode current = root;

        try {
            // 遍历路径层级（最后一层前保持ObjectNode）
            for (int i = 0; i < pathSegments.length - 1; i++) {
                String segment = pathSegments[i];
                JsonNode nextNode = current.get(segment);

                if (nextNode == null || !nextNode.isObject()) {
                    // 路径不存在则创建新对象（根据需求决定是否严格校验路径）
                    current.putObject(segment);
                }
                current = (ObjectNode) current.get(segment);
            }

            // 设置最终字段值
            String value = getFieldValue(devInfo, fieldName);
            String lastSegment = pathSegments[pathSegments.length - 1];
            current.put(lastSegment, value);
        } catch (Exception e) {
            throw new RuntimeException("Error applying replacement for path: " + jsonPath, e);
        }
    }

    private static String getFieldValue(DevInfo devInfo, String fieldName) {
        try {
            Field field = DevInfo.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(devInfo);
        } catch (Exception e) {
            throw new RuntimeException("Error accessing field: " + fieldName, e);
        }
    }
}
