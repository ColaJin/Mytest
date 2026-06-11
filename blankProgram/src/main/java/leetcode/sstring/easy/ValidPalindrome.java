package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:680.验证回文串II
 * @Date:2024/8/13
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int i = 0;
        int len = s.length();
        int j = len - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return false;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        {

            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
