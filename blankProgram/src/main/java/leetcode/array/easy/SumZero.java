package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1304. 和为零的 N 个不同整数
 * @Date:2023/12/5
 */
public class SumZero {
    public static void main(String[] args) {
        int n = 5;
        int[] rs = sumZero(n);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] sumZero(int n) {
        int[] rs = new int[n];
        if (n == 1) {
            rs[0] = 0;
            return rs;
        }
        /*if (n % 2 == 0) {
            // 偶数 -4 4 -3 3
            for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
                rs[i] = i;
                rs[j] = -i;
                if (i >= j) {
                    break;
                }
            }
        } else {
            int temp = n;
            for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
                if (i >= j) {
                    break;
                }
                rs[i] = temp;
                rs[j] = -temp;
                temp--;
            }
        }*/
        int temp = n;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (i >= j) {
                break;
            }
            rs[i] = temp;
            rs[j] = -temp;
            temp--;
        }
        return rs;
    }
}
