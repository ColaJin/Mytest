package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:541.反转字符串II
 * @Date:2024/8/13
 */
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
    public static String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer();
        while (s.length() > 0) {
            if (s.length() >= 2 * k) {
                String temp = s.substring(0, 2 * k);
                String need = temp.substring(0, k);
                StringBuffer needSb = new StringBuffer();
                needSb.append(need);
                needSb.reverse();
                String res = temp.substring(k, 2 * k);
                needSb.append(res);
                sb.append(needSb.toString());
                s = s.substring(2 * k , s.length());
            } else {
                if (s.length() >= k) {
                    String need = s.substring(0, k);
                    StringBuffer needSb = new StringBuffer();
                    needSb.append(need);
                    needSb.reverse();
                    String res = s.substring(k, s.length());
                    needSb.append(res);
                    sb.append(needSb.toString());
                }else {
                    StringBuffer needSb = new StringBuffer();
                    needSb.append(s);
                    needSb.reverse();
                    sb.append(needSb.toString());
                }
                break;
            }
        }
        return sb.toString();
    }
}
