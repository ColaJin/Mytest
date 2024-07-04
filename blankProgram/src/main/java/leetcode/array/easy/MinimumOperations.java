package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2357. 使数组中所有元素都等于零
 * @Date:2023/12/29
 */
public class MinimumOperations {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,0,3,5};
        int i = minimumOperations(nums);
        System.out.println(i);
    }
    public static int minimumOperations(int[] nums) {
        int rs = 0;
        int sum = Arrays.stream(nums).sum();
        while (sum != 0){
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                nums[i] -= nums[0];
            }
            sum = Arrays.stream(nums).sum();
        }
        return rs;
    }
}
