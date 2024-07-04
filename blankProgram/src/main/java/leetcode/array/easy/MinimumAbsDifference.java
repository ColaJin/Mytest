package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1200. 最小绝对差
 * @Date:2023/11/28
 */
public class MinimumAbsDifference {
    public static void main(String[] args) {
        int[] arr = new int[]{40,11,26,27,-20};
        List<List<Integer>> lists = minimumAbsDifference(arr);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        // 先要判断最小的绝对值
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - arr[i - 1]);
            if (min >= abs) {
                min = abs;
            }
        }
        // 再去看哪些符合要求
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - arr[i - 1]);
            if (min == abs) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                rs.add(temp);
            }
        }
        return rs;
    }
}
