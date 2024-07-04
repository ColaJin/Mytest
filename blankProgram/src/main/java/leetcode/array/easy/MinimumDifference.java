package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1984. 学生分数的最小差值
 * @Date:2023/12/21
 */
public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int rs = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i + k - 1 < len; i++) {
            rs = Math.min(nums[i + k - 1] - nums[i], rs);
        }
        return rs;
    }
}
