package leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        intersectionBySortPoint(nums1, nums2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 两次遍历，一次遍历时把数据存储到HashSet中，如果存在第二次遍历时输出
        if (nums1.length < nums2.length) {
            // 使得nums1的是较长的一个数组
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }

        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            // 计算相同的数据个数
            if (set.contains(nums2[i])) {
                // 相同的数据不能存两次使用Set
                list.add(nums2[i]);
            }
        }

        int[] rs = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            rs[index] = i;
            index++;
        }

        return rs;

        // 可以优化，两个set集合存储后调用方法，比较大小不满足大小重新调用
        // 方法中再次使用Set存储相同的值，类似后面
        /**
         * if (set1.size() > set2.size()) {
         *             return getIntersection(set2, set1);
         *         }
         */
    }

    // 排序加双指针
    // 数组排序，然后index索引,两个数组分别都有索引，while循环两个满足小于自己长度
    // 判断是否相同，相同的需要判断是否是唯一的
    // 不同分别索引++
    public static int[] intersectionBySortPoint(int[] nums1, int[] nums2) {
        // 两次遍历，一次遍历时把数据存储到HashSet中，如果存在第二次遍历时输出
        if (nums1.length < nums2.length) {
            intersectionBySortPoint(nums2, nums1);
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
                // 保证唯一
                /*if (index == 0 || rs[index - 1] != num1) {
                    rs[index] = num1;
                    index++;
                    // 1和2索引更新
                    index1++;
                    index2++;
                } else {
                    index1++;
                    index2++;
                }*/
                // 可以优化
                if (index == 0 || rs[index - 1] != num1){
                    rs[index++] = num1;
                }
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
        return Arrays.copyOfRange(rs,0,index);
    }

}
