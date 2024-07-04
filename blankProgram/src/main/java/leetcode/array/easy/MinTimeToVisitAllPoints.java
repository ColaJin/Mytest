package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1266. 访问所有点的最小时间
 * @Date:2023/12/5
 */
public class MinTimeToVisitAllPoints {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        int rs = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum = Math.max(Math.abs(points[i + 1][0] - points[i][0]), Math.abs(points[i + 1][1] - points[i][1]));
            rs += sum;
        }
        return rs;
    }
}
