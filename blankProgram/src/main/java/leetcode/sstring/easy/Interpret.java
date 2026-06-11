package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1678.设计Goal解析器
 * @Date:2024/8/15
 */
public class Interpret {
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
    public static String interpret(String command) {
        StringBuffer sb = new StringBuffer();
        int len = command.length();
        for (int i = 0; i < len; ) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
                i++;
            } else {
                if (i + 1 < len && command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i += 2;
                } else {
                    sb.append("al");
                    i += 4;
                }
            }
        }
        return sb.toString();
    }
}
