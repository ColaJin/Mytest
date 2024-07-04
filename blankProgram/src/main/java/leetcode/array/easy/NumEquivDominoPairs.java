package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1128. 等价多米诺骨牌对的数量
 * @Date:2023/11/28
 */
public class NumEquivDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        // [[1,2],[2,1],[3,4],[5,6]]
        int rs = 0;
        /*
        // 超时
        for (int i = 0; i < dominoes.length; i++) {
            int[] temp = dominoes[i];
            int x = temp[0];
            int y = temp[1];
            int[] change = new int[2];
            change[0] = y;
            change[1] = x;
            for (int j = i + 1; j < dominoes.length; j++) {
                if ( Arrays.equals(change, dominoes[j]) || Arrays.equals(temp, dominoes[j])) {
                    rs++;
                }
            }

        }*/
        int[] temp = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
            rs += temp[dominoes[i][0] * 10 + dominoes[i][1]]++;
        }
        return rs;
    }

    public static void main(String[] args) {
        int[][] dominoes = new int[4][1];
        int[] domino1 = new int[]{1, 2};
        int[] domino2 = new int[]{2, 1};
        int[] domino3 = new int[]{3, 4};
        int[] domino4 = new int[]{5, 6};
        dominoes[0] = domino1;
        dominoes[1] = domino2;
        dominoes[2] = domino3;
        dominoes[3] = domino4;
        int i = numEquivDominoPairs(dominoes);
        System.out.println(i);
    }
}
