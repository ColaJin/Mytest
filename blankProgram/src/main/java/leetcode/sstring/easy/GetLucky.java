package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1945.字符串转化后的各位数字之和
 * @Date:2024/8/23
 */
public class GetLucky {
    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a - 'a' + 1);
    }

    public int getLucky(String s, int k) {
        // 先转化成数字
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        String temp = sb.toString();
        while (k > 0) {
            int count = 0;
            for (char c : temp.toCharArray()) {
                count += c - '0';
            }
            temp = String.valueOf(count);
            k--;
        }
        return Integer.valueOf(temp);
    }
}
