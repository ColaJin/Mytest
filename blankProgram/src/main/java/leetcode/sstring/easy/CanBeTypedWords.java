package leetcode.sstring.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:1935.可以输入的最大单词数
 * @Date:2024/8/19
 */
public class CanBeTypedWords {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        String[] words = text.split(" ");
        int res = 0;
        for (String word : words) {
            boolean has = false;
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    has = true;
                    break;
                }
            }
            if (!has) {
                res++;
            }
        }
        return res;
    }
}
