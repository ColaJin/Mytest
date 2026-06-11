package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:3131. 找出与数组相加的整数 I
 * @Date:2024/8/8
 */
public class AddedInteger {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}
