package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:883. 三维形体投影面积
 * @Date:2023/8/29
 */
public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        int rs = 0;
        int yzArea = 0, zxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    // xy投影
                    rs++;
                }
                // 查找最大的yz和xz投影
                yzHeight = Math.max(grid[j][i], yzHeight);
                zxHeight = Math.max(grid[i][j], zxHeight);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return rs + yzArea + zxArea;
    }
}
