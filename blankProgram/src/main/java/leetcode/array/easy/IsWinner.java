package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2660. 保龄球游戏的获胜者
 * @Date:2024/2/28
 */
public class IsWinner {
    public static void main(String[] args) {
        int[] player1 = new int[]{7,7,4,7,7};
        int[] player2 = new int[]{7,2,3,10,10};
        System.out.println(isWinner(player1, player2));
    }

    public static int isWinner(int[] player1, int[] player2) {
        int score1 = 0;
        int score2 = 0;
        boolean flag1 = false;
        int count = 0;
        for (int i = 0; i < player1.length; i++) {
            if (flag1) {
                score1 += 2 * player1[i];
                count--;
                if (count == 0) {
                    flag1 = false;
                }
            } else {
                score1 += player1[i];
            }
            if (player1[i] == 10) {
                flag1 = true;
                count = 2;
            }
        }

        boolean flag2 = false;
        for (int i = 0; i < player2.length; i++) {

            if (flag2) {
                score2 += 2 * player2[i];
                count--;
                if (count == 0) {
                    flag2 = false;
                }
            } else {
                score2 += player2[i];
            }
            if (player2[i] == 10) {
                flag2 = true;
                count = 2;
            }
        }
        if (score1 > score2) {
            return 1;
        }
        if (score1 < score2) {
            return 2;
        }
        return 0;
    }
}
