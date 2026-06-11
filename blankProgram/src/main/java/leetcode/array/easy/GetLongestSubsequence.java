package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2900. 最长相邻不相等子序列 I
 * @Date:2024/8/6
 */
public class GetLongestSubsequence {
    public static void main(String[] args) {
        String[] words = new String[]{"lr", "h"};
        int[] groups = new int[]{0, 0};
        List<String> longestSubsequence = getLongestSubsequence(words, groups);
        for (String s : longestSubsequence) {
            System.out.println(s);
        }
    }

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        // 连续的group只选择一个
        for (int i = 0; i < groups.length; i++) {
            // lh r 0 ,0 需要i == groups.length - 1
            if (i == groups.length - 1 || groups[i] != groups[i + 1]) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
