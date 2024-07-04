package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1752. 检查数组是否经排序和轮转得到
 * @Date:2023/12/19
 */
public class Check {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 4};
        boolean check = check(nums);
        System.out.println(check);
    }

    public static boolean check(int[] nums) {
        int len = nums.length;
        int index = 0;
        // 找到分界点
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            return true;
        }
        for (int i = index + 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return nums[0] >= nums[len - 1];
    }
}
