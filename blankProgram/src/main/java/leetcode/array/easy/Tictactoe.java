package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:1275. 找出井字棋的获胜者
 * @Date:2023/12/5
 */
public class Tictactoe {
    public static void main(String[] args) {
        int[][] moves = new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(tictactoe(moves));
    }
    public static String tictactoe(int[][] moves) {
        // moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
        // 将数组还原成棋盘
        char[][] chars = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            if (i % 2 == 0) {
                chars[row][col] = 'X';
            } else {
                chars[row][col] = 'O';
            }
        }
        // 最后一个棋子所在的位置
        int lastIndex = moves.length - 1;
        int[] last = moves[lastIndex];
        int lastRow = last[0];
        int lastCol = last[1];
        // Set集合辅助判断同一行同一列，同一斜线
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[lastRow][i]);
        }

        if (set.size() == 1) {
            //行棋子相同
            return lastIndex % 2 == 0 ? "A" : "B";
        }
        set.clear();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i][lastCol]);
        }
        if (set.size() == 1) {
            //列棋子相同
            return lastIndex % 2 == 0 ? "A" : "B";
        }
        set.clear();
        // 斜对角条件
        if (lastRow == lastCol || Math.abs(lastRow - lastCol) == chars.length - 1) {
            for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
                set.add(chars[i][j]);
            }
            // 防止斜对角数据全部是""String.valueOf(set.iterator().next())为set的值
            if (set.size() == 1 && !String.valueOf(set.iterator().next()).trim().equals("")) {
                //左下->右上棋子相同
                return lastIndex % 2 == 0 ? "A" : "B";
            }
            set.clear();
            for (int i = 0; i < chars.length; i++) {
                set.add(chars[i][i]);
            }
            if (set.size() == 1 && !String.valueOf(set.iterator().next()).trim().equals("")) {
                //左上->右下棋子相同
                return lastIndex % 2 == 0 ? "A" : "B";
            }
        }
        if (moves.length == 9) {
            // 不能再下
            return "Draw";
        } else {
            // 还没结束
            return "Pending";
        }
    }
}
