package hikversion.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:
 * @Date:2023/6/12
 */
public class TestunescapeJava {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        String s1 = "{\"deviceIndexCode\":\"54321\",\"ECC\":0,\"serviceCode\":\"\",\"description\":\"\",\"indexCode\":\"95c2c332c6614ab6a0fb23e60ce4f9c7\",\"userName\":\"\",\"StopBit\":0,\"SerialAddrCode\":\"\",\"domainId\":0,\"manufacturer\":\"hikvision\",\"brokerUrl\":\"\",\"protocol\":\"activemq_reg\",\"password\":\"\",\"SerialPort\":0,\"channels\":[],\"port\":0,\"BaudRate\":0,\"serverType\":0,\"name\":\"54321\",\"topicName\":\"\",\"addr\":\"0.0.0.0\",\"DataBit\":0,\"addrType\":200}";
        String unescaped = StringEscapeUtils.unescapeJava(s1.substring(1, s1.length() - 1));
        String unescapeValue = StringEscapeUtils.unescapeJava(JSON.toJSONString(s1));
        Map<String, Object> pDevInfoMap = JSONObject.parseObject(unescapeValue.substring(1, unescapeValue.length() - 1), Map.class);
        //Map<String, Object> pDevInfoMap = (Map<String, Object>) jsonToMap(unescaped);
        System.out.println("result:"+JSONObject.toJSONString(pDevInfoMap));
        String s = pDevInfoMap.get("indexCode").toString();
        String deviceIndexCode = pDevInfoMap.get("deviceIndexCode").toString();

        System.out.println(s);
        System.out.println(deviceIndexCode);
    }
    public static Map<?, ?> jsonToMap(String json) {
        return (Map)json2Object(json, Map.class);
    }

    public static <T> T json2Object(String json, Class<T> cls) {
        T result = null;

        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            result = objectMapper.readValue(json, cls);
        } catch (IOException var4) {
            System.out.println(var4);
        }

        return result;
    }
}
