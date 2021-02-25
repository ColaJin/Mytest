package leetcode.Array.easy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class MaxProfitII {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = getMaxProfitByValleyAndPeek(prices);
        System.out.println(maxProfit);
        int maxProfitByViolence = getMaxProfitByViolence(prices, 0);
        System.out.println(maxProfitByViolence);
        int profit = maxProfit(prices);
        System.out.println(profit);
    }


    //未完成：直接比较相邻就可以，没想到
    public static int maxProfit(int[] prices) {
        //数组中的数字存在变大之后变小再变大的数据时才存在多次买入卖出
        //记录最大的利润
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            //需要判断数据是否变小然后调用求最大利润然后计算和
            int j = i + 1;
            if (j < prices.length && prices[j] >= prices[i]) {
                max += prices[j] - prices[i];
            }
        }
        return max;
    }

    //一次遍历
    public static int getMaxProfitByFirstErgodic(int price[]) {
        int max = 0;
        //从1开始然后比较前一个价钱
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                //连续递增连续相加1,2,3过程是2-1+3-2；
                max += price[i] - price[i - 1];
            }
        }
        return max;
    }

    //峰值峰谷计算
    public static int getMaxProfitByValleyAndPeek(int price[]) {
        int max = 0;
        int i = 0;
        int vally = price[0];
        int peek = price[0];
        //判断i+1是否是满足数组长度，否则循环一直进行
        while (i + 1 < price.length) {
            while (i + 1 < price.length && price[i] >= price[i + 1]) {
                //找到峰谷
                i++;
            }
            vally = price[i];
            while (i + 1 < price.length && price[i] <= price[i + 1]) {
                //找到峰顶
                i++;
            }
            peek = price[i];
            //求最大利润
            max += peek - vally;
        }
        return max;
    }

    //暴力求解法：找到所有可以组合的方式计算最大利润，可以再看看？？？
    public static int getMaxProfitByViolence(int prices[], int locate) {
        //大于等于时都是返回0
        if (locate >= prices.length) {
            return 0;
        }
        int max = 0;
        for (int start = locate; start < prices.length; start++) {
            int maxproit = 0;
            for (int i = start + 1; i < prices.length; i++) {

                if (prices[start] < prices[i]) {
                    //计算和，后者为当前的最大利润，前者计算的是之后的最大利润
                    int proit = getMaxProfitByViolence(prices, i + 1) + (prices[i] - prices[start]);
                    if (proit > maxproit) {
                        maxproit = proit;
                    }

                }
            }
            if (maxproit > max) {
                max = maxproit;
            }
        }

        return max;
    }

}
