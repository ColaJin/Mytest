package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2908. 元素和最小的山形三元组 I
 * @Date:2024/8/6
 */
public class MinimumSum {
    public static void main(String[] args) {

    }

    public int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        res = Math.min(nums[i] + nums[j] + nums[k], res);
                    }
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}
