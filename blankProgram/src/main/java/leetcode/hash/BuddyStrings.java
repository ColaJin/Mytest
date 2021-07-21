package leetcode.hash;

import org.apache.logging.log4j.util.StringBuilders;

import java.util.HashMap;
import java.util.Map;

public class BuddyStrings {
    public static void main(String[] args) {
        String s = "aaaaaaabc";
        String goal = "aaaaaaacb";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStringslack(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // 两个字符必须交换后比较
        if (s.length() == 2) {
            // toString()方法
            return new StringBuilder(s).reverse().toString().equals(goal);
        }

        int i = -1;
        int j = -1;
        char ich = 'a';
        char jch = 'a';

        // 少情况(s.equals(goal))
        // 存在问题相同数据的>2的就不行
        // 记录s中和goal中不相同的字符，然后记录不同元素的位置i和j然后交换s中i和j的位置的元素和goal比较
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) != goal.charAt(k)) {
                if (i == -1) {
                    i = k;
                    ich = s.charAt(k);
                } else {
                    j = k;
                    jch = s.charAt(k);
                }
            }
        }
        StringBuffer rs = new StringBuffer();
        for (int k = 0; k < s.length(); k++) {

            if (k == i) {
                rs.append(jch);
            } else if (k == j) {
                rs.append(ich);
            } else {
                rs.append(s.charAt(k));
            }
        }
        return rs.toString().equals(goal);
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // 两个字符必须交换后比较
        if (s.equals(goal)) {
            // 相同字符串需要含有相同的数字才能保证交换不发生问题
            int[] count = new int[26];
            for (Character ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            for (int i : count) {
                if (i > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int i = -1;
            int j = -1;
            // char ich = 'a';
            // char jch = 'a';

            // 少情况(s.equals(goal))
            // 存在问题相同数据的>2的就不行
            // 记录s中和goal中不相同的字符，然后记录不同元素的位置i和j然后交换s中i和j的位置的元素和goal比较
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) != goal.charAt(k)) {
                    if (i == -1) {
                        i = k;
                        // ich = s.charAt(k);
                    } else if (j == -1) {
                        j = k;
                        // jch = s.charAt(k);
                    } else {
                        return false;
                    }
                }
            }
            /*StringBuffer rs = new StringBuffer();
            for (int k = 0; k < s.length(); k++) {

                if (k == i) {
                    rs.append(jch);
                } else if (k == j) {
                    rs.append(ich);
                } else {
                    rs.append(s.charAt(k));
                }
            }
            return rs.toString().equals(goal);*/
            // j == -1证明只有一个元素不同，那么交换一定会出现问题
            return (j != -1 && s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i));
        }

    }
}
