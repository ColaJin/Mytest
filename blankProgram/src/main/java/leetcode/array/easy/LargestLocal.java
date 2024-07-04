package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2373. 矩阵中的局部最大值
 * @Date:2024/1/15
 */
public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] rs = new int[len - 2][len - 2];
        for (int i = 0; i < len - 2; i++) {
            for (int j = 0; j < len - 2; j++) {
                for (int p = i; p < i + 3; p++) {
                    for (int q = j; q < j + 3; q++) {
                        rs[i][j] = Math.max(rs[i][j], grid[p][q]);
                    }
                }
            }
        }
        return rs;
    }
}
