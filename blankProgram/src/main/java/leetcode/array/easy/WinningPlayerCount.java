package leetcode.array.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:3238.求出胜利玩家的数目
 * @Date:2024/8/9
 */
public class WinningPlayerCount {
    public static void main(String[] args) {
        int[][] pick = new int[][]{{0, 2}, {0, 7}, {1, 5}, {0, 5}, {1, 2}, {0, 6}, {1, 2}, {1, 5}, {1, 4}, {0, 7}};
        int n = 2;
        System.out.println(winningPlayerCount(n, pick));
    }

    public static int winningPlayerCount(int n, int[][] pick) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < pick.length; j++) {
                if (pick[j][0] == i) {
                    map.put(pick[j][1], map.getOrDefault(pick[j][1], 0) + 1);
                }
            }
            if (i == 0 && map.size() > 0) {
                res++;
            } else {
                for (Map.Entry<Integer, Integer> mapT : map.entrySet()) {
                    Integer value = mapT.getValue();
                    if (value >= i + 1) {
                        res++;
                        // 跳出已满足要求
                        break;
                    }
                }
            }
        }
        return res;
    }
}
