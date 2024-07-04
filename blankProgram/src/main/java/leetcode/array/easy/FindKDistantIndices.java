package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:jinyandong
 * @description:2200. 找出数组中的所有 K 近邻下标
 * @Date:2023/12/27
 */
public class FindKDistantIndices {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        int key = 2;
        int k = 2;
        List<Integer> rs = findKDistantIndices(nums, key, k);
        for (Integer r : rs) {
            System.out.println(r);
        }
    }
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        /*List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                temp.add(i);
            }
        }
        for (int i = 0; i < len; i++) {
            for (Integer integer : temp) {
                if (Math.abs(integer - i) <= k) {
                    list.add(i);
                }
            }
        }
        list = list.stream().distinct().collect(Collectors.toList());
        return list;*/

        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int slow = 0;
        for(int fast = 0; fast < len;fast++){
            if(nums[fast] == key){
                slow = Math.max(slow,fast - k);
                int end = Math.min(fast + k,len - 1);
                while(slow <= end){
                    list.add(slow++);
                }
            }
        }
        return list;
    }
}
