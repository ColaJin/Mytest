package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3190.使所有元素可以被3整除的最少操作数
 * @Date:2024/8/8
 */
public class MinimumOperations3190 {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] + 1) % 3 == 0 || (nums[i] - 1) % 3 == 0) {
                res++;
            }
        }
        return res;

    }
}
