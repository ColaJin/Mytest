package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2974. 最小数字游戏
 * @Date:2024/8/6
 */
public class NumberGame {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 2, 3};
        int[] ints = numberGame(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] numberGame(int[] nums) {
        int len = nums.length;
        /* Collections.min不存在
        int[] res = new int[len];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        int cur = 0;
        while (list.size() > 0) {
            int min = Collections.min(list);
            // 删除的索引未知元素
            // list.remove(min);
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                Integer item = iterator.next();
                if(item.equals(min)){
                    iterator.remove();
                }
            }
            int min1 = Collections.min(list);
            Iterator<Integer> iterator2 = list.iterator();
            while(iterator2.hasNext()){
                Integer item = iterator2.next();
                if(item.equals(min1)){
                    iterator2.remove();
                }
            }
            //list.remove(min1);
            res[cur] = min1;
            res[cur + 1] = min;
            cur += 2;
        }*/
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }
}
