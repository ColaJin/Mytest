package leetcode.sstring.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:2068.检查两个字符串是否几乎相等
 * @Date:2024/8/23
 */
public class CheckAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> temp : map1.entrySet()) {
            Character key = temp.getKey();
            Integer value = temp.getValue();
            if (map2.containsKey(key)) {
                Integer count = map2.get(key);
                if (Math.abs(count - value) > 3) {
                    return false;
                }
            }else {
                if (value > 3) {
                    return false;
                }
            }
        }

        for (Map.Entry<Character, Integer> temp : map2.entrySet()) {
            Character key = temp.getKey();
            Integer value = temp.getValue();
            if (map1.containsKey(key)) {
                Integer count = map1.get(key);
                if (Math.abs(count - value) > 3) {
                    return false;
                }
            }else {
                if (value > 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
