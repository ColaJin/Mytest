package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2441. 与对应负数同时存在的最大正整数
 * @Date:2024/1/19
 */
public class FindMaxK {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num)&& set.contains(-num)){
                if (max < Math.abs(num)){
                    max =  Math.abs(num);
                }
            }
        }
        return max;
    }
}
