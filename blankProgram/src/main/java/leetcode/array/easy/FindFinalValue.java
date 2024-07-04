package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2154. 将找到的值乘以 2
 * @Date:2023/12/26
 */
public class FindFinalValue {
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,6,1,12};
        int original = 3;
        System.out.println(findFinalValue(nums,original));
    }
    public static int findFinalValue(int[] nums, int original) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == original) {
                original = nums[i] * 2;
                i = -1;
            }
            i++;
        }
        return original;
    }
}
