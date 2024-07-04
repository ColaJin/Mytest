package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2057. 值相等的最小索引
 * @Date:2023/12/25
 */
public class SmallestEqual {
    public int smallestEqual(int[] nums) {
        int rs = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]){
                return i;
            }
        }
        return rs;
    }
}
