package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2185. 统计包含给定前缀的字符串
 * @Date:2023/12/26
 */
public class PrefixCount {
    public int prefixCount(String[] words, String pref) {
        int rs = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                rs++;
            }
        }
        return rs;
    }
}
