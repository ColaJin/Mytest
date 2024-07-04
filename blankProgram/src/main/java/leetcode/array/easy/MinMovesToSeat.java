package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2037. 使每位学生都有座位的最少移动次数
 * @Date:2023/12/22
 */
public class MinMovesToSeat {
    public static void main(String[] args) {

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        int rs = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        int len = seats.length;
        for (int i = 0; i < len; i++) {
            rs += Math.abs(seats[i] - students[i]);
        }
        return rs;
    }
}
