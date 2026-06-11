package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCP 06.拿硬币
 * @Date:2024/8/9
 */
public class MinCount {
    public static void main(String[] args) {
        int[] coins = new int[] {4,2,1};
        System.out.println(minCount(coins));
    }
    public static int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            if (coin >= 2) {
                res += coin / 2 + coin % 2;
            } else {
                res += coin % 2;
            }
        }
        return res;
    }
}
