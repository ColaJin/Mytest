package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:169.多数元素
 * @Date:2024/8/12
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int temp = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > temp) {
                return num;
            }
        }
        return 0;
    }
}
