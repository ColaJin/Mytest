package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        int oldx = x;
        boolean result = false;
        if (x < 0) {
            return result;
        } else {
            int reg = 0;
            int t = 0;
            int newres = 0;
            while (x != 0) {
                t = x % 10;
                newres = 10 * reg + t;
                reg = newres;
                x = x / 10;
            }
            if (oldx == reg) {
                return true;
            }

        }
        return result;
    }
}
