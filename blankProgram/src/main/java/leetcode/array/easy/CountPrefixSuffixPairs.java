package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3042. 统计前后缀下标对 I
 * @Date:2024/8/7
 */
public class CountPrefixSuffixPairs {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    res++;
                }
            }
        }
        return res;
    }
}
