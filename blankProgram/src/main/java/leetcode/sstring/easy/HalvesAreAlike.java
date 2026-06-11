package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1704.判断字符串的两半是否相似
 * @Date:2024/8/15
 */
public class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        // 遍历前一半获取数量，后一半获取数量比较
        int n = s.length();
        int half = n / 2;
        List<Character> temp = new ArrayList<>();
        temp.add('a');
        temp.add('A');
        temp.add('e');
        temp.add('E');
        temp.add('i');
        temp.add('I');
        temp.add('o');
        temp.add('O');
        temp.add('u');
        temp.add('U');
        int lCount = 0;
        int RCount = 0;
        for (int i = 0; i < n; i++) {
            if (i < half) {
                if (temp.contains(s.charAt(i))) {
                    lCount++;
                }
            } else {
                if (temp.contains(s.charAt(i))) {
                    RCount++;
                }
            }
        }
        return lCount == RCount;
    }
}
