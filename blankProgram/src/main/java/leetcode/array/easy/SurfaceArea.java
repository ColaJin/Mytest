package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:892. 三维形体的表面积
 * @Date:2023/8/29
 */
public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        // 防止越界
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int rs = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    // 上下两面
                    rs += 2;
                }
                /*iSur += Math.max(grid[i][j] - grid[i - 1][j], 0);
                iSur += Math.max(grid[i][j] - grid[i + 1][j], 0);
                iSur += Math.max(grid[i][j] - grid[i][j + 1], 0);
                iSur += Math.max(grid[i][j] - grid[i + 1][j + 1], 0);*/
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    int nv = 0;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        nv = grid[nr][nc];
                    }
                    // 边界上的数据nv是0，直接Max(grid[i][j],0)即当前的值
                    rs += Math.max(grid[i][j] - nv, 0);
                }

            }

        }
        return rs;
    }
}
