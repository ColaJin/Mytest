package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2164. 对奇偶下标分别排序
 * @Date:2023/12/26
 */
public class SortEvenOdd {
    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                int index  = i;
                while (index < len){
                    if (nums[index] < nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[index];
                        nums[index] = temp;
                    }
                    index +=2;
                }
            }else {
                int index  = i;
                while (index < len){
                    if (nums[index] > nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[index];
                        nums[index] = temp;
                    }
                    index +=2;
                }
            }
        }
        return nums;
    }
}
