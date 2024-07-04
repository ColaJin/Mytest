package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1863. 找出所有子集的异或总和再求和
 * @Date:2023/12/20
 */
public class SubsetXORSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        int rs = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        combination2(nums, temp, 0, rs);
        return rs;
    }

    public static void combination2(int nums[], ArrayList<Integer> temp, int curIndex, int rs) {
        if (curIndex == nums.length) {
            System.out.println(Arrays.toString(temp.toArray()));
            int tempRs = 0;
            for (Integer integer : temp) {
                tempRs ^= integer;
            }
            rs += tempRs;
            return;
        }
        //选
        temp.add(nums[curIndex]);
        combination2(nums, temp, curIndex + 1, rs);
        //退选
        temp.remove(temp.size() - 1);

        // 不选
        combination2(nums, temp, curIndex + 1, rs);
    }

}
