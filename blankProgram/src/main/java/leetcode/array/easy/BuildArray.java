package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1920. 基于排列构建数组
 * @Date:2023/12/20
 */
public class BuildArray {
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] rs = new int[len];
        for (int i = 0; i < nums.length; i++) {
            rs[i] = nums[nums[i]];
        }
        return rs;
    }
}
