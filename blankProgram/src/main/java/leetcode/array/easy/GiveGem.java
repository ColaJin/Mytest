package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:LCP 50.宝石补给
 * @Date:2024/8/9
 */
public class GiveGem {
    public int giveGem(int[] gem, int[][] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            int give = operations[i][0];
            int save = operations[i][1];
            int half = gem[give] / 2;
            gem[give] -= half;
            gem[save] += half;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }
}
