package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1748. 唯一元素的和
 * @Date:2023/12/19
 */
public class SumOfUnique {
    public int sumOfUnique(int[] nums) {
        int rs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getValue() == 1) {
                rs += temp.getKey();
            }
        }
        return rs;
    }
}
