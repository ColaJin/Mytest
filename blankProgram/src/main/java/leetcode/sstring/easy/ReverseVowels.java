package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:345.反转字符串中的元音字母
 * @Date:2024/8/12
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("race car"));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> temp = new ArrayList<>();
        temp.add('a');
        temp.add('A');
        temp.add('e');
        temp.add('E');
        temp.add('i');
        temp.add('I');
        temp.add('o');
        temp.add('O');
        temp.add('u');
        temp.add('U');
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (temp.contains(chars[i])) {
                while (i < j){
                    if (temp.contains(chars[j])){
                        char change = chars[i];
                        chars[i] = chars[j];
                        chars[j] = change;
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return new String(chars);
    }
}
