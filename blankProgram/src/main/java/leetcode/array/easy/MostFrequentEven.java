package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:2404. 出现最频繁的偶数元素
 * @Date:2024/1/17
 */
public class MostFrequentEven {
    public static void main(String[] args) {

    }

    public int mostFrequentEven(int[] nums) {
        int rs = -1;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            Integer count = temp.getValue();
            if (count > max) {
                rs = temp.getKey();
                max = count;
            } else {
                if (count == max) {
                    rs = Math.min(rs, temp.getKey());
                }
            }

        }
        return rs;
    }

}
