package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2529. 正整数和负整数的最大计数
 * @Date:2024/2/1
 */
public class MaximumCount {
    public int maximumCount(int[] nums) {
        int up = 0;
        int down = 0;
        for (int num : nums) {
            if (num > 0) {
                up++;
            }
            if (num < 0) {
                down++;

            }
        }
        return Math.max(up, down);
    }
}
