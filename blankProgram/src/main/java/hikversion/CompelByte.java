
package hikversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelByte {
    public static void main(String[] args) {
        Integer num = Integer.valueOf("0");
        String a = "";
        if (num == 0){
            a = "1";
        }
        while (num != 0) {//利用十进制转二进制除2法
            if (num % 2 == 0) {
                a = 1 + a;
            } else {
                a = 0 + a;
            }
            //a = num % 2 + a;
            num = num / 2;
        }

        /*String rs = "";
        for (int i = 0; i < a.length(); i++) {
            Character bit = a.charAt(i);
            if (bit == '0') {
                rs = rs + "1";
            } else {
                rs = rs + "0";
            }
        }*/

        System.out.println(Integer.parseInt(a, 2));
    }
}
