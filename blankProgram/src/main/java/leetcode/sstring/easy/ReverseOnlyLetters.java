package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:917.仅仅反转字母
 * @Date:2024/8/13
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public static String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuffer pre = new StringBuffer();
        StringBuffer after = new StringBuffer();
        while (i <= j) {
            if (Character.isLetter(s.charAt(i))) {
                if (Character.isLetter(s.charAt(j))) {
                    if (i == j) {
                        pre.append(s.charAt(j));
                    }else {
                        pre.append(s.charAt(j));
                        after.append(s.charAt(i));
                    }
                    i++;
                    j--;
                } else {
                    after.append(s.charAt(j));
                    j--;
                }
            } else {
                pre.append(s.charAt(i));
                i++;
            }
        }
        return pre.toString() + after.reverse().toString();
    }
}
