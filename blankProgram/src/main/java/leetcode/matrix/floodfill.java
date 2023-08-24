package leetcode.matrix;

/**
 * @author
 * @description:733.图像渲染
 * @Date:2021/7/21
 */
public class floodfill {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newcolor = 2;
        floodFill(image, sr, sc, newcolor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 判断元素的上下左右是不是1是1的话递归他的上下左右并设置为新颜色，否则不设置
        image[sc][sr] = newColor;
        // 此时导致返回原始的位置也就是1,1->0,1->1,1....
        if (sr - 1 >= 0) {
            // 上
            floodFill(image, sr - 1, sc, newColor);
        }
        if (sr + 1 < image.length) {
            // 下
            floodFill(image, sr + 1, sc, newColor);
        }
        if (sc - 1 >= 0) {
            // 左
            floodFill(image, sr, sc - 1, newColor);
        }
        if (sc + 1 < image[0].length) {
            // 右
            floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }

    // 广度优先遍历
    // dx，dy，curcolor == newcolor 返回
    // 队列存储int[]{mx,my}
}
