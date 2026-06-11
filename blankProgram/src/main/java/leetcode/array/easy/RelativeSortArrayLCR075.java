package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:LCR 075.数组的相对顺序
 * @Date:2024/8/12
 */
public class RelativeSortArrayLCR075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;

        for (int i : arr1) {
            upper = Math.max(upper, i);
        }
        int[] frequency = new int[upper + 1];
        for (int i : arr1) {
            ++frequency[i];
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int temp = arr2[i];
            for (int j = 0; j < frequency.length; j++) {
                res[index++] = temp;
            }
            frequency[i] = 0;
        }
        for (int i = 0; i < upper; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                res[index++] = i;
            }
        }
        return res;
    }
}
