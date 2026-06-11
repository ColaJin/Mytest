package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2733. 既不是最小值也不是最大值
 * @Date:2024/8/5
 */
public class FindNonMinOrMax {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[1];
    }
}
