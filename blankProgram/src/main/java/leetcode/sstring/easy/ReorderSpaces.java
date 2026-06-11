package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1592.重新排列单词间的空格
 * @Date:2024/8/14
 */
public class ReorderSpaces {
    public String reorderSpaces(String text) {
        // 一次遍历获取单词和空格数
        int len = text.length();
        String[] words = text.trim().split("\\s+");
        int space = len;
        for (String word : words) {
            space -= word.length();
        }
        StringBuffer sb = new StringBuffer();
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < space; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int mid = space / (words.length - 1);
        int tail = space % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                for (int j = 0; j < mid; j++) {
                    sb.append(' ');
                }
            }
            sb.append(words[i]);
        }
        for (int i = 0; i < tail; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
