package leetcode.sstring.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1436.旅行终点站
 * @Date:2024/8/14
 */
public class DestCity {
    public String destCity(List<List<String>> paths) {
        // 终点且不重复
        Map<String, Integer> map = new HashMap<>();
        Set<String> end = new HashSet<>();
        for (List<String> path : paths) {
            map.put(path.get(0), map.getOrDefault(path.get(0), 0) + 1);
            map.put(path.get(1), map.getOrDefault(path.get(1), 0) + 1);
            end.add(path.get(1));
        }
        for (String s : end) {
            if (map.get(s) == 1) {
                return s;
            }
        }
        return "";
    }
}
