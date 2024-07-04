package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1800. 最大升序子数组和
 * @Date:2023/12/19
 */
public class MaxAscendingSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,6,10,1,8,9,9,8,9};
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // <=
            if (nums[i] <= nums[i - 1]) {
                // 此处变化了
                sum = 0;
            }
            sum += nums[i];
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
