package leetcode;

/**
 * @author:jinyandong
 * @description:263. 丑数
 * @Date:2023/8/28
 */
public class IsUgly {
    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }
}
