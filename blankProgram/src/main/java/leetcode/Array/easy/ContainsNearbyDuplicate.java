package leetcode.Array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicateByHashSet(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //用Map存储nums的值和对应的索引
        //相同时计算索引的差是否<=K，是则返回true，否则返回false
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                int temp = map.get(nums[i]);
                if (i - temp <= k){
                    return true;
                }
            }
            //覆盖key相同的值，
            map.put(nums[i],i);
        }
        return false;
    }

    //使用散列表在常量时间内完成 搜索，删除，插入
    public static boolean containsNearbyDuplicateByHashSet(int[] nums, int k) {
        //用Set存储nums的值
        //1.存在相同值返回true
        //2.插入值
        //3.大于k时删除最旧的元素
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
