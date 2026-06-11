package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1556.千位分隔数
 * @Date:2024/8/14
 */
public class ThousandSeparator {
    public String thousandSeparator(int n) {
        String temp = String.valueOf(n);
        StringBuffer sb = new StringBuffer();
        if (temp.length() == 3) {
            return temp;
        }
        for (int i = temp.toCharArray().length - 1; i >= 0; i -= 3) {
            int j = 3;
            while (j > 0) {
                sb.append(temp.charAt(i - j));
                j--;
            }
        }
        StringBuffer res = sb.reverse();
        if (res.charAt(0) == '.') {
            return res.deleteCharAt(0).toString();
        } else {
            return res.toString();
        }
    }
}
