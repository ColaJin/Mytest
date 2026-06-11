package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1876.长度为三且各字符不同的子字符串
 * @Date:2024/8/19
 */
public class CountGoodSubstrings {
    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.toCharArray().length - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                res++;
            }
        }
        return res;
    }
}
