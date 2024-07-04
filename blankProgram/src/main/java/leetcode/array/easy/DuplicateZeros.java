package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1089. 复写零
 * @Date:2023/11/28
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void duplicateZeros(int[] arr) {
        // 给定一个数组，存在0则复写0 [1,0,2,3,0,4,5,0]
        // 双指针
        /*int i = 0;
        int next = -1;
        if (arr.length == 1) {
            return;
        }
        for (; i < arr.length; i++) {
            if (next >= 0) {
                // 前一个是需要复写
                int temp = arr[i];
                arr[i] = next;
                next = temp;
            }else {
                if (arr[i] == 0) {
                    if (i + 1 < arr.length) {
                        if (arr[i + 1] != 0) {
                            next = arr[i + 1];
                        }
                    }
                }
            }
        }*/
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }
}
