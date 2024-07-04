package leetcode;

/**
 * @author:jinyandong
 * @description:258. 各位相加
 * @Date:2023/8/28
 */
public class AddDigits {
    public static int addDigits(int num) {
        while (num >= 10) {
            String temp = String.valueOf(num);
            int i = 0;
            for (char c : temp.toCharArray()) {
                i += c - '0';
            }
            num = i;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(10));
    }
}
