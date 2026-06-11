package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3184.构成整天的下标对数目I
 * @Date:2024/8/8
 */
public class CountCompleteDayPairs {
    public int countCompleteDayPairs(int[] hours) {
        int res = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
