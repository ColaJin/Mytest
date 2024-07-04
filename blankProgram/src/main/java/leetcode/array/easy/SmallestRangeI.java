package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:908. 最小差值 I
 * @Date:2023/8/28
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();


        return max - min > 2 * k ? max - min - 2 * k : 0;
    }

    public static void main(String[] args) {

    }
}
