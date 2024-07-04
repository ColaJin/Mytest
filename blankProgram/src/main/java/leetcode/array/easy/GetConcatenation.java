package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1929. 数组串联
 * @Date:2023/12/20
 */
public class GetConcatenation {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] rs = new int[2 * len];
        for (int i = 0; i < rs.length; i++) {
            if (i < len) {
                rs[i] = nums[i];
            } else {
                rs[i] = nums[i - len];
            }
        }
        return rs;
    }
}
