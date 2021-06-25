package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String[] array1 = s1.split("\\s");
        String[] array2 = s2.split("\\s");
        for (String str : array1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : array2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) < 2) {
                list.add(str);
            }
        }
        String[] strings = new String[list.size()];

        return list.toArray(strings);
    }
}
