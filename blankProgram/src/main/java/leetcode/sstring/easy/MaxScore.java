package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1422.分割字符串最大得分
 * @Date:2024/8/14
 */
public class MaxScore {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }

    public static int maxScore(String s) {
        int max = 0;
        int count0 = 0;
        int count1 = 0;
        int i = 0;
        int j = 1;
        int all0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                all0++;
            }
        }
        int all1 = s.length() - all0;
        while (j < s.length()) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
            int temp1 = all1 - count1;
            max = Math.max(count0 + temp1, max);
            i++;
            j++;
        }
        return max;
    }
}
