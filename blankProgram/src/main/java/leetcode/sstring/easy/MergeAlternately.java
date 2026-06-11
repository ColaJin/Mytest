package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1768.交替合并字符串
 * @Date:2024/8/15
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len = word2.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word1.toCharArray().length; i++) {
            sb.append(word1.charAt(i));
            if (i < len) {
                sb.append(word2.charAt(i));
                if (i == word1.length() - 1 && i + 1 < len) {
                    // word2长
                    sb.append(word2.substring(i + 1));
                }
            }
        }
        return sb.toString();
    }
}
