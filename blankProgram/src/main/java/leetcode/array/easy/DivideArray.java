package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description: 2206. 将数组划分成相等数对
 * @Date:2023/12/27
 */
public class DivideArray {
    public boolean divideArray(int[] nums) {
        int len = nums.length;
        if (len % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
