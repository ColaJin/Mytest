package leetcode.Array.easy;

import java.util.Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{-710, -107, -851, 657, -14, -859, 278, -182, -749, 718, -640, 127, -930, -462, 694, 969, 143, 309, 904, -651, 160, 451, -159, -316, 844, -60, 611, -169, -73, 721, -902, 338, -20, -890, -819, -644, 107, 404, 150, -219, 459, -324, -385, -118, -307, 993, 202, -147, 62, -94, -976, -329, 689, 870, 532, -686, 371, -850, -186, 87, 878, 989, -822, -350, -948, -412, 161, -88, -509, 836, -207, -60, 771, 516, -287, -366, -512, 509, 904, -459, 683, -563, -766, -837, -333, 93, 893, 303, 908, 532, -206, 990, 280, 826, -13, 115, -732, 525, -939, -787};
        System.out.println(maximumProductNoSort(nums));
    }

    public static int maximumProduct(int[] nums) {
        //可以优化max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],nums[0] * nums[1] * nums[nums.length - 1])
        //数组排序，如果后三位都大于0而且小于0的数字至多1个时，那么直接返回后三位乘积结果
        //如果后三位大于0且小于0的数字>=2个时返回乘积结果为前两位和最后一位的积,或者是后三位积
        //如果后三位都小于0返回后三位的乘积结果
        Arrays.sort(nums);
        //统计小于0等于0和大于0的个数
        int count_0 = 0;
        int count0_ = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                count_0++;
            } else if (nums[i] > 0) {
                count0_++;
            }
        }
        if (nums[nums.length - 1] <= 0) {
            //后三位都小于0或等于0时
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
        if (count_0 > 1 && nums[nums.length - 1] > 0) {
            //2个及以上负数且最大位置为正数的情况
            //存在一种情况倒数第三位和第四位的值是>0的且，乘积结果是大于nums[0]和nums[1]的
            if (nums[0] * nums[1] < nums[nums.length - 2] * nums[nums.length - 3]) {
                return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            } else {
                return nums[0] * nums[1] * nums[nums.length - 1];
            }
        }
        if (count0_ >= 3 && count_0 <= 1) {
            //后三位都大于0
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }

        return 0;
    }

    //线性的不需要排序的，直接找到最小的两个数和最大的三个数
    public static int maximumProductNoSort(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min1 > nums[i]) {
                //和下面的if互斥关系
                min2 = min1;
                min1 = nums[i];
            }else if (min2 > nums[i]) {
                //上面的满足时，此if不需要执行
                min2 = nums[i];
            }
            //不可以用if(需要在上一个前提不满足的情况下再判断)
            /*if (min2 > nums[i]) {
                min2 = nums[i];
            }*/
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            }else if (max3 < nums[i]) {
                max3 = nums[i];
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
