package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1588. 所有奇数长度子数组的和
 * @Date:2023/12/15
 */
public class SumOddLengthSubarrays {
    public static void main(String[] args) {

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int rs = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // <= 遍历数组
            for (int j = 1; i + j <= len; j += 2) {
                // 每次移动2格，计算终点后求起点和终点和
                int end = i + j - 1;
                // <=
                for (int k = i; k <= end; k++) {
                    rs += arr[k];
                }
            }
        }
        return rs;
    }
}
