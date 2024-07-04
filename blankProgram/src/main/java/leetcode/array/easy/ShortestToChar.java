package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:821. 字符的最短距离
 * @Date:2023/8/28
 */
public class ShortestToChar {
    public static int[] shortestToChar(String s, char c) {
        int[] rs = new int[s.length()];
        // 记录字符出现的位置
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (c == s.charAt(i)) {
                pos.add(i);
            }
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer po : pos) {
                min = Math.min(Math.abs(i - po), min);
            }
            rs[i] = min;
        }

        return rs;
    }

    public static void main(String[] args) {
        String s = "aaab";
        // String s = "loveleetcode";
        //char c ='e';
        char c ='b';
        int[] rs = shortestToChar(s, c);
        for (int r : rs) {
            System.out.println(r);
        }
    }
}
