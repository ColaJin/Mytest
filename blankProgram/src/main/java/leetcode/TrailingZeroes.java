package leetcode;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        int n = 125;
        int rs = trailingZeroes(n);
        System.out.println(rs);
    }

    public static int trailingZeroes(int n) {
        //先算阶乘(会超过限制,需要使用BigInteger，BigInteger.ONE)然后查看结果中含有多少个0
        //时间要logn
        //计算5的个数，因为2有很多个，2*5才会产生一个0，所以取决于5的个数
        int rs = 0;
        while (n >= 5) {
            //while循环里面，每次都将 n 除以 5，
            // 除完之后， 距离 5 就越来越近了，直到n不大于5退出。
            // 假设循环次数为x，也就是说 5 的 x 次方等于 n，则由5^x=n得出x=log以5为底n。因此这个代码的时间复杂度为$O(logn)$
            rs += n / 5;
            n = n / 5;
        }
        return rs;
    }
}
