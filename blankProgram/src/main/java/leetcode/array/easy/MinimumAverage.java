package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:3194.最小元素和最大元素的最小平均值
 * @Date:2024/8/8
 */
public class MinimumAverage {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double[] temp = new double[n / 2];
        int i = 0;
        int j = n - 1;
        int cur = 0;
        while (i < j) {
            temp[cur] = ((double) nums[i] + (double) nums[j]) / 2;
            i++;
            j--;
            cur++;
        }
        Arrays.sort(temp);
        return temp[0];
    }
}
