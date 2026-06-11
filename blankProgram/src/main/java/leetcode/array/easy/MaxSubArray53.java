package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:53.最大子数组和
 * @Date:2024/8/12
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
