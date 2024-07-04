package leetcode.array.easy;

import java.util.HashSet;

/**
 * @author:jinyandong
 * @description:2395. 和相等的子数组
 * @Date:2024/1/17
 */
public class FindSubarrays {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(findSubarrays(nums));
    }

    public static boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int temp = nums[i] + nums[i + 1];

            if (set.contains(temp)) {
                return true;
            } else {
                set.add(temp);
            }
        }

        return false;
    }
}
