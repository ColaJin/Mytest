package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2500. 删除每行中的最大值
 * @Date:2024/1/25
 */
public class DeleteGreatestValue {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,4},{3,3,1}};
        System.out.println(deleteGreatestValue(grid));
    }
    public static int deleteGreatestValue(int[][] grid) {
        int rs = 0;
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        int len = grid[0].length;
        for (int j = len - 1; j >= 0; j--) {
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < grid.length; i++)
                if (grid[i][j] > temp){
                temp = grid[i][j];
            }
            rs += temp;
        }

        return rs;
    }
}
