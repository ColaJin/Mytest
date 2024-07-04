package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1550. 存在连续三个奇数的数组
 * @Date:2023/12/13
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 4, 1};
        threeConsecutiveOdds(arr);
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}
