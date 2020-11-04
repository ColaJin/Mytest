package leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{2,4,1};
        int rs = maxProfitFix(prices);
        System.out.println(rs);
    }

    public static int maxProfit(int[] prices) {
        int rs = Integer.MIN_VALUE;
        //记录买入最小值
        int min = Integer.MAX_VALUE;

        int minLoacte = 0;
        int max = Integer.MIN_VALUE;
        //遍历数组先找到最小的值(存在问题，最小值是最后一位，但是前面的值大例如2,4,1)对应的索引+1就是第几天买入
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == min) {
                minLoacte = i;
                break;
            }
        }


        //计算买入索引的位置的值与卖出索引位置的值的差为最大利润
        //不是从min+1位置，而是从min所在的位置
        for (int i = minLoacte + 1; i < prices.length; i++) {
            //从索引位置开始遍历查询最大的数字，索引位置+1就是第几天卖出
            max = Math.max(max, prices[i]);
            //此处是-最小值
            rs = Math.max(rs, prices[i] - min);
        }
        if (rs > 0) {
            return rs;
        } else {
            return 0;
        }
    }

    //暴力法
    public static int maxProfitFix(int[] prices) {
        //计算数组两个值的差，然后取最大值
        int rs = Integer.MIN_VALUE;
        //
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                rs = Math.max(rs,prices[j]-prices[i]);
            }
        }
        if (rs > 0) {
            return rs;
        } else {
            return 0;
        }

    }

    //动态规划思想
    public static int maxProfitDynamic(int[] prices) {
        //数组中的数字存在变大之后变小再变大的数据时才存在多次买入卖出
        //动态规划
        //记录最小的买入值
        int min = Integer.MAX_VALUE;
        //记录最大的利润
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                //找到最小值
                min = prices[i];
            } else if (prices[i] - min > max) {
                //判断条件最小值如果在后面的情况例如2,4,1,此时1为最小值
                // 但是最大利润max为2，1-min(此时为1)为0不大于max所以max是2
                max = prices[i] - min;
            }
        }
        return max;
    }

}
