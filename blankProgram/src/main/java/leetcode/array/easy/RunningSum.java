package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1480. 一维数组的动态和
 * @Date:2023/12/12
 */
public class RunningSum {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] rs = new int[len];
        int cur = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            rs[cur] = sum;
            cur++;
        }
        return rs;
    }
}
