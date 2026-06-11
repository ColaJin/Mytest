package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2670. 找出不同元素数目差数组
 * @Date:2024/8/5
 */
public class DistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] sufCnt = new int[n + 1];
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            sufCnt[i] = set.size();
        }
        int[] diff = new int[n];
        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            diff[i] = set.size() - sufCnt[i + 1];
        }
        return diff;
    }
}
