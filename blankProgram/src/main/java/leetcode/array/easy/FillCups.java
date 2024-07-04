package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2335. 装满杯子需要的最短总时长
 * @Date:2023/12/29
 */
public class FillCups {
    public static void main(String[] args) {
        int[] amount = new int[]{5,4,4};
        System.out.println(fillCups(amount));
    }
    public static int fillCups(int[] amount) {
        int rs = 0;
        int sum = Arrays.stream(amount).sum();
        // 需要贪心
        /*while (sum > 0) {
            int cold = amount[0];
            int warm = amount[1];
            int hot = amount[2];
            if (cold > 0 && warm > 0) {
                amount[0]--;
                amount[1]--;
                sum -= 2;
                rs += 1;
            } else if (cold > 0 && hot > 0) {
                amount[0]--;
                amount[2]--;
                sum -= 2;
                rs += 1;
            } else if (warm > 0 && hot > 0) {
                amount[1]--;
                amount[2]--;
                sum -= 2;
                rs += 1;
            } else {
                int res = amount[0] + amount[1] + amount[2];
                sum -= res;
                rs += res;
            }
        }*/
        return rs;
    }
}
