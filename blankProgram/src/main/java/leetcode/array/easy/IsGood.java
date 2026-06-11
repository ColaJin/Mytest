package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2784. 检查数组是否是好的
 * @Date:2024/8/5
 */
public class IsGood {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] + 1 != nums.length) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        if (nums[n - 2] != nums[n - 1]) {
            return false;
        }
        return true;
    }
}
