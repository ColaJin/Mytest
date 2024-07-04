package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2114. 句子中的最多单词数
 * @Date:2023/12/26
 */
public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int rs = 0;
        for (String sentence : sentences) {
            String[] temp = sentence.split(" ");
            rs = Math.max(rs, temp.length);
        }
        return rs;
    }
}
