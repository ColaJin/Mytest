package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2027.转换字符串的最少操作次数
 * @Date:2024/8/23
 */
public class MinimumMoves {
    public int minimumMoves(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'O') {
                i++;
            } else {
                res++;
                i += 2;
            }
        }
        return res;
    }
}
