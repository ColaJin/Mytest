package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1758.生成交替二进制字符串的最少操作数
 * @Date:2024/8/15
 */
public class MinOperations {
    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
    }
    public static int minOperations(String s) {
        // 先按0101这样交换操作次数再按1010这样操作次数，返回最少的方式
        char[] chars = s.toCharArray();
        char[] chars1 = s.toCharArray();
        int count1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0 && chars[i] != '0') {
                count1++;
            } else if (i % 2 != 0 && chars[i] != '1') {
                count1++;
            }
        }

        int count2 = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (i % 2 != 0 && chars1[i] != '0') {
                count2++;
            } else if (i % 2 == 0 && chars1[i] != '1') {
                count2++;
            }
        }
        return Math.min(count2, count1);
    }
}
