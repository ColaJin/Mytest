package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2475. 数组中不等三元组的数目
 * @Date:2024/1/25
 */
public class UnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]){
                        rs++;
                    }
                }
            }
        }
        return rs;
    }
}
