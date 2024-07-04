package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1672. 最富有客户的资产总量
 * @Date:2023/12/18
 */
public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int rs = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            if (rs < sum) {
                rs = sum;
            }
        }
        return rs;
    }
}
