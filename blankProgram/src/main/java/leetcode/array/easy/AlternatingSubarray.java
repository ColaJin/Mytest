package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2765. 最长交替子数组
 * @Date:2024/8/5
 */
public class AlternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r < n; r++) {
                int len = r - l + 1;
                if (nums[r] - nums[l] == (len - 1) % 2) {
                    res = Math.max(res, len);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
