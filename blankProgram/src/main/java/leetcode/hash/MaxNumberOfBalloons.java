package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        String text = "leetcode";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        // map存储5字母的数字
        // 遍历text计算7个字母的数量的同时计算最小的一个元素的个数
        String str = "ballon";
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> mapT = new HashMap<>();
        for (Character ch : text.toCharArray()) {
            if (map.containsKey(ch)) {
                mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
            }
        }

        if (mapT.size() < 5) {
            // 不同时包括
            return 0;
        }

        for (Character ch : map.keySet()) {
            if (ch == 'l' || ch == 'o') {
                Integer count = mapT.get(ch);
                min = Math.min(min, count / 2);
            } else if (ch == 'b' || ch == 'a' || ch == 'n') {
                min = Math.min(min, mapT.get(ch));
            }
        }

        return min;
    }
}
