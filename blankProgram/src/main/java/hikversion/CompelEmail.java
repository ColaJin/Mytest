package hikversion;

import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelEmail {
    public static void main(String[] args) {
        String s = "5 4 6 4 6 7 2 3 5 6";
        String[] s1 = s.split(" ");
        /*for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }*/
        int rs = 1;
        for (int i = 0; i < s1.length; i++) {
            if (i / 2 != 0){

            }
        }

        int[][] envelopes = new int[s1.length / 2][2];
        for (int i = 0; i < envelopes.length; i++) {
            envelopes[i][0] = Integer.parseInt(s1[2 * i]);
            envelopes[i][1] = Integer.parseInt(s1[2 * i + 1]);
        }
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < envelopes.length - i - 1; j++) {
                if (envelopes[j][0] < envelopes[j + 1][0]) {
                    int[] temp = envelopes[j];
                    envelopes[j] = envelopes[j + 1];
                    envelopes[j + 1] = temp;
                }
            }
        }
        int max = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int depth = findMax(i, envelopes, 1);
            if (depth > max) {
                max = depth;
            }
        }
        System.out.print(max);
    }

    private static int findMax(int i, int[][] envelopes, int depth) {
        int max = depth;
        for (int j = i + 1; j < envelopes.length; j++) {
            if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                int dep = findMax(j, envelopes, depth + 1);
                if (dep > max) {
                    max = dep;
                }
            }
        }
        return max;
    }
}
