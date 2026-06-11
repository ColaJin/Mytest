package leetcode.sstring.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:1812.判断国际象棋期盼中的一个格子的颜色
 * @Date:2024/8/15
 */
public class SquareIsWhite {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        if (set.size() == 26) {
            return true;
        }
        return false;
    }
}
