package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1619. 删除某些元素后的数组均值
 * @Date:2023/12/15
 */
public class TrimMean {
    public static void main(String[] args) {

    }

    public double trimMean(int[] arr) {
        double rs = 0.0;
        Arrays.sort(arr);
        int len = arr.length;
        int temp = 0;
        int count = 0;
        // 位置前5%和后5%之间的
        for (int i = len / 20; i < len * 19 / 20; i++) {
            temp += arr[i];
            count++;
        }
        rs = (double) temp / count;
        return rs;
    }
}
