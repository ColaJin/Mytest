package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:3010. 将数组分成最小总代价的子数组 I
 * @Date:2024/8/7
 */
public class MinimumCost3010 {
    public int minimumCost(int[] nums) {
        // toIndex不包含索引
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }
}
