package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2099. 找到和最大的长度为 K 的子序列
 * @Date:2023/12/25
 */
public class MaxSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{-16, -13, 8, 16, 35, -17, 30, -8, 34, -2, -29, -35, 15, 13, -30, -34, 6, 15, 28, -23, 34, 28, -24, 15, -17, 10, 31, 32, -3, -36, 19, 31, -5, -21, -33, -18, -23, -37, -15, 12, -28, -40, 1, 38, 38, -38, 33, -35, -28, -40, 4, -15, -29, -33, -18, -9, -29, 20, 1, 36, -8, 23, -34, 16, -7, 13, 39, 38, 7, -7, -10, 30, 9, 26, 27, -37, -18, -25, 14, -36, 23, 28, -15, 35, -9, 1};
        int k = 8;
        int[] rs = maxSubsequence(nums, k);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int[] rs = new int[k];
        int[] rs1 = new int[k];
        // 原数组顺序
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int len = nums.length;
        int apart = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                apart = i;
                break;
            }
        }
        if (k > len - apart) {
            System.arraycopy(nums, apart - (k - (len - apart)), rs, 0, k - (len - apart));
            System.arraycopy(nums, apart, rs, k - (len - apart), len - apart);
        } else {
            System.arraycopy(nums, len - k, rs, 0, k);
        }

        // 不能用list，重复数据需要用map
        /*List<Integer> list = new ArrayList<>();
        for (int r : rs) {
            list.add(r);
        }*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int r : rs) {
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        int index = 0;
        for (int i : temp) {
            // <k 重复导致数组下标越界
            if (map.containsKey(i) && index < k) {
                Integer count = map.get(i);
                if (count > 0) {
                    rs1[index++] = i;
                    count--;
                    map.put(i, count);
                }
            }
        }
        return rs1;
    }
}
