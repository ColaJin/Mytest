package hikversion;

import java.math.BigDecimal;

/**
 * @author:jinyandong
 * @description:测试Int转double
 * @Date:2023/9/4
 */
public class TestIntToDouble {
    public static void main(String[] args) {
        // int i = 4;
        /*int i = 5001;
        int big = 5000;
        double d = i/big;
        float f = i/big;
        float v = new BigDecimal(i).floatValue() / big;
        double v1 = new BigDecimal(i).doubleValue() / big;
        System.out.println(d);
        System.out.println(v1);
        System.out.println(v);
        System.out.println(f);
        int n = 0;
        if (v1 == Math.floor(v1)) {
            n = (int) v1;
        } else {
            n = (int) v1 + 1;
        }
        System.out.println(n);*/

        String temp1 = "34";
        String temp2 = "30";
        String temp3 = "30";
        String temp4 = "36";
        double temp = ((Integer.valueOf(temp1) - 30) * 1000 + (Integer.valueOf(temp2) - 30) * 100 + (Integer.valueOf(temp3) - 30) * 10 + (Integer.valueOf(temp4) - 30))/100.0;
        System.out.println(temp);
    }
}
