package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1684. 统计一致字符串的数目
 * @Date:2023/12/18
 */
public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int rs = 0;
        List<Character> temp = new ArrayList<>();
        for (char c : allowed.toCharArray()) {
            temp.add(c);
        }
        for (String word : words) {
            char[] chars = word.toCharArray();
            boolean is = true;
            for (char aChar : chars) {
                if (!temp.contains(aChar)) {
                    is = false;
                    break;
                }
            }
            if (is) {
                rs++;
            }
        }
        return rs;
    }
}
