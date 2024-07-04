package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1534. 统计好三元组
 * @Date:2023/12/13
 */
public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int rs = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        rs++;
                    }
                }
            }
        }
        return rs;
    }
}
