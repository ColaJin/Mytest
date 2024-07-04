package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2006. 差的绝对值为 K 的数对数目
 * @Date:2023/12/22
 */
public class CountKDifference {
    public static void main(String[] args) {

    }

    public int countKDifference(int[] nums, int k) {
        int rs = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((Math.abs(nums[j] - nums[i]) == k)) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
