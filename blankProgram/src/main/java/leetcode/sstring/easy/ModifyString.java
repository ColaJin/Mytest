package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1576.替换所有的问号
 * @Date:2024/8/14
 */
public class ModifyString {
    public String modifyString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '?') {
                for (char temp = 'a'; temp <= 'c'; temp++) {
                    if ((i > 0 && chars[i - 1] == temp) || (i < len - 1 && chars[i + 1] == temp)) {
                        continue;
                    }
                    chars[i] = temp;
                    break;
                }
            }
        }
        return new String(chars);
    }
}
