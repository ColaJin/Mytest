package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1566. 重复至少 K 次且长度为 M 的模式
 * @Date:2023/12/13
 */
public class ContainsPattern {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2};
        int m = 1, k = 2;
        boolean b = containsPattern(arr, m, k);
        System.out.println(b);
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; ++i) {
            int j = 0;
            for (; j < m * k; ++j) {
                if (arr[i + j] != arr[i + j % m]) {
                    break;
                }
            }
            if (j == m * k) {
                return true;
            }
        }
        return false;
    }
}
