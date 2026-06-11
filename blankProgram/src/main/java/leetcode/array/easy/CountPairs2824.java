package leetcode.array.easy;

import java.util.List;

/**
 * @author:jinyandong
 * @description:2824. 统计和小于目标的下标对数目
 * @Date:2024/8/6
 */
public class CountPairs2824 {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    res++;
                }
            }
        }
        return res;
    }
}
