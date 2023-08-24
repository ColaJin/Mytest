
package hikversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelExtraNeed {
    public static void main(String[] args) {
        String task = "1";
        String m = "3";
        String[] split = task.split(",");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            if (Integer.valueOf(split[i]) > max) {
                max = Integer.valueOf(split[i]);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if ((Integer.valueOf(m) + Integer.valueOf(split[i])) >= max) {
                sb.append(1+" ");
            }else {
                sb.append(0+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
