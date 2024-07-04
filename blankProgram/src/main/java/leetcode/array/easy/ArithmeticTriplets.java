package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2367. 算术三元组的数目
 * @Date:2024/1/15
 */
public class ArithmeticTriplets {
    public static void main(String[] args) {

    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean find = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] - nums[j] == diff) {
                            find = true;
                        }
                    }
                }
            }
            if (find) {
                rs++;
            }
        }
        return rs;
    }

}
