package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1974.使用特殊打印机键入单词的最少时间
 * @Date:2024/8/23
 */
public class MinTimeToType {
    public static void main(String[] args) {
        System.out.println(minTimeToType("bza"));
    }

    public static int minTimeToType(String word) {
        int res = 0;
        char last = 'a';
        for (char c : word.toCharArray()) {
            res += Math.min(Math.abs(c - last), 26 - Math.abs(c - last)) + 1;
            last = c;
        }
        return res;
    }
}
