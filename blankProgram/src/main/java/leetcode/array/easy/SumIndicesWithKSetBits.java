package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2855. 使数组成为递增数组的最少右移次数
 * @Date:2024/8/6
 */
public class SumIndicesWithKSetBits {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(10);
        nums.add(1);
        nums.add(5);
        nums.add(2);
        int k = 1;
        System.out.println(sumIndicesWithKSetBits(nums, k));
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {

            if (countOnes(i) == k) {
                res += nums.get(i);
            }
        }

        return res;
    }

    public static int countOnes(int number) {
        int count = 0;
        while (number != 0) {
            count += number & 1; // 与操作，如果是1则count+1
            number >>>= 1; // 无符号右移一位
        }
        return count;
    }

}
