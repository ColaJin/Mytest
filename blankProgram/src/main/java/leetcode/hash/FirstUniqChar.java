package leetcode.hash;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public static void main(String[] args) {
        firstUniqCharBetter("loveleetcode");
    }

    public static int firstUniqChar(String s) {
        // map存储字符和数量，返回
        // 遍历map中数量为1的字符返回最小的字符位置
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        /*int min = -1;
        Iterator a = map.entrySet ().iterator ();
        while (a.hasNext ()){
            Map.Entry entry = (Map.Entry)a.next();
            // equals不识别==
            if(entry.getValue ().equals(1)) {
                if(s.indexOf((Character) entry.getKey()) > min) {
                    return s.indexOf((Character) entry.getKey());
                }
            }
        }*/
        for (int i = 0; i < s.length(); i++) {
            // 一个的时候get
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }

        }
        // 可以优化二次遍历字符串返回index
        return -1;
    }

    // 直接存储索引和字符，重复的字符索引设置为-1，遍历map后判断不是-1的位置赋值
    public static int firstUniqCharBetter(String s) {
        // map存储字符和数量，返回
        // 遍历map中数量为1的字符返回最小的字符位置
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int first = s.length();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() != -1) {
                if (m.getValue() < first) {
                    first = m.getValue();
                }
            }
        }


        return first == s.length() ? -1 : first;
    }
}
