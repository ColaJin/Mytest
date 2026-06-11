package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1154.一年中的第几天
 * @Date:2024/8/14
 */
public class DayOfYear {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int mon = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            ++amount[1];
        }
        int res = 0;
        for (int i = 0; i < mon - 1; i++) {
            res += amount[i];
        }
        return res + day;
    }
}
