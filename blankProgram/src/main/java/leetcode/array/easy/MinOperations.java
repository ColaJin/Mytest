package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1827. 最少操作使数组递增
 * @Date:2023/12/20
 */
public class MinOperations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 4, 1};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int rs = 0;
        int need = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= need) {
                rs += need - nums[i];
                need++;
            } else {
                need = nums[i] + 1;
            }
        }
        return rs;
    }
}
