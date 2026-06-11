package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1668.最大重复子字符串
 * @Date:2024/8/15
 */
public class MaxRepeating {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        while (sequence.contains(word)) {
            res++;
            word = word + word;
        }
        return res;
    }
}
