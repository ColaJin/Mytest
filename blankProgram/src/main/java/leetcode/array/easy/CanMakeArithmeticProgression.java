package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1502. 判断能否形成等差数列
 * @Date:2023/12/13
 */
public class CanMakeArithmeticProgression {
    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int sub = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != sub) {
                return false;
            }
        }
        return true;
    }
}
