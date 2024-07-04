package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1995. 统计特殊四元组
 * @Date:2023/12/21
 */
public class CountQuadruplets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,5};
        System.out.println(countQuadruplets(nums));
    }
    public static int countQuadruplets(int[] nums) {
        int rs = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i + 3 < len; i++) {
            // 计算从i到i+3
            int sum = 0;
            for (int j = i; j < i + 3; j++) {
                sum += nums[j];
            }
            // 在遍历i+3位置到结尾中是否存在等于sum的数
            for (int k = i + 3; k < len; k++) {
                if (nums[k] == sum) {
                    rs++;
                } else if (nums[k] < sum) {
                    // 4元组值小了不必再查了
                    break;
                }
            }
        }
        return rs;
    }
}
