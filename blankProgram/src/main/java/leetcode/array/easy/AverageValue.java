package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2455. 可被三整除的偶数的平均值
 * @Date:2024/1/25
 */
public class AverageValue {
    public int averageValue(int[] nums) {
        int rs = 0;
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        if (count != 0) {
            rs = (int) Math.floor(sum / count);
        }
        return rs;
    }
}
