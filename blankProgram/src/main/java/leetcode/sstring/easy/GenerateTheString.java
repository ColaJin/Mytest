package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1374.生成每种字符都是技术个的字符串
 * @Date:2024/8/14
 */
public class GenerateTheString {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            // 偶数 n-1个字符+1个字符
            while (n > 1) {
                sb.append('a');
                n--;
            }
            sb.append('b');
        } else {
            if (n == 1) {
                return "a";
            }
            // 奇数。 n-2个字符+2个其他字符
            while (n > 2) {
                sb.append('a');
                n--;
            }
            sb.append('b');
            sb.append('c');
        }
        return sb.toString();
    }
}
