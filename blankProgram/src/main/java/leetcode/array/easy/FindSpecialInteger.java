package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1287. 有序数组中出现次数超过25%的元素
 * @Date:2023/12/5
 */
public class FindSpecialInteger {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int rs = 0;
        // 计算达到25%的值
        int length = arr.length;
        int up = length / 4;
        // 遍历arr
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
            if (map.get(i) > up) {
                return i;
            }
        }
        return rs;
    }
}
