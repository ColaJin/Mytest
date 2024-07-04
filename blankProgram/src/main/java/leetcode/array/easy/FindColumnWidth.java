package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2639. 查询网格图中每一列的宽度
 * @Date:2024/2/28
 */
public class FindColumnWidth {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1},{22},{333}};
        int[] rs = findColumnWidth(grid);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }

    public static int[] findColumnWidth(int[][] grid) {
        int row = grid[0].length;
        int[] rs = new int[row];
        /*for (int i = 0; i < row; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max,String.valueOf(grid[i][j]).length());
            }
            rs[i] = max;
        }*/
        for (int j = 0; j < row; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, String.valueOf(grid[i][j]).length());
            }
            rs[j] = max;
        }
        return rs;
    }
}
