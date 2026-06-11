package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2942. 查找包含给定字符的单词
 * @Date:2024/8/6
 */
public class FindWordsContaining {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))){
                res.add(i);
            }
        }
        return res;
    }
}
