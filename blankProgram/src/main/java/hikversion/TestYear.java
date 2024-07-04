package hikversion;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;

/**
 * @author:jinyandong
 * @description:测试年月日转换成ascii
 * @Date:2023/9/11
 */
public class TestYear {
    public static void main(String[] args) {
        /*Calendar ca = Calendar.getInstance();
        //获取年、月、日、时、分、秒
        int year =ca.get(Calendar.YEAR);
        int month=ca.get(Calendar.MONTH) + 1;
        int day=ca.get(Calendar.DATE);
        int hour=ca.get(Calendar.HOUR_OF_DAY);
        int minute=ca.get(Calendar.MINUTE);
        int second=ca.get(Calendar.SECOND);

        StringBuffer sb = new StringBuffer();
        sb.append(year);
        if (month < 10){
            sb.append("0").append(month);
        }else {
            sb.append(month);
        }

        if (day < 10){
            sb.append("0").append(day);
        }else {
            sb.append(day);
        }

        if (hour < 10){
            sb.append("0").append(hour);
        }else {
            sb.append(hour);
        }
        if (minute < 10){
            sb.append("0").append(minute);
        }else {
            sb.append(minute);
        }

        if (second < 10){
            sb.append("0").append(second);
        }else {
            sb.append(second);
        }

        byte[] timeBytes = sb.toString().getBytes();

        int i = 0;*/

        String tmp = "20230911160510";
        String year = tmp.substring(0, 4);
        String mon = tmp.substring(4, 6);
        String day = tmp.substring(6, 8);
        String hour = tmp.substring(8, 10);
        String min = tmp.substring(10, 12);
        String sec = tmp.substring(12, 14);
        StringBuffer sb = new StringBuffer();
        sb.append(year).append("年");
        if (mon.startsWith("0")) {
            sb.append(mon.substring(1, 2)).append("月");
        } else {
            sb.append(mon).append("月");
        }
        if (day.startsWith("0")) {
            sb.append(day.substring(1, 2)).append("日");
        } else {
            sb.append(day).append("日");
        }
        if (hour.startsWith("0")) {
            sb.append(hour.substring(1, 2)).append("时");
        } else {
            sb.append(hour).append("时");
        }
        if (min.startsWith("0")) {
            sb.append(min.substring(1, 2)).append("分");
        } else {
            sb.append(min).append("分");
        }
        if (sec.startsWith("0")) {
            sb.append(sec.substring(1, 2)).append("秒");
        } else {
            sb.append(sec).append("秒");
        }
        System.out.println(sb.toString());
    }
}
