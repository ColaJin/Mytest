package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1859.将句子排序
 * @Date:2024/8/19
 */
public class SortSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        int len = words.length;
        String[] temp = new String[words.length];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int lenTemp = word.length();
            temp[word.charAt(lenTemp - 1) - '0' - 1] = word.substring(0, lenTemp - 1);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
            if (i != temp.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
