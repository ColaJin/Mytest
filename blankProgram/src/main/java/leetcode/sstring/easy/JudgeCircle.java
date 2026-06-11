package leetcode.sstring.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:657.机器人能否返回原点
 * @Date:2024/8/13
 */
public class JudgeCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }

    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                x++;
            }
            if (c == 'D') {
                x--;
            }
            if (c == 'L') {
                y--;
            }
            if (c == 'R') {
                y++;
            }
        }
        return x == 0 && y == 0;
    }
}
