package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2980. 检查按位或是否存在尾随零
 * @Date:2024/8/7
 */
public class HasTrailingZeros {
    public boolean hasTrailingZeros(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] | nums[j];
                if (Integer.toBinaryString(temp).endsWith("0")) {
                    return true;
                }
            }
        }
        return false;
    }
}
