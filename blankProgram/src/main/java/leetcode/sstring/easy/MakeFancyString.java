package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1957.删除字符使字符串变好
 * @Date:2024/8/23
 */
public class MakeFancyString {
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
    public static String makeFancyString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length()) {
                if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
                    // 连续三个相同
                } else {
                    sb.append(s.charAt(i));
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
