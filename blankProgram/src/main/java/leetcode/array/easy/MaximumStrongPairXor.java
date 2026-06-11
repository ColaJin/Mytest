package leetcode.array.easy;

import java.util.List;

/**
 * @author:jinyandong
 * @description:2913. 子数组不同元素数目的平方和 I
 * @Date:2024/8/6
 */
public class MaximumStrongPairXor {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 25, 30};
        System.out.println(maximumStrongPairXor(nums));
    }

    public static int maximumStrongPairXor(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    res = Math.max(nums[i] ^ nums[j], res);
                }
            }
        }
        return res;
    }
}
