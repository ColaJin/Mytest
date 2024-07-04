package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2558. 从数量最多的堆取走礼物
 * @Date:2024/2/1
 */
public class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        long rs = 0l;
        int len = gifts.length;
        while (k > 0) {
            Arrays.sort(gifts);
            gifts[len - 1] = (int) Math.floor(Math.sqrt(gifts[len - 1]));
            k--;
        }
        for (int gift : gifts) {
            rs += gift;
        }
        return rs;
    }
}
