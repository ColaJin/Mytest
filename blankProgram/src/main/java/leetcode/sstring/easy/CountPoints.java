package leetcode.sstring.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2103.环和杆
 * @Date:2024/8/23
 */
public class CountPoints {
    public int countPoints(String rings) {
        int res = 0;
        int len = rings.length();
        Set<Character>[] temp = new Set[10];
        for (int i = 0; i < len; ) {
            char color = rings.charAt(i);
            char pos = rings.charAt(i + 1);
            Set<Character> set = temp[pos - '0'];
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(color);
            temp[pos - '0'] = set;
            i += 2;
        }
        for (Set<Character> set : temp) {
            if (set != null && set.size() == 3) {
                res++;
            }
        }
        return res;
    }
}
