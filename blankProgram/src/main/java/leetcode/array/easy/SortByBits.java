package leetcode.array.easy;

import org.python.modules.itertools.count;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1356. 根据数字二进制下 1 的数目排序
 * @Date:2023/12/6
 */
public class SortByBits {
    public static void main(String[] args) {
        int[] arr = new int[]{10,100,1000,10000};
        int[] rs = sortByBits(arr);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }

    public static int[] sortByBits(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int[] rs = new int[len];
        Map<Integer, List<Integer>> temp = new HashMap<>();
        for (int i : arr) {
            String binary = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    count++;
                }
            }
            if (temp.containsKey(count)) {
                List<Integer> tempList = temp.get(count);
                tempList.add(i);
                temp.put(count, tempList);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                temp.put(count, tempList);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : temp.entrySet()) {

            List<Integer> value = entry.getValue();
            for (Integer integer : value) {
                rs[index] = integer;
                index++;
            }
        }

        return rs;
    }
}
