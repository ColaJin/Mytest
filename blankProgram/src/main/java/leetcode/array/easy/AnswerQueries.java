package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2389. 和有限的最长子序列
 * @Date:2024/1/17
 */
public class AnswerQueries {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,1};
        int[] queries = new int[]{3,10,21};
        int[] rs = answerQueries(nums, queries);
        for (int r : rs) {
            System.out.println(r);
        }
    }
    public static int[] answerQueries(int[] nums, int[] queries) {
        int len = queries.length;
        int numLen = nums.length;
        Arrays.sort(nums);
        int[] rs = new int[len];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < queries.length; i++) {
            int temp = sum;
            for (int j = numLen - 1; j >= 0; j--) {
                if (temp <= queries[i]) {
                    rs[i] = j + 1;
                    break;
                } else {
                    temp -= nums[j];
                }
            }
        }
        return rs;
    }
}
