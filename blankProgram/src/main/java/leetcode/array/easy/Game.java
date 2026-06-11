package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3242.设计相邻元素求和服务
 * @Date:2024/8/9
 */
public class Game {
    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                res++;
            }
        }
        return res;
    }
}
