package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2319. 判断矩阵是否是一个 X 矩阵
 * @Date:2023/12/29
 */
public class CheckXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == j || i + j == len - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
