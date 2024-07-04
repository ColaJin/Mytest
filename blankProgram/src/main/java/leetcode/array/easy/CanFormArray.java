package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1640. 能否连接形成数组
 * @Date:2023/12/18
 */
public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length; ) {
            if (!map.containsKey(i)) {
                return false;
            }
            int j = map.get(arr[i]);
            int len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i += len;
        }
        return true;
    }
}
