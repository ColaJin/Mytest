package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1337. 矩阵中战斗力最弱的 K 行
 * @Date:2023/12/5
 */
public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[] rs = kWeakestRows(mat, 3);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        //输入：mat =
        //[[1,1,0,0,0],
        // [1,1,1,1,0],
        // [1,0,0,0,0],
        // [1,1,0,0,0],
        // [1,1,1,1,1]],
        //k = 3
        //输出：[2,0,3]
        int[] rs = new int[k];
        // 计算整行的实力
        int[][] tempArr = new int[mat.length][2];
        int i = 0;
        // 用多维数组存储，实力和行数
        for (int[] ints : mat) {
            int temp = 0;
            for (int anInt : ints) {
                if (anInt == 0) {
                    break;
                } else {
                    temp++;
                }
            }
            tempArr[i] = new int[]{temp, i};
            i++;
        }
        // 自定义排序
        Arrays.sort(tempArr, (a, b) -> {
            // 根据大小排
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            // 根据行排
            return a[1] - b[1];
        });

        // 返回行信息
        for (int j = 0; j < k; j++) {
            rs[j] = tempArr[j][1];
        }
        return rs;
    }
}
