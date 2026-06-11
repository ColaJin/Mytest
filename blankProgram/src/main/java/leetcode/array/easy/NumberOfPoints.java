package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2848. 与车相交的点
 * @Date:2024/8/6
 */
public class NumberOfPoints {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(6);

        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(5);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(4);
        temp3.add(7);

        List<List<Integer>> nums = new ArrayList<>();
        nums.add(temp);
        nums.add(temp1);
        nums.add(temp3);
        System.out.println(numberOfPoints(nums));
    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        // 遍历两个计算差
        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = list.get(0); j <= list.get(1); j++) {
                sets.add(j);
            }
        }
        return sets.size();
    }
}
