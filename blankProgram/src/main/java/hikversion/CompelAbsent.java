
package hikversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelAbsent {
    public static void main(String[] args) {
        String task = "PPALLP";
        if (task.contains("LLL")){
            System.out.println(0);
            return;
        }
        // 计算字符数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < task.length(); i++) {
            Character c = task.charAt(i);
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            if (mapKey.equals('A')) {
                if (mapValue >= 2) {
                    System.out.println(0);
                    return;
                }
            }
            if (mapKey.equals("P")){
                if (mapValue > 3) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }
}
