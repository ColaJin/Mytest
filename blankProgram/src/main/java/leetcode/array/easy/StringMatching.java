package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1408. 数组中的字符串匹配
 * @Date:2023/12/11
 */
public class StringMatching {
    public static void main(String[] args) {
        String[] words = new String[]{"leetcode","et","code"};
        List<String> rs = stringMatching(words);
        rs.forEach(i -> System.out.println(i));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> rs = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (String word : words) {
            temp.add(word);
        }

        // 遍历word否则少数据
        for (String word : words) {
            for (String s : temp) {
                if (s.contains(word) && !word.equals(s)) {
                    rs.add(word);
                    // 跳出否则数据重复
                    break;
                }
            }
        }
        return rs;
        /*List<String> ret = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;*/

    }
}
