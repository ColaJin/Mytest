package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:3005. 最大频率元素计数
 * @Date:2024/8/7
 */
public class MaxFrequencyElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1, 4};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        // 计算每个元素出现的次数，记录最大的次数，计算个数
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 1) + 1);
                max = Math.max(map.get(num), max);
            } else {
                map.put(num, 1);
                // 和1比较大小不可=否则重置max
                max = Math.max(max, 1);
            }
        }
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getValue() == max) {
                res += temp.getValue();
            }
        }
        return res;
    }
}
