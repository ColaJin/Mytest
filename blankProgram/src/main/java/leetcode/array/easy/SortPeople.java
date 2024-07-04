package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2418. 按身高排序
 * @Date:2024/1/17
 */
public class SortPeople {
    public static void main(String[] args) {
        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights = new int[]{180,165,170};
        String[] strings = sortPeople(names, heights);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        String[] rs = new String[len];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(names[i] + "-" + i, heights[i]);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int i = 0;
        for (Map.Entry<String, Integer> entry : list) {
            String key = entry.getKey();
            String[] keys = key.split("-");
            rs[i] = keys[0];
            i++;
        }
        return rs;
    }
}
