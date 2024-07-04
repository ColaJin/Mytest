package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2085. 统计出现过一次的公共字符串
 * @Date:2023/12/25
 */
public class CountWords {
    public static void main(String[] args) {
        String[] words1 = new String[]{"a","ab"};
        String[] words2 = new String[]{"a","a","a","ab"};
        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        int rs = 0;
        int len1 = words1.length;
        int len2 = words2.length;
        // 数组去重
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map2.put(words2[i], map2.getOrDefault(words2[i], 0) + 1);
        }

        if (map2.size() > map1.size()){
            for (Map.Entry<String, Integer> temp : map2.entrySet()) {
                String key = temp.getKey();
                Integer count= temp.getValue();
                if (map1.containsKey(key)){
                    Integer count2 = map1.get(key);
                    if (count == 1 && count2 == 1){
                        rs++;
                    }
                }
            }
        }else {
            for (Map.Entry<String, Integer> temp : map1.entrySet()) {
                String key = temp.getKey();
                Integer count= temp.getValue();
                if (map2.containsKey(key)){
                    Integer count2 = map2.get(key);
                    if (count == 1 && count2 == 1){
                        rs++;
                    }
                }
            }
        }


        return rs;
    }
}
