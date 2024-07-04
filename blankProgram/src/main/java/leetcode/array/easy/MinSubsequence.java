package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1403. 非递增顺序的最小子序列
 * @Date:2023/12/8
 */
public class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        // 子序列最短到一半->所有
        // 计算所有和
        // 贪心
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (cur > sum - cur){
                break;
            }else {
                cur += nums[i];
                rs.add(nums[i]);
            }
        }
        return rs;
    }
}
