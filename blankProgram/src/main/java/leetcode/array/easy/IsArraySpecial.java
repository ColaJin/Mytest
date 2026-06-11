package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3151. 特殊数组 I
 * @Date:2024/8/8
 */
public class IsArraySpecial {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0)){
                return false;
            }
        }
        return true;
    }
}
