package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1991. 找到数组的中间位置
 * @Date:2023/12/21
 */
public class FindMiddleIndex {
    public int findMiddleIndex(int[] nums) {
        int rs = -1;
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                // 计算1-》结尾是否为0是则返回0
                int temp = sum - nums[0];
                if (temp == 0) {
                    return 0;
                }
            } else if (i == len - 1) {
                // 计算0->当前位置是否为0
                int temp = sum - nums[len - 1];
                if (temp == 0) {
                    return len - 1;
                }
            } else {
                int temp = sum - left - nums[i];
                if (temp == left) {
                    return i;
                }
            }
            left += nums[i];
        }
        return rs;
    }
}
