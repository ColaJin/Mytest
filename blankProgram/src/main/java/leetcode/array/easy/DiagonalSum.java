package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1572. 矩阵对角线元素的和
 * @Date:2023/12/14
 */
public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rs = diagonalSum(mat);
        System.out.println(rs);
    }

    public static int diagonalSum(int[][] mat) {
        int rs = 0;
        int len = mat.length;
        // i = j || i + j = len -1
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j || i + j == len - 1) {
                    rs += mat[i][j];
                }
            }
        }
        return rs;
    }
}
