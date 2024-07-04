package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2553. 分割数组中数字的数位
 * @Date:2024/2/1
 */
public class SeparateDigits {
    public int[] separateDigits(int[] nums) {
        List<Integer> allDigits = new ArrayList<>();
        for (int num : nums) {
            String temp = String.valueOf(num);
            for (char c : temp.toCharArray()) {
                allDigits.add(Character.getNumericValue(c));
            }
        }
        return allDigits.stream().mapToInt(Integer::intValue).toArray();
    }
}
