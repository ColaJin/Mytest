package leetcode;

/**
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */

public class TitleToNumber {
    public static void main(String[] args) {
        String s = "";
        int rs = titleToNumber(s);
        System.out.println(rs);
    }

    public static int titleToNumber(String s) {
        //除数取余法的反应用
        int rs = 0;
        int count = 0;
        //A的Ascii是65，计算0到25
        //字符串每个字符求结果，从后往前加BA表示2*26^1+1*26^0
        for (int i = s.length() - 1; i >= 0; i--) {

            //此时字符的结果是65、66这样需要转换成0-25
            char c = s.charAt(i);
            int tranverse = tranverse(c);

            rs += tranverse * Math.pow(26, count);
            //每次count++
            count++;
        }
        return rs;
    }

    public static int tranverse(char c) {
        int i = c - 64;
        return i;
    }

    //可以从前往后计算结果，此时不需要count，ans = ans*26+tranverse(c)
}
