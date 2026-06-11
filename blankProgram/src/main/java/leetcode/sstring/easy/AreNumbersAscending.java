package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2042.检查句子中的数字是否递增
 * @Date:2024/8/23
 */
public class AreNumbersAscending {
    public static void main(String[] args) {
        System.out.println(areNumbersAscending("hello world 5 x 5"));
    }
    public static boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");
        int last = 0;
        for (int i = 0; i < strings.length; i++) {
            if (Character.isDigit(strings[i].charAt(0))) {
                Integer temp = Integer.valueOf(strings[i]);
                if (temp <= last) {
                    return false;
                }
                last = temp;
            }
        }
        return true;
    }
}
