package hikversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试map的containskey
 * @Date:2022/4/26
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> oldMap = new HashMap<>();

        oldMap.put("1", "1111");
        oldMap.put("10", "1111");
        if (oldMap.containsKey("1")) {
            System.out.println(oldMap.get("1"));
        }
    }
}
