package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1455.检查单词是否为剧中其他单词前缀
 * @Date:2024/8/14
 */
public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
