package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:3046. 分割数组
 * @Date:2024/8/7
 */
public class IsPossibleToSplit {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,4};
        System.out.println(isPossibleToSplit(nums));
    }
    public static boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > 2) {
                return false;
            }
        }
        return true;
    }
}
