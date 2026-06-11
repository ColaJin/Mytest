package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3200.三角形的最大高度
 * @Date:2024/8/8
 */
public class MaxHeightOfTriangle {
    public static void main(String[] args) {
        int red = 2;
        int blue = 4;
        System.out.println(maxHeightOfTriangle(red, blue));
    }

    public static int maxHeightOfTriangle(int red, int blue) {

        return Math.max(getMaxHigh(red,blue),getMaxHigh(blue,red));
    }
    public static int getMaxHigh(int red,int blue) {
        int res = 0;
        int i = 1;
        int j = 2;
        int cur = 1;
        while (red >= 0 && blue >= 0) {
            if (cur % 2 == 1) {
                red -= i;
                i += 2;
            } else {
                blue -= j;
                j += 2;
            }
            if (red >= 0 && blue >= 0) {
                res++;
            }
            cur++;
        }
        return res;
    }
}
