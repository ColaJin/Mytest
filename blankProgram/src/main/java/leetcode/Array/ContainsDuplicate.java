package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicateBySet(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        //数组长度需要减一防止下标越界
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateBySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
