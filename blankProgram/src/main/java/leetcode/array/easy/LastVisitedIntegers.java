package leetcode.array.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2899. 上一个遍历的整数
 * @Date:2024/8/6
 */
public class LastVisitedIntegers {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,-1,-1,-1};
        List<Integer> list = lastVisitedIntegers(nums);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public static List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new LinkedList<>();
        int k = 1;
        for (int num : nums) {
            if (num > 0) {
                seen.add(0, num);
                if (k != 1) {
                    // 重置1
                    k = 1;
                }
            } else {
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
                k++;
            }
        }
        return ans;
    }
}
