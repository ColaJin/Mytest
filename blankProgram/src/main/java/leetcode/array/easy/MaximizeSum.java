package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2656. K 个元素的最大和
 * @Date:2024/2/28
 */
public class MaximizeSum {
    public int maximizeSum(int[] nums, int k) {
        int rs = 0;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        for (int i = 0; i < k; i++) {
            rs += max + i;
        }
        return rs;
    }
}
