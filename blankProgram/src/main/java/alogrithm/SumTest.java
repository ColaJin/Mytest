package alogrithm;

public class SumTest {
    public static void main(String[] args) {
        int sum = 0, x = 0, n = 100;/*执行1次*/
        /*算法1*/
        for (int i = 1; i <= n; i++) {/*执行n+1次*/
            sum = i + sum;/*执行n次*/
        }
        System.out.println(sum);/*执行1次*/

        /*算法2*/
        sum = (1 + n) * n / 2;/*执行1次*/
        System.out.println(sum);/*执行1次*/

        /*算法3*/
        for (int i = 0; i < n; i++) {/*执行1次*/
            for (int j = 0; j < n; j++) {
                x++;
                sum = sum + x;/*执行n*n次*/
            }
        }

        System.out.println(sum);/*执行1次*/
    }
}
