package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:557.反转字符串中的单词III
 * @Date:2024/8/13
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuffer res = new StringBuffer();
        for (String ss : temp) {
            StringBuffer sb = new StringBuffer();
            sb.append(ss);
            sb.reverse();
            res.append(sb + " ");
        }
        return res.deleteCharAt(res.length()).toString();
    }
}
