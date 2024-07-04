package hikversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:jinyandong
 * @description:测试返回时区时间
 * @Date:2023/9/21
 */
public class TestZoneTime {
    public static void main(String[] args) throws ParseException {
        String dateStr = "2023-09-21T20:12:00";
        String time = "2016-10-10T20:57:33.000+08:00";
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        //Date date1 = new Date(2023, 9, 21, 20, 12, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date parse = format0.parse(dateStr);
        String dateString = format.format(parse);
        System.out.println(dateString);
        //Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(dateStr.toString());

        //System.out.println(date.toString());

        String year = time.substring(0,4);
        String month = time.substring(5,7);
        String day =  time.substring(8,10);
        String hour = time.substring(11,13);
        String minute = time.substring(14,16);
        String second = time.substring(17,19);

        StringBuffer sb = new StringBuffer();
        sb.append(year);
        sb.append(month);
        sb.append(day);
        sb.append(hour);
        sb.append(minute);
        sb.append(second);

        System.out.println(sb.toString());
    }
}
