package leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class CimbStairs {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }

    //递归
    public static int climbStairsD(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairsD(n-1)+climbStairsD(n-2);

    }
}
