package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1470. 重新排列数组
 * @Date:2023/12/12
 */
public class Shuffle {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int[] rs = shuffle(nums, 3);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        // 输入：nums = [2,5,1,3,4,7], n = 3
        // 输出：[2,3,5,4,1,7]
        int len = nums.length;
        int[] rs = new int[len];
        int i = 0;
        int j = 1;
        int past = n;
        for (int k = 0; k < n; k++) {
            rs[i] = nums[k];
            rs[j] = nums[k + past];
            i += 2;
            j += 2;
        }
        return rs;
    }
}
