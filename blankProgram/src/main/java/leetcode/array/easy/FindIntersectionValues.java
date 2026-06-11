package leetcode.array.easy;

import java.util.HashSet;

/**
 * @author:jinyandong
 * @description:2956. 找到两个数组中的公共元素
 * @Date:2024/8/6
 */
public class FindIntersectionValues {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        set.retainAll(set2);
        int count = 0;
        int count2 = 0;
        for (int i : nums1) {
            if (set.contains(i)) {
                count++;
            }
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                count2++;
            }
        }
        res[0] = count;
        res[1] = count2;
        return res;
    }
}
