package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2032. 至少在两个数组中出现的值
 * @Date:2023/12/22
 */
public class TwoOutOfThree {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,3,2};
        int[] nums2 = new int[]{2,3};
        int[] nums3 = new int[]{3};
        List<Integer> rs = twoOutOfThree(nums1, nums2, nums3);
        for (Integer r : rs) {
            System.out.println(r);
        }
    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> rs = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = nums3.length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            if (!temp.contains(nums1[i])) {
                temp.add(nums1[i]);
            }
        }
        for (int i = 0; i < len2; i++) {
            if (!temp.contains(nums2[i])) {
                temp.add(nums2[i]);
            } else {
                rs.add(nums2[i]);
            }
        }

        for (int i = 0; i < len3; i++) {
            if (temp.contains(nums3[i])) {
                rs.add(nums3[i]);
            }
        }

        return rs;
    }
}
