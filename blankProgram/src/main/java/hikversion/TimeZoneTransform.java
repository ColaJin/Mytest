package hikversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author:jinyandong
 * @description:时区转换
 * @Date:2022/2/16
 */
public class TimeZoneTransform {

    private static String dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter,
                                                       TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();

        return getTime(new Date(targetTime), formatter);
    }

    private static String getTime(Date date, DateFormat formatter) {
        return formatter.format(date);
    }

    private static String getTimeZone() {
        Calendar cal = Calendar.getInstance();
        // getOffset will access to offset and contains DaylightTime
        int timeZone = cal.getTimeZone().getOffset(System.currentTimeMillis()) / (3600000);
        if (timeZone >= 0) {
            return String.valueOf("+" + timeZone);
        }
        return String.valueOf(timeZone);
    }

    public static String getGMTTime(Date date, SimpleDateFormat formatter) {
        TimeZone srcTimeZone = TimeZone.getTimeZone("GMT" + getTimeZone());
        TimeZone destTimeZone = TimeZone.getTimeZone("GMT+8");

        return dateTransformBetweenTimeZone(date, formatter, srcTimeZone, destTimeZone);
    }

    public static void main(String[] args) {
         // System.out.println(getGMTTime(new Date(System.currentTimeMillis()), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")));

        /*TimeZone timeZone = TimeZone.getTimeZone("PST");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(2018, 5, 10);// 输出 Sun Jun 10 15:00:00 CST 2018
        //calendar.set(2018, 2, 10); // 输出 Sat Mar 10 16:00:00 CST 2018
        calendar.setTimeZone(timeZone);
        System.out.println(calendar.getTime());*/

        /*TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.setTimeZone(timeZone);

        System.out.println(calendar.getTime());*/

        /*System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")));*/

        SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        // now.setTimeZone(TimeZone.getTimeZone("Africa/Addis_Ababa"));

        System.out.println(now.format(new Date()));
    }
}
