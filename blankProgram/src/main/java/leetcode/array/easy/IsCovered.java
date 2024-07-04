package leetcode.array.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:jinyandong
 * @description:1893. 检查是否区域内所有整数都被覆盖
 * @Date:2023/12/20
 */
public class IsCovered {
    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 5;
        System.out.println(isCovered(ranges, left, right));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            }
        });
        /*boolean rs = false;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] <= left && left <= ranges[i][1]) {
                // 左边界
                if (right <= ranges[i][1]) {
                    // 该区间覆盖
                    return true;
                } else {
                    left = ranges[i][1];
                }
            }
        }*/
        int i = 0;
        int j = left;
        while (i < ranges.length && j <= right) {
            if (ranges[i][0] <= j && ranges[i][1] >= j) {
                // 移动left
                j = ranges[i][1] + 1;
                if (j > right) {
                    // 该区间覆盖
                    return true;
                }
            } else if (j < ranges[i][0]) {
                return false;
            } else if (j > ranges[i][1]) {
                // 移动数组
                i++;
            }
        }
        return j > right;
    }
}
