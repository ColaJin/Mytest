package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 179.查找总价格为目标值的两个商品
 * @Date:2024/8/12
 */
public class TwoSumLCR179 {
    public int[] twoSum(int[] price, int target) {
        int[] res = new int[2];
        int len = price.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (price[i] + price[j] == target) {
                res[0] = price[i];
                res[1] = price[j];
                return res;
            } else if (price[i] + price[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
