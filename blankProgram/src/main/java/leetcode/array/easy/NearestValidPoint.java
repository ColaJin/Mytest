package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1779. 找到最近的有相同 X 或 Y 坐标的点
 * @Date:2023/12/19
 */
public class NearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int rs = -1;
        int min = Integer.MAX_VALUE;
        int indexMin = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int pass = (Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y));
                if (min > pass) {
                    min = pass;
                    indexMin = i;
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            return indexMin;
        }
        return rs;
    }
}
