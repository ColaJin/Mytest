package leetcode;

/**
 * @author:jinyandong
 * @description:2778. 特殊元素平方和
 * @Date:2024/8/5
 */
public class SumOfSquares {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(sumOfSquares(nums));
    }

    public static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (n % i == 0) {
                res += nums[i - 1] * nums[i - 1];
            }
        }
        return res;
    }
}
