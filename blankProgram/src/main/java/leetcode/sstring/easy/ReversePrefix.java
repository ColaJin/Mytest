package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2000.反转单词前缀
 * @Date:2024/8/23
 */
public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
    public static String reversePrefix(String word, char ch) {
        StringBuffer sb = new StringBuffer();
        int temp = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(c);
            if (c == ch) {
                temp = i;
                break;
            }
        }
        if (temp != 0) {
            return sb.reverse().toString() + word.substring(temp + 1, word.length());
        }
        return word;
    }
}
