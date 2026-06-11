package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:面试题 08.03.魔术索引
 * @Date:2024/8/12
 */
public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
