package hikversion;

import java.math.BigInteger;
import java.util.UUID;

/**
 * @author:jinyandong
 * @description:测试String Format
 * @Date:2025/1/16
 */
public class TestStringFormat {
    public static void main(String[] args) {
        BigInteger temp = new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16);
        System.out.println(temp);
        String lUUID = String.format("%040d", temp);
        System.out.println(lUUID);

        String raw = "hello";
        String str = String.format("%1$7s", raw);
        String str1 = String.format("%7s", raw);
        // “两个空格hello”
        System.out.println(str);
        System.out.println(str1);

        String driverId = "dac_drv_hiksdk_genneral_1.12.100";
        String version = driverId.substring(driverId.lastIndexOf("_") + 1);
        if (version.matches("^\\d+(\\.\\d+){1,2}$")) {
            System.out.println(version);
            driverId = driverId.substring(0, driverId.lastIndexOf("_"));
            System.out.println(driverId);
        }

    }


}
