package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1636. 按照频率将数组升序排序
 * @Date:2023/12/18
 */
public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        // 输入：nums = [1,1,2,2,2,3]
        //输出：[3,1,1,2,2,2]
        int len = nums.length;
        int[] rs = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list, (a, b) -> {
            int temp1 = map.get(a);
            int temp2 = map.get(b);
            return temp1 != temp2 ? temp1 - temp2 : b - a;
        });
        for (int i = 0; i < len; i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }
}
