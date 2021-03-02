package leetcode.Array.easy;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnesByPoint(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        //记录最大连续1的个数
        int max = 0;
        //1的个数，每当遇到0时需要清0
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                //此处可以用Math.max方法直接赋值给max
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    //指针实现:0,0开始
    public static int findMaxConsecutiveOnesByPoint(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] == 1) {
                right++;
            }else {
                max = Math.max(right - left, max);
                right++;
                left = right;
            }
        }
        //最后一位如果是连续的1的时候需要重新计算right和left的差
        max = Math.max(right - left, max);
        return max;
    }
}
