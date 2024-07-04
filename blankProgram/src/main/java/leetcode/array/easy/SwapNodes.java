package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1725. 可以形成最大正方形的矩形数目
 * @Date:2023/12/19
 */
public class SwapNodes {
    public int countGoodRectangles(int[][] rectangles) {
        int len = rectangles.length;
        int rs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (rectangles[i][0] < rectangles[i][1]) {
                map.put(rectangles[i][0], map.getOrDefault(rectangles[i][0], 0) + 1);
            } else {
                map.put(rectangles[i][1], map.getOrDefault(rectangles[i][1], 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getKey() > max) {
                max = temp.getKey();
                rs = temp.getValue();
            }
        }
        return rs;
    }
}
