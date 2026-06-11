package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:344.反转字符串
 * @Date:2024/8/12
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
