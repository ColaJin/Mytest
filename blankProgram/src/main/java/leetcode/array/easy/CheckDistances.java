package leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2399. 检查相同字母间的距离
 * @Date:2024/1/17
 */
public class CheckDistances {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, i - map.get(temp) - 1);
            } else {
                map.put(temp, i);
            }
        }

        for (Map.Entry<Character, Integer> temp : map.entrySet()) {
            Integer count = temp.getValue();
            Character key = temp.getKey();
            if (distance[key - 97] != count) {
                return false;
            }
        }
        return true;
    }
}
