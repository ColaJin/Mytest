package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2255. 统计是给定字符串前缀的字符串数目
 * @Date:2023/12/28
 */
public class CountPrefixes {
    public static void main(String[] args) {
        String[] words = new String[]{"a","b","c","ab","bc","abc"};
        String s = "abc";
        System.out.println(countPrefixes(words, s));
    }
    public static int countPrefixes(String[] words, String s) {
        int rs = 0;
        // 记录s的前缀
        int sLen = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= sLen; i++) {
            list.add(s.substring(0, i));
        }

        for (String word : words) {
            if (list.contains(word)) {
                rs++;
            }
        }
        return rs;
    }
}
