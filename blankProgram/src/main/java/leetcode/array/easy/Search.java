package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:704. 二分查找
 * @Date:2023/8/28
 */
public class Search {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // -1
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{-1,0,3,5,9,12};
        // int[] nums = new int[]{-1,0,3,5,9,12};
        int[] nums = new int[]{5};
        //int[] nums = new int[]{2, 5};
        // int target = 9;
        // int target = 2;
        int target = 5;
        System.out.println(search(nums, target));
    }
}
