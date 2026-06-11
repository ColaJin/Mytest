package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:LCP 66.最小展台数量
 * @Date:2024/8/9
 */
public class MinNumBooths {
    public static void main(String[] args) {
        String[] demand = new String[]{"lxutzb", "lweyedayd", "ducohycnm", "h", "pcvcgcykuj", "puqpyzo", "ekg", "cn", "tfrr", "hucfpu"};
        System.out.println(minNumBooths(demand));
    }

    public static int minNumBooths(String[] demand) {
        // 每个字母出现最大频次
        int res = 0;
        Map<Character, Integer> days = new HashMap<>();
        for (String s : demand) {
            Map<Character, Integer> every = new HashMap<>();
            for (char c : s.toCharArray()) {
                Integer temp = every.getOrDefault(c, 0) + 1;
                days.put(c, Math.max(temp, days.getOrDefault(c, 0)));
                every.put(c, temp);
            }
        }
        for (Integer value : days.values()) {
            res += value;
        }
        return res;
    }
}
