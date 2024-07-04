package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2133. 检查是否每一行每一列都包含全部整数
 * @Date:2023/12/26
 */
public class CheckValid {
    public boolean checkValid(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            int[] row = matrix[i];
            for (int temp : row) {
                if (list.contains(temp)) {
                    return false;
                } else {
                    list.add(temp);
                }
            }
            List<Integer> listCol = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (listCol.contains(matrix[j][i])) {
                    return false;
                } else {
                    listCol.add(matrix[j][i]);
                }
            }

        }
        return true;
    }
}
