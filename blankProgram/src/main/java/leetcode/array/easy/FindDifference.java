package leetcode.array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2215. 找出两数组的不同
 * @Date:2023/12/27
 */
public class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> rs = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set1Copy = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set2Copy = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        set1Copy.addAll(set1);
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set2Copy.addAll(set2);
        set1.removeAll(set2);
        set2.removeAll(set1Copy);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(set1);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(set2);
        rs.add(list1);
        rs.add(list2);
        return rs;
    }
}
