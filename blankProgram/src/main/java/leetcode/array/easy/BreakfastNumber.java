package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:LCP 18.早餐组合
 * @Date:2024/8/9
 */
public class BreakfastNumber {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        for (int i = 0; i < staple.length; i++) {
            for (int j = 0; j < drinks.length; j++) {
                if (staple[i] + drinks[j] <= x) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
