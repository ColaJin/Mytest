package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:3033. 修改矩阵
 * @Date:2024/8/7
 */
public class ModifiedMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        // 遍历一遍查出每列最大值
        // 遍历设置如果为-1设置为最大值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < col; i++) {
            int max = 0;
            for (int j = 0; j < row; j++) {
                max = Math.max(matrix[j][i], max);
            }
            map.put(i, max);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) {
                    res[i][j] = map.get(j);
                } else {
                    res[i][j] = matrix[i][j];
                }
            }
        }
        return res;
    }
}
