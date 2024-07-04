package hikversion;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Pattern;

/**
 * @author:jinyandong
 * @description:测试String是否是个对象
 * @Date:2023/11/24
 */
public class TestStringisObject {
    public static void main(String[] args) throws JsonProcessingException {
        String s1 = "成功";
        /*// json转换失败
        String s2 = "[{\"data\":\"xxxx\"}]";*/
        String s2 = "{\"data\":\"xxxx\"}";
        /*ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode =objectMapper.readTree(s1);
        if (jsonNode != null){
            System.out.println(" not null");
        }else {
            System.out.println("null");
        }*/
        /*JSONObject jsonValue = JSONObject.parseObject(s1);
        System.out.println(jsonValue);*/
        boolean jsonString = isJsonString(s2);
        System.out.println(jsonString);
        JSONObject jsonValue = JSONObject.parseObject(s2);
        System.out.println(jsonValue);


    }

    public static boolean isJsonString(String str){
        String jsonPattern = "^(\\{|\\[)(\".*?\"\\s*:\\s*(\".*?\"|\\[\\s*\\]|\\{.*?\\}|\\d+)(,\\s*\".*?\"\\s*:\\s*(\".*?\"|\\[\\s*\\]|\\{.*?\\}|\\d+))*\\s*)?(\\}|\\])$";
        return Pattern.matches(jsonPattern,str);
    }
}
