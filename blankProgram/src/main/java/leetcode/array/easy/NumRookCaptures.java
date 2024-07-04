package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:999. 可以被一步捕获的棋子数
 * @Date:2023/8/30
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int rs = 0;
        int rr = 0;
        int rc = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rr = i;
                    rc = j;
                }
            }
        }

        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            for (int step = 0; ; step++) {
                int tc = step * dr[i] + rr;
                int tr = step * dc[i] + rc;
                if (tc < 0 || tc >= 8 || tr >= 8 || tr < 0 || board[tc][tr] == 'B') {
                    break;
                }
                if (board[tc][tr] == 'p') {
                    rs++;
                    break;
                }
            }
        }
        return rs;
    }
}
