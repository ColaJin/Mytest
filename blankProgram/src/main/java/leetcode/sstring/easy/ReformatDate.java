package leetcode.sstring.easy;

import java.util.List;

/**
 * @author:jinyandong
 * @description:1507.转变日期格式
 * @Date:2024/8/14
 */
public class ReformatDate {
    public String reformatDate(String date) {
        String[] s = date.split(" ");
        String day = s[0].substring(0, s[0].length() - 2);
        while (day.length() < 2) {
            day = "0" + day;
        }
        String mon = s[1];
        String year = s[2];
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < months.length; i++) {
            if (mon.equals(months[i])) {
                int temp = i + 1;
                if (temp < 10) {
                    mon = "0" + temp;
                } else {
                    mon = "" + temp;
                }
            }
        }

        return year + "-" + mon + "-" + day;
    }
}
