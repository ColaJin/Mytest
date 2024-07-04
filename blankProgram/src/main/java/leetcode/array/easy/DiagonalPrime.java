package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2614. 对角线上的质数
 * @Date:2024/2/28
 */
public class DiagonalPrime {
    public int diagonalPrime(int[][] nums) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i == j || i == nums.length - j - 1) {
                    int val = nums[i][j];
                    if (isPrime(val)) {
                        rs = Math.max(val, rs);
                    }
                }
            }
        }
        return rs;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) { // 小于等于1的数都不是质数
            return false;
        } else if (number == 2 || number == 3) { // 特殊情况处理
            return true;
        } else if (number % 2 == 0 || number % 3 == 0) { // 能被2或者3整除的数也不是质数
            return false;
        } else {
            int sqrt = (int) Math.sqrt((double) number); // 计算平方根
            for (int i = 5; i <= sqrt; i += 6) { // 从5开始遍历到平方根之间的所有奇数
                if (number % i == 0 || number % (i + 2) == 0) { // 如果能被这些数中任意一个整除，则不是质数
                    return false;
                }
            }
            return true; // 没有符合条件的因子，则是质数
        }
    }
}
