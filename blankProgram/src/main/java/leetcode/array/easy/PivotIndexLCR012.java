package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:LCR 012.寻找数组的中心下标
 * @Date:2024/8/9
 */
public class PivotIndexLCR012 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
