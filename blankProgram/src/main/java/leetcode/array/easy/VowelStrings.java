package leetcode.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:2586. 统计范围内的元音字符串数
 * @Date:2024/2/2
 */
public class VowelStrings {
    public int vowelStrings(String[] words, int left, int right) {
        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');
        int rs = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            int temp = word.length();
            if (chars.contains(word.charAt(0))&& chars.contains(word.charAt(temp - 1))) {
                rs++;
            }
        }
        return rs;
    }
}
