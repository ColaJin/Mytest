package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1967.作为子字符串出现在单词中的字符串数目
 * @Date:2024/8/23
 */
public class NumOfStrings {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)){
                res++;
            }
        }
        return res;
    }
}
