package leetcode.hash;

public class IslandPerimeter {
    public static void main(String[] args) {

    }

    public int islandPerimeter(int[][] grid) {
        // 计算1的格子的数量
        int count1 = 0;
        // 统计相邻的格子的边数量
        int count = 0;
        // 如果一个点的四周结点含有相邻的1那么导致结果会多算2次也就是每个多算了一次，这时候需要-1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 可以优化

                    count1++;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        // 左侧
                        count++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        // 上面
                        count++;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        // 右面
                        count++;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        // 下面
                        count++;
                    }
                }
            }
        }

        return count1 * 4 - count;
    }

    // 上(i-1,j)左(i,j-1)下(i+1,j)右(i,j+1)
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};

    public int islandPerimeterBetter(int[][] grid) {
        int rs = 0;

        // 如果一个点的四周结点含有相邻的1那么导致结果会多算2次也就是每个多算了一次，这时候需要-1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    // 每次清空
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        // <0 >= n到n也是超
                        if (tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length || grid[tx][ty] == 0) {
                            count++;
                        }
                    }
                    rs += count;
                }

            }
        }

        return rs;
    }

}
