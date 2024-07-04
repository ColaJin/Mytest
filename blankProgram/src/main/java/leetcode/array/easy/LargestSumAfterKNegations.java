package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1005. K 次取反后最大化的数组和
 * @Date:2023/8/30
 */
public class LargestSumAfterKNegations {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // 所有元素和
        int ans = Arrays.stream(nums).sum();
        for (int i = -100; i < 0; i++) {
            if (freq.containsKey(i)) {
                int ops = Math.min(k, freq.get(i));
                // 负数取反和就*2
                ans += (-i) * ops * 2;
                freq.put(i, freq.get(i) - ops);
                freq.put(-i, freq.getOrDefault(-i, 0) + ops);
                k -= ops;
                if (k == 0) {
                    break;
                }
            }
        }
        if ( k % 2 == 1 && !freq.containsKey(0)) {
            for (int i = 0; i < 100; i++) {
                if (freq.containsKey(i)) {
                    ans -= i * 2;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{4, 2, 3};
        // int[] nums = new int[]{3, -1, 0, 2};
        // int[] nums = new int[]{2, -3, -1, 5, -4};
        int[] nums = new int[]{-2, 9, 9, 8, 4};
        // int k = 1;
        // int k = 3;
        // int k = 2;
        int k = 5;
        System.out.println(largestSumAfterKNegations(nums, k));
    }
}
