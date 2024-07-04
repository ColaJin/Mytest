package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2460. 对数组执行操作
 * @Date:2024/1/25
 */
public class ApplyOperations {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int[] rs = applyOperations(nums);
        for (int r : rs) {
            System.out.println(r);
        }
    }
    public static int[] applyOperations(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num!= 0) {
                list.add(num);
            }
        }
        int noZero = list.size();
        for (int i = 0; i < nums.length; i++) {
            if (i < noZero) {
                nums[i] = list.get(i);
            }else {
                nums[i] = 0;
            }
        }
        /*int i = 0;
        int j = len - 1;
        while (i < j) {
            if (nums[i] == 0){
                if (nums[j] == 0) {
                    j--;
                }else {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j--;
                }
            }else {
                i++;
            }
        }*/
        return nums;
    }
}
