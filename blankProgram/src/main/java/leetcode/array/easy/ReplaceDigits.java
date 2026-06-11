package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1844.将所有数字用字符替换
 * @Date:2024/8/19
 */
public class ReplaceDigits {
    public static void main(String[] args) {
        System.out.println(replaceDigits("a1c1e1"));
    }

    public static String replaceDigits(String s) {
        StringBuffer sb = new StringBuffer();
        char last = 'a';
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                sb.append(c);
                last = c;
            } else {
                sb.append((char) (last + (c - '0')));
            }
        }
        return sb.toString();
    }
}
