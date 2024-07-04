package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1848. 到目标元素的最小距离
 * @Date:2023/12/20
 */
public class GetMinDistance {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 5, 5};
        int target = 5;
        int start = 2;
        System.out.println(getMinDistance(nums, target, start));
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int rs = Integer.MAX_VALUE;
        /*int len = nums.length;
        if (start < len) {
            if (nums[start] == target) {
                return 0;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                int temp = Math.abs(i - start);
               if (min > temp) {
                   min = temp;
               }
            } else {
                rs++;
            }
        }*/
        // 遍历所有位置，查看位置上是否为target是则
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        for (Integer temp : list) {
            rs = Math.min(rs, Math.abs(temp - start));
        }
        return rs;
    }
}
