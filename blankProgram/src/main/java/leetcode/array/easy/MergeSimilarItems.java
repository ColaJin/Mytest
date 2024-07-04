package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2363. 合并相似的物品
 * @Date:2024/1/15
 */
public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> rs = new ArrayList<>();
        /*int len1 = items1.length;
        int len2 = items2.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        if (len1 > len2) {
            for (int[] ints : items1) {
                map1.put(ints[0], ints[1]);
            }

            for (int[] ints : items2) {
                map2.put(ints[0], ints[1]);
            }
        } else {
            for (int[] ints : items2) {
                map1.put(ints[0], ints[1]);
            }

            for (int[] ints : items1) {
                map2.put(ints[0], ints[1]);
            }
        }
        for (Integer key : map1.keySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            if (map2.containsKey(key)) {
                temp.add(map1.get(key) + map2.get(key));
            } else {
                temp.add(map1.get(key));
            }
            rs.add(temp);
        }*/
        // 用一个map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : items1) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        for (int[] ints : items2) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        for (Integer key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            temp.add(map.get(key));
            rs.add(temp);
        }
        Collections.sort(rs, (a, b) -> a.get(0) - b.get(0));
        return rs;
    }
}
