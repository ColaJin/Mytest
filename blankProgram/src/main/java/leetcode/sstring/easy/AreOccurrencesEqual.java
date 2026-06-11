package leetcode.sstring.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1941.检查是否所有字符出现次数相同
 * @Date:2024/8/23
 */
public class AreOccurrencesEqual {
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
    }
    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> temp : map.entrySet()) {
            if (count == 0) {
                count = temp.getValue();
            }
            if (count != temp.getValue()) {
                return false;
            }
        }
        return true;
    }
}
