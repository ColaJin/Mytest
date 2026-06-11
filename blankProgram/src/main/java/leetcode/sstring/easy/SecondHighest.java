package leetcode.sstring.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1796.字符串中第二大的数字
 * @Date:2024/8/15
 */
public class SecondHighest {
    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
    }

    public static int secondHighest(String s) {
        /*Set<Integer> set = new TreeSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                set.add(c - '0');
            }
        }
        if (set.size() < 3) {
            if (set.size() == 0) {
                return -1;
            } else {
                List<Integer> list = new ArrayList<>(set);
                return list.get(0);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return list.get(list.size() - 2);*/
        int first = -1;
        int sec = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int temp = c - '0';
                if (temp > first) {
                    sec = first;
                    first = temp;
                } else if (temp < first && temp > sec) {
                    sec = temp;
                }
            }
        }

        return sec;
    }
}
