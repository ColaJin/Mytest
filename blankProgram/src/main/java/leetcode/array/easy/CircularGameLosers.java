package leetcode.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2682. 找出转圈游戏输家
 * @Date:2024/8/5
 */
public class CircularGameLosers {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int[] ints = circularGameLosers(n, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] circularGameLosers(int n, int k) {
        boolean[] temp = new boolean[n];
        for (int i = k, j = 0; !temp[j]; i += k) {
            temp[j] = true;
            j = (j + i) % n;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (!temp[i]) {
                list.add(i + 1);
            }
        }
        int[] rs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }
}
