package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @author:jinyandong
 * @description:测试json转换成set
 * @Date:2024/1/12
 */
public class TestJsonToSet {
    public static void main(String[] args) {
        String events = "[\"1441795\",\"1441797\"]";
        Set<String> set = JSONObject.parseObject(events, Set.class);
        System.out.println(JSONObject.toJSONString(set));
    }
}
