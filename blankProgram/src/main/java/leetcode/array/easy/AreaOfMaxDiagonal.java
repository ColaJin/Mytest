package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3000. 对角线最长的矩形的面积
 * @Date:2024/8/7
 */
public class AreaOfMaxDiagonal {
    public static void main(String[] args) {
        int[][] dimensions = new int[][]{{6, 5}, {8, 6}, {2, 10}, {8, 1}, {9, 2}, {3, 5}, {3, 5}};
        System.out.println(areaOfMaxDiagonal(dimensions));
    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        double len = 0;
        for (int i = 0; i < dimensions.length; i++) {
            for (int j = 0; j < dimensions.length; j++) {
                double sqrt = Math.sqrt((Math.pow(dimensions[j][0], 2) + Math.pow(dimensions[j][1], 2)));
                if (sqrt > len) {
                    res = dimensions[j][0] * dimensions[j][1];
                    len = sqrt;
                } else if (sqrt == len) {
                    res = Math.max(dimensions[j][0] * dimensions[j][1], res);
                }
            }
        }
        return res;
    }
}
