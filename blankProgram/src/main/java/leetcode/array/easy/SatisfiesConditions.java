package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3142. 判断矩阵是否满足条件
 * @Date:2024/8/8
 */
public class SatisfiesConditions {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1},{2},{3}};
        System.out.println(satisfiesConditions(grid));
    }
    public static boolean satisfiesConditions(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 外面保证全部遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 内部边界处处理判断
                if (i < row -  1 && grid[i][j] != grid[i + 1][j] || j < col - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
