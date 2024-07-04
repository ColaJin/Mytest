package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1608. 特殊数组的特征值
 * @Date:2023/12/15
 */
public class SpecialArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 3, 0, 4};
        int rs = specialArray(nums);
        System.out.println(rs);
    }

    public static int specialArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }
}
