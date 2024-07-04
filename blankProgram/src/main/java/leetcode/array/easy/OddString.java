package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2451. 差值数组不同的字符串
 * @Date:2024/1/25
 */
public class OddString {
    public String oddString(String[] words) {
        int[] diff1 = get(words[0]);
        int[] diff2 = get(words[1]);
        if (Arrays.equals(diff1, diff2)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff1,get(words[i]))){
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff1, get(words[2])) ? words[1] : words[0];
    }

    public int[] get(String word) {
        int[] rs = new int[word.length() - 1];
        for (int i = 0; i < word.toCharArray().length - 1; i++) {
            rs[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return rs;
    }
}
