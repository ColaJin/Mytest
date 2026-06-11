package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2798. 满足目标工作时长的员工数目
 * @Date:2024/8/6
 */
public class NumberOfEmployeesWhoMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                res++;
            }
        }
        return res;
    }
}
