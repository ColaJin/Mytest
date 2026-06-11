package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2706. 购买两块巧克力
 * @Date:2024/8/5
 */
public class BuyChoco {
    public static void main(String[] args) {
        int[] prices = new int[]{3,2,3};
        int money = 3;
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int min = prices[0] + prices[1];
        if (min > money) {
            return money;
        }
        return money - min;
    }
}
