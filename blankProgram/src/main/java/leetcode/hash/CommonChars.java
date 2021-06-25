package leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars {
    public static void main(String[] args) {
        String[] words = new String[]{"bella", "label", "roller"};
        List<String> list = commonCharsRight(words);
        list.stream().forEach(System.out::println);
    }

    static List<String> list = null;

    public static List<String> commonChars(String[] words) {
        list = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            int[] word1 = convert(words[i]);
            int[] word2 = convert(words[i + 1]);
            isEqual(word1, word2);
        }
        return list;
    }

    // 比较两个数组相同的元素然后返回
    public static void isEqual(int[] word1, int[] word2) {
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            // word2不为0但是list存在的时候也要删除
            if (list.contains("" + ch) && word2[i] == 0) {
                list.remove("" + ch);
            }
            if (word1[i] != 0 && word2[i] != 0 && word1[i] <= word2[i]) {
                for (int t = 0; t < word1[i]; i++) {
                    list.add("" + ch);
                }
            }

            if (word1[i] >= word2[i] && list.contains("" + ch)) {
                // 会全部删除问题
                list.remove("" + ch);
            }
        }
    }

    public static int[] convert(String word) {
        int[] rs = new int[26];
        for (Character ch : word.toCharArray()) {
            rs[ch - 'a']++;
        }
        return rs;
    }

    public static List<String> commonCharsRight(String[] words) {
        List<String> list = new ArrayList<>();
        int[] minCount = new int[26];
        // 放入最大值用来比较
        Arrays.fill(minCount, Integer.MAX_VALUE);
        for (String word : words) {
            // 不能两两比较
            int[] temp = new int[26];
            for (Character ch : word.toCharArray()) {
                temp[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                // 放入最小的
                minCount[i] = Math.min(minCount[i], temp[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minCount[i]; j++) {
                // String.valueOf也可以的
                list.add("" + (char) (i + 'a'));
            }
        }

        return list;
    }
}
