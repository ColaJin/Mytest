package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2873. 有序三元组中的最大值 I
 * @Date:2024/8/6
 */
public class MaximumTripletValue {
    public static void main(String[] args) {
        int[] nums = new int[]{1000000,1,1000000};
        System.out.println(maximumTripletValue(nums));
    }
    public static long maximumTripletValue(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    max = Math.max(max, ((long)nums[i] - (long)nums[j]) * (long)nums[k]);
                }
            }
        }
        return max;
    }
}
