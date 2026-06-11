package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3038. 相同分数的最大操作数目 I
 * @Date:2024/8/7
 */
public class MaxOperations {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,4,5};
        System.out.println(maxOperations(nums));
    }
    public static int maxOperations(int[] nums) {
        int sum = nums[0] + nums[1];
        int res = 1;
        for (int i = 2; i < nums.length - 1; i += 2) {
            if (nums[i] + nums[i + 1] != sum) {
                break;
            } else {
                res++;
            }
        }
        return res;
    }
}
