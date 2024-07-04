package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1512. 好数对的数目
 * @Date:2023/12/13
 */
public class NumIdenticalPairs {
    public static void main(String[] args) {

    }

    public int numIdenticalPairs(int[] nums) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
