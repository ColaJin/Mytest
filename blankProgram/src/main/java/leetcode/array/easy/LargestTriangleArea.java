package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:812. 最大三角形面积
 * @Date:2023/8/28
 */
public class LargestTriangleArea {
    public static double largestTriangleArea(int[][] points) {
        double rs = 0.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    // 遍历每行的行和列,取最小值为最大范围
                    rs = Math.max(rs, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return rs;
    }

    public static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,0},{0,1},{1,0}};
        //int[][] nums = new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(nums));
    }
}
