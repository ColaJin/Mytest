package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1365. 有多少小于当前数字的数字
 * @Date:2023/12/7
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 输入：nums = [8,1,2,2,3]
        // 输出：[4,0,1,1,3]
        // 统计每个数字的出现的次数，计算值
        int length = nums.length;
        int[] rs = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
                if (temp.getKey() < nums[i]) {
                    count += temp.getValue();
                }
            }
            rs[i] = count;
        }
        return rs;
    }
}
