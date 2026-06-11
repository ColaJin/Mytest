package leetcode.sstring.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2062. 统计字符串中的元音子字符串
 * @Date:2024/8/23
 */
public class CountVowelSubstrings {
    public int countVowelSubstrings(String word) {
        int res = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (subVowel(i, j, word)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean subVowel(int i, int j, String word) {
        Set<Character> set = new HashSet<>();
        for (int temp = i; temp <= j; temp++) {
            char c = word.charAt(temp);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                return false;
            }
            set.add(word.charAt(temp));
        }
        return set.size() == 5;
    }
}
