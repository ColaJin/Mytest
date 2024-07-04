package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2574. 左右元素和的差值
 * @Date:2024/2/2
 */
public class LeftRightDifference {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 4, 8, 3};
        int[] rs = leftRightDifference(nums);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int[] rs = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        int temp = 0;
        left[0] = 0;
        for (int i = 1; i < len; i++) {
            temp += nums[i - 1];
            left[i] = temp;
        }
        temp = 0;
        right[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            temp += nums[i + 1];
            right[i] = temp;
        }
        for (int i = 0; i < rs.length; i++) {
            rs[i] = Math.abs(left[i] - right[i]);
        }
        return rs;
    }
}
