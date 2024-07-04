package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:303. 区域和检索 - 数组不可变
 * @Date:2023/8/28
 */
public class NumArray {
    static int[] sums;

    // 前缀和
    public NumArray(int[] nums) {

        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] += nums[i] + sums[i];
        }
    }

    public static int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        new NumArray(nums);
        System.out.println(sumRange(2,5));
    }
}
