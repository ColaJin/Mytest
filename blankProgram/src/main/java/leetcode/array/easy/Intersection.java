package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2248. 多个数组求交集
 * @Date:2023/12/28
 */
public class Intersection {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> rs = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j : nums[i]) {
                map.put(j,map.getOrDefault(j,0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getValue() == len){
                rs.add(temp.getKey());
            }
        }
        Collections.sort(rs);
        return rs;
    }
}
