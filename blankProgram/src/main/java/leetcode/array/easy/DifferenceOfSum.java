package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2535. 数组元素和与数字和的绝对差
 * @Date:2024/2/1
 */
public class DifferenceOfSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,15,6,3};
        System.out.println(differenceOfSum(nums));
    }
    public static int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;
        for (int num : nums) {
            sum+=num;
            String temp = String.valueOf(num);
            for (char c : temp.toCharArray()) {
                digitSum += Character.getNumericValue(c);
            }
        }
        return Math.abs(digitSum - sum);
    }
}
