
package hikversion;

import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelPing {
    public static void main(String[] args) {
        Integer count = Integer.valueOf("4");
        String sec = "1 100 3001 3002";
        String[] s = sec.split(" ");
        List<Integer> ping = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            ping.add(Integer.valueOf(s[i]));
        }

        StringBuffer stringBuffer = new StringBuffer();
        // 输出4次
        for (Integer i = 0; i < count; i++) {
            int rs = 0;
            Integer secInt = Integer.valueOf(s[i]);
            int secStart = secInt - 3000;
            for (int i2 = 0; i2 < ping.size(); i2++) {
                if (secStart <= ping.get(i2) && ping.get(i2) <= secInt) {
                    rs++;
                }
            }
            stringBuffer.append(rs+" ");
        }
        System.out.println(stringBuffer.toString());
    }
}
