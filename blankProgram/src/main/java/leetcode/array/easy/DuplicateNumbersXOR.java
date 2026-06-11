package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:3158.求出出现两次数字的XOR值
 * @Date:2024/8/8
 */
public class DuplicateNumbersXOR {
    public static void main(String[] args) {
        int[] nums = new int[]{10,18,7,10,18};
        System.out.println(duplicateNumbersXOR(nums));
    }
    public static int duplicateNumbersXOR(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (temp.contains(num)) {
                list.add(num);
            } else {
                temp.add(num);
            }
        }
        int res = 0;
        if (list.size() > 0) {
            res = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                res = res ^ list.get(i);
            }
        }
        return res;
    }
}
