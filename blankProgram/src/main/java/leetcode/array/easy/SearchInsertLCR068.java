package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 068.搜索插入位置
 * @Date:2024/8/12
 */
public class SearchInsertLCR068 {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[len - 1]) {
            return len;
        }
        for (int i = 0; i < len; i++) {
            if (target == nums[i]) {
                return i;
            } else if (i > 0 && target > nums[i - 1] && target < nums[i]) {
                res = i;
            }
        }
        return res;
    }
}
