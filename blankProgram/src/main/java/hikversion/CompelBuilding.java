
package hikversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelBuilding {
    public static void main(String[] args) {
        String heights = "4";
        if (heights.length() == 1){
            System.out.println(0);
            return;
        }
        String[] split = heights.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            Integer high = Integer.valueOf(split[i]);
            boolean isHigh = false;
            for (int i1 = i + 1; i1 < split.length; i1++) {
                Integer temp = Integer.valueOf(split[i1]);
                if (temp >= high) {
                    isHigh = true;
                    break;
                }
            }
            if (!isHigh){
                sb.append(i+" ");
            }
        }

        System.out.println(sb.toString());
    }
}
