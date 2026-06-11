package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3028.边界上的蚂蚁
 * @Date:2024/8/7
 */
public class ReturnToBoundaryCount {
    public int returnToBoundaryCount(int[] nums) {
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            if (sum == 0) {
                res++;
            }
        }

        return res ;
    }
}
