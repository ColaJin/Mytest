package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2190. 数组中紧跟 key 之后出现最频繁的数字
 * @Date:2023/12/26
 */
public class MostFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 1, 2};
        int key = 1;
        System.out.println(mostFrequent(nums, key));
    }

    public static int mostFrequent(int[] nums, int key) {
        int rs = 0;
        int len = nums.length;
        int target = 0;
        /*List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                if (i + 1 < len) {
                    target = nums[i + 1];
                }
                // 计算当前位置后面所有的次数最多的数字
                List<Integer> temp = new ArrayList<>();
                // 从i开始
                for (int j = i ; j < len; j++) {
                    if (target == nums[j]){
                        temp.add(nums[j]);
                    }
                }
                list.add(temp);
            }
        }
        int  count = 0;
        for (List<Integer> temp : list) {
            if(temp.size() > count){
                rs = temp.get(0);
                count = temp.size();
            }
        }*/
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                if (i + 1 < len) {
                    target = nums[i + 1];
                }
                // 计算当前位置后面所有的次数最多的数字
                List<Integer> temp = new ArrayList<>();
                // 从i开始
                for (int j = i; j < len - 1; j++) {
                    if (key == nums[j] && nums[j + 1] == target) {
                        temp.add(nums[j + 1]);
                    }
                }
                list.add(temp);
            }
        }
        int count = 0;
        for (List<Integer> temp : list) {
            if (temp.size() > count) {
                rs = temp.get(0);
                count = temp.size();
            }
        }

        return rs;
    }
}
