package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1460. 通过翻转子数组使两个数组相等
 * @Date:2023/12/12
 */
public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
