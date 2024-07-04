package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1464. 数组中两元素的最大乘积
 * @Date:2023/12/12
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}
