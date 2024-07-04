package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2644. 找出可整除性得分最大的整数
 * @Date:2024/2/28
 */
public class MaxDivScore {
    public static void main(String[] args) {
        int[] nums = new int[]{12};
        int[] divisors = new int[]{10,16};
        System.out.println(maxDivScore(nums, divisors));
    }
    public static int maxDivScore(int[] nums, int[] divisors) {
        int rs = 0;
        int max = 0;
        Arrays.sort(divisors);
        for (int i = 0; i < divisors.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    count ++;
                }
            }
            if (max < count) {
                max = count;
                rs = divisors[i];
            }
        }
        if (rs == 0) {
            return divisors[0];
        }
        return rs;
    }
}
