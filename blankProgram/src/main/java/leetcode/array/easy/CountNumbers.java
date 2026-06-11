package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 135.报数
 * @Date:2024/8/12
 */
public class CountNumbers {
    public int[] countNumbers(int cnt) {
        int temp = (int)Math.pow(10,cnt) - 1;
        int[] res = new int[temp];
        for (int i = 0; i < temp; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
