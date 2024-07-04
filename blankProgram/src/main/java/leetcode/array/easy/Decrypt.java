package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1652. 拆炸弹
 * @Date:2023/12/18
 */
public class Decrypt {
    public static void main(String[] args) {
        int[] code = new int[]{2, 4, 9, 3};
        int k = -2;
        int[] rs = decrypt(code, k);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] rs = new int[len];
        if (k == 0) {
            return rs;
        } else if (k > 0) {
            // 后
            for (int i = 0; i < len; i++) {
                int count = 0;
                int cur = i;
                for (int j = 0; j < k; j++) {
                    if (cur == len - 1) {
                        cur = 0;
                    } else {
                        cur++;
                    }
                    count += code[cur];
                }
                rs[i] = count;
            }
        } else {
            for (int i = 0; i < len; i++) {
                int count = 0;
                int cur = i;
                for (int j = 0; j < Math.abs(k); j++) {
                    if (cur == 0) {
                        cur = len - 1;
                    } else {
                        cur--;
                    }
                    count += code[cur];
                }
                rs[i] = count;
            }
        }
        return rs;
    }
}
