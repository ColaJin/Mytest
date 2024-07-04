package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1909. 删除一个元素使数组严格递增
 * @Date:2023/12/20
 */
public class CanBeIncreasing {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 10, 5, 7};
        System.out.println(canBeIncreasing(nums));
    }

    public static boolean canBeIncreasing(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        /*boolean temp = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > start) {
                start = nums[i];
            } else {
                if (temp == true) {
                    return false;
                }
                // 等于或者>的时候不处理
                temp = true;
                start = nums[i - 1];
            }
        }*/

        for (List<Integer> temp : list) {
            // 判断每个list是否递增
            boolean rs = true;
            int i0 = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i) > i0) {
                    i0 = temp.get(i);
                } else {
                    rs = false;
                    break;
                }
            }
            if (rs) {
                return true;
            }
        }
        return false;
    }
}
