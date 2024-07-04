package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:976. 三角形的最大周长
 * @Date:2023/8/29
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        int rs = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return rs;
    }
}
