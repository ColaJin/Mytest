package leetcode.array.easy;

import java.util.HashSet;

/**
 * @author:jinyandong
 * @description:2996. 大于等于顺序前缀和的最小缺失整数
 * @Date:2024/8/7
 */
public class MissingInteger {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(sum)) {
            sum++;
        }
        return sum;
    }
}
