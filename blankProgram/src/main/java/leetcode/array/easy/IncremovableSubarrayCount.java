package leetcode.array.easy;

import org.python.antlr.ast.For;

/**
 * @author:jinyandong
 * @description:2970. 统计移除递增子数组的数目 I
 * @Date:2024/8/6
 */
public class IncremovableSubarrayCount {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncreaing(nums, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isIncreaing(int[] nums, int l, int r) {
        // 从1开始
        for (int i = 1; i < nums.length; i++) {
            if ((i >= l && i <= r + 1)) {
                // 下一次循环
                continue;
            }
            // l左面或者r右面的都是递增的
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        if (l - 1 >= 0 && r + 1 < nums.length && nums[r + 1] <= nums[l - 1]) {
            return false;
        }

        return true;
    }
}
