package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionII {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2, 2};
        int[] rs = intersect(nums1, nums2);
        for (int i : rs) {
            System.out.println(i);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 两次遍历，一次遍历时把数据存储到HashSet中，如果存在第二次遍历时输出
        if (nums1.length < nums2.length) {
            intersection(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] rs = new int[nums1.length + nums2.length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2) {
                rs[index++] = num1;
                // 1和2索引更新否则死循环
                index1++;
                index2++;

            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        // copy到一个新数组
        return Arrays.copyOfRange(rs, 0, index);
    }

    // 哈希表存储数字和出现次数，二次遍历数组，相同时数据数量-1,
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 两次遍历，一次遍历时把数据存储到HashSet中，如果存在第二次遍历时输出
        if (nums1.length < nums2.length) {
            // return 否则没有意义
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            // 默认0啊
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int[] rs = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {

        }


        return Arrays.copyOfRange(rs, 0, index);
    }
}
