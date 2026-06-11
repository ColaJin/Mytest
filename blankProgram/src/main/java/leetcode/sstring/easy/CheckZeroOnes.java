package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1869.哪种连续子字符更长
 * @Date:2024/8/19
 */
public class CheckZeroOnes {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1101"));
    }

    public static boolean checkZeroOnes(String s) {
        int len = 0;
        int len0 = 0;
        int start = -1;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '1') {
                if (start == -1) {
                    start = i;
                    len = Math.max(len, 1);
                } else {
                    len = Math.max(len, i - start + 1);
                }
            } else {
                start = -1;
            }
        }

        start = -1;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '0') {
                if (start == -1) {
                    start = i;
                    len0 = Math.max(len0, 1);
                } else {
                    len0 = Math.max(len0, i - start + 1);
                }
            } else {
                start = -1;
            }
        }
        return len > len0;
    }
}
