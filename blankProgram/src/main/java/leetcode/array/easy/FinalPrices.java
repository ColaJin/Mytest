package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1475. 商品折扣后的最终价格
 * @Date:2023/12/12
 */
public class FinalPrices {
    public static void main(String[] args) {
        int[] prices = new int[]{10, 1, 1, 6};
        int[] rs = finalPrices(prices);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] rs = new int[len];
        for (int i = 0; i < len; i++) {
            boolean find = false;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    rs[i] = prices[i] - prices[j];
                    find = true;
                    break;
                }
            }
            if (!find) {
                rs[i] = prices[i];
            }
        }
        return rs;
    }
}
