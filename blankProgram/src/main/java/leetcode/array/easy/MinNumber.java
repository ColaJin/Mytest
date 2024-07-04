package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2605. 从两个数字数组里生成最小数字
 * @Date:2024/2/2
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,3};
        int[] nums2 = new int[]{5,7};
        System.out.println(minNumber(nums1, nums2));
    }
    public static int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            if (list.contains(i)) {
                return i;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        String temp = (nums1[0] > nums2[0]) ?  (stringBuffer.append(nums2[0]).append(nums1[0]).toString()) : (stringBuffer.append(nums1[0]).append(nums2[0]).toString());
        return Integer.valueOf(temp);
    }
}
