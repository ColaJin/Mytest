package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @author:jinyandong
 * @description:测试fastjson的keySet方法
 * @Date:2025/7/30
 */
public class TestKeySet {
    public static void main(String[] args) {
        JSONObject temp = new JSONObject();
        Set<String> keys = temp.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
