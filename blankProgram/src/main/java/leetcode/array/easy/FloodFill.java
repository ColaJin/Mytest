package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:面试题 08.10.颜色填充
 * @Date:2024/8/12
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int row = image.length;
        int col = image[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == sr && j == sc) {
                    if (j > 0) {
                        // 左
                        image[i][j - 1] = newColor;
                    }
                    if (j < col - 1) {
                        // 右
                        image[i][j + 1] = newColor;
                    }
                    if (i > 0) {
                        // 上
                        image[i - 1][j] = newColor;
                    }
                    if (i < row - 1) {
                        // 下
                        image[i + 1][j] = newColor;
                    }
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
}
