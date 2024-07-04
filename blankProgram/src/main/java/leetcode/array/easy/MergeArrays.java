package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2570. 合并两个二维数组 - 求和法
 * @Date:2024/2/2
 */
public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int[] temp : nums1) {
            map1.put(temp[0], map1.getOrDefault(temp[0], 0) + temp[1]);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int[] temp : nums2) {
            map2.put(temp[0], map2.getOrDefault(temp[0], 0) + temp[1]);
        }
        for (Map.Entry<Integer, Integer> temp : map1.entrySet()) {
            map2.merge(temp.getKey(),temp.getValue(),Integer::sum);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map2.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        int[][] rs = new int[map2.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> temp : list) {
            rs[i][0] = temp.getKey();
            rs[i][1] = temp.getValue();
            i++;
        }
        return rs;
    }
}
