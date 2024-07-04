package leetcode.array.easy;

import java.util.Map;

/**
 * @author:jinyandong
 * @description:598.范围求和 II
 * @Date:2023/8/28
 */
public class MaxCount {
    public static int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minLine = n;
        for (int i = 0; i < ops.length; i++) {
            // 遍历每行的行和列,取最小值为最大范围
            minRow = Math.min(minRow, ops[i][0]);
            minLine = Math.min(minLine, ops[i][1]);
            // System.out.println(ops[i][0]);
            // System.out.println(ops[i][1]);
        }
        return minRow * minLine;
    }

    public static void main(String[] args) {
        int[][] ops = new int[][]{{20, 10}, {26, 11}, {2, 11}, {4, 16}, {2, 3}, {23, 13}, {7, 15}, {11, 11}, {25, 13}, {11, 13}, {13, 11}, {13, 16}, {26, 17}};
        int m = 26;
        int n = 17;
        System.out.println(maxCount(m, n, ops));
    }
}
