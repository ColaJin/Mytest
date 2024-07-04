package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2176. 统计数组中相等且可以被整除的数对
 * @Date:2023/12/26
 */
public class CountPairs {
    public int countPairs(int[] nums, int k) {
        int rs = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && ((i * j) % k == 0)) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
