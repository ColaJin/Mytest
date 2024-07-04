package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1394. 找出数组中的幸运数
 * @Date:2023/12/8
 */
public class FindLucky {
    public int findLucky(int[] arr) {
        int rs = -1;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getKey() == temp.getValue()) {
                rs = temp.getKey();
            }
        }
        return rs;
    }
}
