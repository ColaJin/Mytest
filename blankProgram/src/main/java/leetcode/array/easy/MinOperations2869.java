package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2869. 收集元素的最少操作次数
 * @Date:2024/8/6
 */
public class MinOperations2869 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(1);
        nums.add(5);
        nums.add(4);
        nums.add(2);
        int k = 2;
        System.out.println(minOperations(nums, k));
    }
    public static int minOperations(List<Integer> nums, int k) {
        int res = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(i + 1);
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (temp.contains(nums.get(i))){
                // 移除
                temp.remove(nums.get(i));
            }
            if (temp.size() == 0){
                res++;
                break;
            }
            res++;
        }
        return res;
    }
}
