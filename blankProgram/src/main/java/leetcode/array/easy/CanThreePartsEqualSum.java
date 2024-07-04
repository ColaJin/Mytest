package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1013. 将数组分成和相等的三个部分
 * @Date:2023/8/30
 */
public class CanThreePartsEqualSum {
    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        // 值
        int avg = sum / 3;
        if (sum % 3 != 0) {
            return false;
        }
        int i = 0;
        int sum1 = 0;

        for (int k = 0; k < arr.length; k++) {
            sum1 += arr[k];
            if (sum1 == avg) {
                i = k;
                break;
            }
        }
        if (sum1 != avg) {
            // 计算所有没有达到平均值
            return false;
        }
        sum1 = 0;
        for (int k = i + 1; k < arr.length; k++) {
            sum1 += arr[k];
            if (sum1 == avg) {
                if (k <= arr.length - 2) {
                    return true;
                }
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-9, -8, -8, 6, -10, 8, -2, -3, 9, 4, -2, 1, 7, 8, 6, -4, 5, 5, -2, -8, 4, 7, 3, -4, 4, 5, 2, 8, 3, -5};
        System.out.println(canThreePartsEqualSum(arr));
    }
}
