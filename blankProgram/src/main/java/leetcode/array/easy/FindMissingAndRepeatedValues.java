package leetcode.array.easy;

import java.util.HashSet;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2965. 找出缺失和重复的数字
 * @Date:2024/8/6
 */
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3}, {2, 2}};
        int[] missingAndRepeatedValues = findMissingAndRepeatedValues(grid);
        for (int missingAndRepeatedValue : missingAndRepeatedValues) {
            System.out.println(missingAndRepeatedValue);
        }
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int len = grid.length;
        int mult = len * len;
        HashSet<Integer> setAll = new HashSet<>();
        for (int i = 0; i < mult; i++) {
            setAll.add(i + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (set.contains(anInt)) {
                    // 重复
                    res[0] = anInt;
                } else {
                    set.add(anInt);
                }
            }
        }
        setAll.removeAll(set);
        for (Integer integer : setAll) {
            res[1] = integer;
        }
        return res;
    }
}
