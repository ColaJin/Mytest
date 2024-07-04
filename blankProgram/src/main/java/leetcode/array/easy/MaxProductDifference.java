package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1913. 两个数对之间的最大乘积差
 * @Date:2023/12/20
 */
public class MaxProductDifference {
    public int maxProductDifference(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - 1] * nums[len - 2] - nums[0] * nums[1];
    }
}
