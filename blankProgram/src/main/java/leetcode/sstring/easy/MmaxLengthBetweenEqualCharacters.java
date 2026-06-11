package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1624.两个相同字符之间的最长子字符串
 * @Date:2024/8/15
 */
public class MmaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -2;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int j = len - 1;
            while (j > i) {
                if (s.charAt(j) == s.charAt(i)) {
                    max = Math.max(max, j - i - 1);
                }
                j--;
            }
        }
        return Math.max(max,-1);
    }
}
