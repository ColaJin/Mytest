package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2540. 最小公共值
 * @Date:2024/2/1
 */
public class GetCommon {
    public int getCommon(int[] nums1, int[] nums2) {
        int rs = -1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                return i;
            }
        }
        return rs;
    }
}
