package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2744. 最大字符串配对数目
 * @Date:2024/8/5
 */
public class MaximumNumberOfStringPairs {
    public static void main(String[] args) {

    }
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(1) == words[j].charAt(0) && words[i].charAt(0) == words[j].charAt(1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
