package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2815. 数组中的最大数对和
 * @Date:2024/8/6
 */
public class MaxSum {
    public static void main(String[] args) {
        int[] nums = new int[]{112,131,411};
        System.out.println(maxSum(nums));
    }
    public static int maxSum(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int maxi = getMaxDigit(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int maxj = getMaxDigit(nums[j]);
                if (maxi == maxj) {
                    res = Math.max(res, nums[i] + nums[j]);
                }
            }
        }
        return res;
    }

    public static int getMaxDigit(int num) {
        int max = 0;
        while (num > 0) {
            max = Math.max(max, num % 10);
            num /= 10;
        }
        return max;
    }
}
