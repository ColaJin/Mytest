package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2022. 将一维数组转变成二维数组
 * @Date:2023/12/22
 */
public class Construct2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] rs = new int[m][n];
        int len = original.length;
        if (len != m * n) {
            return new int[0][];
        }
        for (int i = 0; i < len; i += n) {
            System.arraycopy(original, i, rs[i / n], 0, n);
        }
        return rs;
    }
}
