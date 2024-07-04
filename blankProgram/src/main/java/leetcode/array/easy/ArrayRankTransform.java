package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1331. 数组序号转换
 * @Date:2023/12/5
 */
public class ArrayRankTransform {
    public static void main(String[] args) {
        // [5,3,4,2,8,6,7,1,3]
        int[] arr = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] rs = arrayRankTransform(arr);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] arrayRankTransform(int[] arr) {
        // 输入：arr = [40,10,20,30]
        // 输出：[4,1,2,3]
        int len = arr.length;
        int[] rs = new int[len];
        int[] temp = new int[len];
        System.arraycopy(arr, 0, temp, 0, len);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int pos = 0;
        for (int i = 0; i < len; i++) {
            int arrTemp = temp[i];
            if (!map.containsKey(arrTemp)) {
                pos++;
                map.put(arrTemp, pos);
            }
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                rs[i] = map.get(arr[i]);
            }
        }
        return rs;
    }
}
