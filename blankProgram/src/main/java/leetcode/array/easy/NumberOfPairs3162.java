package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3162.优质数对的总数I
 * @Date:2024/8/8
 */
public class NumberOfPairs3162 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 4};
        int[] nums2 = new int[]{1, 3, 4};
        int k = 1;
        System.out.println(numberOfPairs(nums1, nums2, k));
    }

    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] % (nums2[i] * k) == 0) {
                    res++;
                }
            }

        }
        return res;
    }
}
