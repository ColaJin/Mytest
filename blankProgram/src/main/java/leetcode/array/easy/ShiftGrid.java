package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1260. 二维网格迁移
 * @Date:2023/12/4
 */
public class ShiftGrid {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> lists = shiftGrid(grid, 1);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> rs = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        /*int[][] temp = new int[m][n];
        int total = m * n;
        for (int i = 0; i < m; i++) {
            *//*for (int j = 0; j < n; j++) {
                //System.out.println(grid[i][j]);
            }*//*
        }*/
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp.add(grid[i][j]);
            }
        }
        // 移动k次
        for (int i = 0; i < k; i++) {
            temp.add(0, temp.remove(temp.size() - 1));
        }
        for (int j = 0; j < temp.size(); ) {
            List<Integer> row = new ArrayList<>();
            for (int p = 0; p < n; p++) {
                row.add(temp.get(j));
                // 变换每行的n
                j++;
            }
            rs.add(row);
        }
        return rs;
    }
}
