package hikversion;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:jinyandong
 * @description:
 * @Date:2022/4/8
 */
public class TestUUID {

    /*private static final String FOURTYZERO = "00000000000000";

    private static AtomicInteger randon1Seed = new AtomicInteger(0);
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        List<String> generate = generate(1);
        for (String s : generate) {
            System.out.println(s);
        }
    }

    public static List<String> generate(Integer count) {
        List<String> result = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            // 14位
            long millis = System.currentTimeMillis();
            StringBuilder sbd = new StringBuilder();
            sbd.append(Long.toString(millis));
            int timeLength = sbd.length();
            if (timeLength > 14) {
                sbd.delete(14, timeLength);
            } else if (timeLength < 14) {
                sbd.insert(0, StringUtils.substring(FOURTYZERO, timeLength));
            }
            int randon1Seed1 = randon1Seed.getAndIncrement();
            int randon1 = randon1Seed1 % 1000000;
            sbd.append(new DecimalFormat("000000").format(randon1));
            result.add(sbd.toString());
        }
        return result;
    }*/
    public static void main(String[] args) {

        String deviceIndexCode = UUID.randomUUID().toString().replace("-", "");
        String deviceIndexCode1 = UUID.randomUUID().toString();
        System.out.println(deviceIndexCode);
        System.out.println(deviceIndexCode1);
    }


}
