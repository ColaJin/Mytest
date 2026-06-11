package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:824.山羊拉丁文
 * @Date:2024/8/13
 */
public class ToGoatLatin {
    public String toGoatLatin(String sentence) {
        StringBuffer sb = new StringBuffer();
        List<Character> temp = new ArrayList<>();
        temp.add('a');
        temp.add('e');
        temp.add('i');
        temp.add('o');
        temp.add('u');
        temp.add('A');
        temp.add('E');
        temp.add('I');
        temp.add('O');
        temp.add('U');
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            char first = s[i].charAt(0);
            if (temp.contains(first)) {
                sb.append(s[i]).append("ma");
                int countA = i + 1;
                while (countA > 0) {
                    sb.append("a");
                    countA--;
                }
                sb.append(" ");
            } else {
                String res = s[i].substring(1, s[i].length());
                sb.append(res).append(first).append("ma");
                int countA = i + 1;
                while (countA > 0) {
                    sb.append("a");
                    countA--;
                }
                sb.append(" ");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
