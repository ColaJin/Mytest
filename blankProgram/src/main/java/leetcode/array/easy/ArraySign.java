package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1822. 数组元素积的符号
 * @Date:2023/12/19
 */
public class ArraySign {
    public static void main(String[] args) {
        int[] nums = new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        /*int temp = 1;
        for (int num : nums) {
            // 超过int最大值
            temp *= num;
        }
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        }
        return 0;*/
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                count++;
            }
        }
        if (count % 2 == 0) {
            return 1;
        }
        return -1;
    }
}
