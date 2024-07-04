package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1389. 按既定顺序创建目标数组
 * @Date:2023/12/8
 */
public class CreateTargetArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[]{0,1,2,2,1};
        int[] rs = createTargetArray(nums, index);
        for (int r : rs) {
            System.out.println(r);
        }
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] rs = new int[len];
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            // 按照插入顺序访问和迭代，会在指定的索引位置添加给定元素，任何现有的元素将被向右移动一个索引位置。
            temp.add(index[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            rs[i] = temp.get(i);
        }
        return rs;
    }
}
