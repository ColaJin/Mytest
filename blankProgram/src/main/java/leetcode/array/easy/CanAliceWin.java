package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:3232.判断是否可以赢得数字游戏
 * @Date:2024/8/8
 */
public class CanAliceWin {
    public boolean canAliceWin(int[] nums) {
        // 计算所有个位数和所有两位数
        int sum = 0;
        int sumD = 0;
        for (int num : nums) {
            if (num <= 9) {
                sumD += num;
            }
            sum += num;
        }
        int temp = sum - sumD;
        if (temp != sumD) {
            return true;
        }
        return false;

    }
}
