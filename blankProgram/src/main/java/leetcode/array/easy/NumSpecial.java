package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1582. 二进制矩阵中的特殊位置
 * @Date:2023/12/14
 */
public class NumSpecial {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0, 1}};
        int rs = numSpecial(mat);
        System.out.println(rs);
    }

    public static int numSpecial(int[][] mat) {
        int rs = 0;
        int row = mat.length;
        int col = mat[0].length;
        // 统计行中1的数量是否合格，然后再统计合格的行中列是否合格
        List<Integer> rowOk = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isOk = true;
                if (mat[i][j] == 1) {
                    if (rowOk.contains(i)) {
                        for (int p = 0; p < rowOk.size(); p++) {
                            if (rowOk.get(p) == i) {
                                rowOk.remove(p--);
                                isOk = false;
                            }
                        }
                        // 出现索引越界异常
                        // rowOk.remove(i);
                    } else {
                        rowOk.add(i);
                    }
                }
                if (!isOk) {
                    break;
                }
            }
        }
        for (Integer i : rowOk) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    boolean isOk = true;
                    for (int k = 0; k < row; k++) {
                        if (k != i && mat[k][j] == 1) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        rs++;
                        break;
                    }
                }
            }
        }
        return rs;
    }
}
