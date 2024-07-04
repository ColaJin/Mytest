package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1491. 去掉最低工资和最高工资后的工资平均值
 * @Date:2023/12/12
 */
public class Average {
    public static void main(String[] args) {
        int[] salary = new int[]{48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000};
        double average = average(salary);
        System.out.println(average);
    }

    public static double average(int[] salary) {
        double rs = 0.0;
        Arrays.sort(salary);
        int len = salary.length;
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            sum += salary[i];
        }
        // 需要强转成double否则小数部分被丢弃
        rs = (double) sum / (len - 2);
        return rs;
    }
}
