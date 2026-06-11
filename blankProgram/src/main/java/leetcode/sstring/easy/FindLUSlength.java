package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:521.最长特殊序列I
 * @Date:2024/8/13
 */
public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(),b.length());
        }else {
            if (a.equals(b)) {
                return -1;
            }else {
                return a.length();
            }
        }
    }
}
