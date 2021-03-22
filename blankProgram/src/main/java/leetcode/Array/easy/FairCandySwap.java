package leetcode.Array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{2, 3};
        int[] rs = fairCandySwapBetter(A, B);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        //计算两个数组的和然后/2即每个数组中最大的糖果大小
        //分别遍历数组计算
        int[] rs = new int[2];
        int sumLef = 0;
        int sumRigth = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sumLef += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumRigth += B[i];
        }

        sum = (sumLef + sumRigth) / 2;
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < B.length) {
                if (sumLef - sum - A[i] + B[j] == 0) {
                    rs[0] = A[i];
                    rs[1] = B[j];
                    return rs;
                }
                j++;
            }

        }

        for (int i = 0; i < B.length; i++) {
            int j = 0;
            while (j < A.length) {
                if (sumRigth - sum + A[j] - B[i] == 0) {
                    //直接返回
                    rs[0] = A[j];
                    rs[1] = B[i];
                    return rs;

                }
                j++;
            }

        }
        return rs;
    }

    //优化 sumA-A[i]+B[j]=sumB+A[i]-B[j]
    //Set存储A[i],遍历数组B满足条件时判断Set存储A返回A[i]和B[j]
    //数组求和Arrays.stream(A).sum();

    public static int[] fairCandySwapBetter(int[] A, int[] B) {
        //计算两个数组的和然后/2即每个数组中最大的糖果大小
        //分别遍历数组计算
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int temp = (sumA - sumB) / 2;
        int[] rs = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            //先计算
            int sum = B[i] + temp;
            if (set.contains(sum)) {

                rs[0] = sum;
                rs[1] = B[i];
            }
        }

        return rs;
    }
}
