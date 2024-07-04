package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2643. 一最多的行
 * @Date:2024/2/28
 */
public class RowAndMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] rs = new int[2];
        int min = 0;
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                min = i;
            }
        }
        rs[0] = min;
        rs[1] = max;
        return rs;
    }
}
