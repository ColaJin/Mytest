package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1979. 找出数组的最大公约数
 * @Date:2023/12/21
 */
public class FindGCD {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int i0 = nums[0];
        int in = nums[nums.length - 1];
        while (in != 0){
            int temp = i0% in;
            i0 = in;
            in = temp;
        }
        return i0;
    }
}
