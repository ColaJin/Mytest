
package hikversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelSamePwd {
    public static void main(String[] args) {
        String s = "r";
        String t = "r";
        if (s.length() != t.length()){
            System.out.println(0);
            return;
        }
        if (t.length() == 1) {
            if (s.equals(t)) {
                System.out.println(1);
                return;
            } else {
                System.out.println(0);
                return;
            }
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (sMap.containsKey(c)) {
                Integer count = sMap.get(c);
                sMap.put(c, count + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (tMap.containsKey(c)) {
                Integer count = tMap.get(c);
                tMap.put(c, count + 1);
            } else {
                tMap.put(c, 1);
            }
        }

        boolean isSame = false;
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            if (tMap.containsKey(mapKey)) {
                if (tMap.get(mapKey) == mapValue) {
                    // 相等的时候不管
                    isSame = true;
                } else {
                    isSame = false;
                    break;
                }
            } else {
                isSame = false;
                break;
            }
        }

        if (isSame) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
