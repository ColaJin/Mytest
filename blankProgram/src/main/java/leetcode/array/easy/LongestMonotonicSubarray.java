package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3095. 或值至少 K 的最短子数组 I
 * @Date:2024/8/8
 */
public class LongestMonotonicSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 3, 2};
        System.out.println(longestMonotonicSubarray(nums));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int n = nums.length;
        int i = 0;
        while (i < n - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }
            int temp = i;
            // 递增是true，递减是false
            boolean inc = nums[i + 1] > nums[i];
            i += 2;
            while (i < n && nums[i] != nums[i - 1] && (nums[i] > nums[i - 1]) == inc) {
                i++;
            }
            res = Math.max(res, i - temp);
            i--;
        }
        return res;
    }
}
