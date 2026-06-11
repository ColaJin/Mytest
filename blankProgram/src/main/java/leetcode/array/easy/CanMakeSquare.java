package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3127. 构造相同颜色的正方形
 * @Date:2024/8/8
 */
public class CanMakeSquare {
    public static void main(String[] args) {

    }

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i > 0 && j > 0 && grid[i - 1][j] == grid[i][j - 1] && grid[i][j - 1] == grid[i - 1][j - 1]) {
                    return true;
                }
                if (i < 2 && j < 2 && grid[i][j + 1] == grid[i + 1][j] && grid[i][j + 1] == grid[i + 1][j + 1]) {
                    return true;
                }
                if (i > 0 && j < 2 && grid[i - 1][j] == grid[i][j + 1] && grid[i][j + 1] == grid[i - 1][j + 1]) {
                    return true;
                }
                if (i < 2 && j > 0 && grid[i][j - 1] == grid[i + 1][j] && grid[i + 1][j - 1] == grid[i + 1][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
