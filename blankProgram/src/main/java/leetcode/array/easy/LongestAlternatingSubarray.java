package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2760. 最长奇偶子数组
 * @Date:2024/8/5
 */
public class LongestAlternatingSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5};
        int threshold = 4;
        System.out.println(longestAlternatingSubarray(nums, threshold));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        int n = nums.length;
        for (int l = 0; l < n; l++) {
            for (int r = 0; r < n; r++) {
                if (isSatisfied(nums, l, r, threshold)) {
                    res = Math.max(res,r - l + 1);
                }
            }
        }
        return res;
    }

    public static boolean isSatisfied(int[] nums, int l, int r, int threshold) {
        if (nums[l] % 2 != 0) {
            return false;
        }
        for (int i = l; i <= r; i++) {
            if (nums[i] > threshold || (i < r && nums[i] % 2 == nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }
}
