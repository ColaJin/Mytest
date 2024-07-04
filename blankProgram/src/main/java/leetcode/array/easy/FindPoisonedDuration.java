package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:495. 提莫攻击
 * @Date:2023/8/28
 */
public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int rs = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                //
                rs += duration;
            } else {
                rs += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return rs;
    }
}
