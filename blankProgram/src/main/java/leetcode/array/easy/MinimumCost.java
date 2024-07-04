package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2144. 打折购买糖果的最小开销
 * @Date:2023/12/26
 */
public class MinimumCost {
    public int minimumCost(int[] cost) {
        int rs = 0;
        /*int len = cost.length;
        if (len == 2) {
            return cost[0] + cost[1];
        }
        Arrays.sort(cost);
        // 倒数第二个
        int secMax = cost[len - 2];
        // 后两个
        rs += secMax + cost[len - 1];
        // 记录被免费赠送的位置
        List<Integer> list = new ArrayList<>();
        for (int i = len - 3; i >= 0; i--) {
            // 寻找最大的免费赠送的
            if (!list.contains(i)) {
                int index = i;
                while (index >= 0) {
                    if (cost[index] < secMax && !list.contains(index)) {
                        list.add(index);
                        break;
                    }
                    index--;
                }

            }
        }*/

        return rs;
    }
}
