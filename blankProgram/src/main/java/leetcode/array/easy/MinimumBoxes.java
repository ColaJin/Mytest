package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:3074. 重新分装苹果
 * @Date:2024/8/8
 */
public class MinimumBoxes {
    public static void main(String[] args) {
        int[] apple = new int[]{1, 8, 3, 3, 5};
        int[] capacity = new int[]{3, 9, 5, 1, 9};
        System.out.println(minimumBoxes(apple, capacity));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        int res = 0;
        for (int i : apple) {
            sum += i;
        }
        Arrays.sort(capacity);
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum > capacity[i]) {
                res++;
                sum -= capacity[i];
            } else {
                break;
            }
        }
        if (sum > 0) {
            res++;
        }
        return res;
    }
}
