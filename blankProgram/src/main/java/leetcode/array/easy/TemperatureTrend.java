package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCP 61.气温变化趋势
 * @Date:2024/8/9
 */
public class TemperatureTrend {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int res = 0;
        int len = temperatureA.length;
        int cur = 0;
        for (int i = 1; i < len; i++) {
            int ta = getTrend(temperatureA[i - 1], temperatureA[i]);
            int tb = getTrend(temperatureB[i - 1], temperatureB[i]);
            if (ta == tb) {
                ++cur;
                res = Math.max(res, cur);
            } else {
                cur = 0;
            }
        }

        return res;
    }

    private int getTrend(int x, int y) {
        if (x == y) {
            return 0;
        }
        return x < y ? 1 : -1;
    }
}
