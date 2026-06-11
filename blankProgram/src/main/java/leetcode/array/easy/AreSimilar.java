package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2946. 循环移位后的矩阵相似检查
 * @Date:2024/8/6
 */
public class AreSimilar {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{2, 2}, {25, 23}, {4, 4}};
        int k = 35;
        System.out.println(areSimilar(mat, k));
    }

    public static boolean areSimilar(int[][] mat, int k) {
        // 遍历每一个数组之后比较每一行
        for (int i = 0; i < mat.length; i++) {
            int[] temp = mat[i];
            List<Integer> list = new ArrayList<>();
            for (int i1 : temp) {
                list.add(i1);
            }
            if (i % 2 == 0) {
                // 偶数左移k
                shiftLeft(temp, k);
                // 判断是否相等
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] != list.get(j)) {
                        return false;
                    }
                }
            } else {
                // 右移k
                shiftArrayRight(temp, k);
                // 判断是否相等
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] != list.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] shiftLeft(int[] arr, int k) {
        while (k > 0) {
            int temp = arr[0]; // 存储最前面的元素
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1]; // 后面的元素向前移动
            }
            arr[arr.length - 1] = temp; // 将最前面的元素放到最后
            k--;
        }
        return arr;
    }

    public static int[] shiftArrayRight(int[] arr, int k) {
        while (k > 0) {
            int temp = arr[arr.length - 1];// 存储最后面的元素
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];// 前面的元素向后移动
            }
            arr[0] = temp;// 最后面的元素放到最前面

            k--;
        }
        return arr;
    }
}
