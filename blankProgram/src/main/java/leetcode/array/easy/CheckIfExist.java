package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1346. 检查整数及其两倍数是否存在
 * @Date:2023/12/6
 */
public class CheckIfExist {
    public static void main(String[] args) {
        //[-2,0,10,-19,4,6,-8]
        int[] arr = new int[]{0, 0};
        boolean b = checkIfExist(arr);
        System.out.println(b);
    }

    public static boolean checkIfExist(int[] arr) {
        // 计算所有数组的2倍数，遍历数组后查看是否存在存在则返回true
        List<Integer> temp = new ArrayList<>();
        for (int i : arr) {
            temp.add(i * 2);
        }
        int count = 0;
        // 两个0是可以的，一个0不可以
        for (Integer i : temp) {
            if (i == 0) {
                count++;
            }
        }
        for (int i : arr) {
            if (temp.contains(i)) {
                if (i != 0) {
                    return true;
                } else {
                    if (count > 1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
