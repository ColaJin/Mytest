
package hikversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelReverse {
    public static void main(String[] args) {
        Integer count = Integer.valueOf("123450");

        int resout = 0;
        if (count == 0) {
            System.out.println(resout);
        } else {
            while (count != 0){
                resout = resout*10+count%10;
                count/=10;
            }
            System.out.println(resout);
        }
    }
}
