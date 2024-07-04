package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2506. 统计相似字符串对的数目
 * @Date:2024/1/25
 */
public class SimilarPairs {
    public static void main(String[] args) {
        String[] words = new String[]{"aabb", "ab", "ba"};
        System.out.println(similarPairs(words));
    }

    public static int similarPairs(String[] words) {
        int rs = 0;
        Map<String, Integer> temp = new HashMap<>();
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            StringBuffer buffer = new StringBuffer();
            //遍历集合，转化为字符串
            for (Character str : set) {
                buffer.append(str);
            }
            String s = buffer.toString();
            temp.put(s, temp.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> map : temp.entrySet()) {
            if (map.getValue() != 1) {
                rs += map.getValue();
            }
        }
        return rs;
    }
}
