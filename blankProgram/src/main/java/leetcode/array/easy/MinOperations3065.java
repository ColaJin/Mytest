package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:3065. 超过阈值的最少操作数 I
 * @Date:2024/8/7
 */
public class MinOperations3065 {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num < k) {
                res++;
            }
        }
        return res;
    }
}
