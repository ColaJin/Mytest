
package hikversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelAbnormal {
    public static void main(String[] args) {
        String log1 = "output output";
        String log2 = "input";
        String[] l1 = log1.split(" ");
        String[] l2 = log2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l1.length; i++) {
            String s = l1[i];
            if (map.containsKey(s)) {
                Integer count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (int i = 0; i < l2.length; i++) {
            String s = l2[i];
            if (map.containsKey(s)) {
                Integer count = map.get(s);
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            if (mapValue == 1) {
                sb.append(mapKey + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
