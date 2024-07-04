package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1710. 卡车上的最大单元数
 * @Date:2023/12/19
 */
public class MaximumUnits {
    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        int rs = maximumUnits(boxTypes, truckSize);
        System.out.println(rs);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int rs = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] boxType : boxTypes) {
            if (truckSize > 0) {
                if (truckSize > boxType[0]) {
                    truckSize -= boxType[0];
                    rs += boxType[1] * boxType[0];
                } else {
                    rs += truckSize * boxType[1];
                    truckSize = 0;
                }
            } else {
                break;
            }
        }
        return rs;
    }
}
