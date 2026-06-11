package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2788. 按分隔符拆分字符串
 * @Date:2024/8/5
 */
public class SplitWordsBySeparator {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        char separator = '.';
        List<String> list = splitWordsBySeparator(words, separator);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> temp = new ArrayList<>();
        /*for (String word : words) {
            // 需要转义
            String[] split = word.split(String.valueOf(separator));
            for (String s : split) {
                if (!"".equals(s)){
                    temp.add(s);
                }
            }
        }*/
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (c == separator) {
                    if (sb.length() > 0) {
                        temp.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                temp.add(sb.toString());
            }
        }
        return temp;
    }
}
