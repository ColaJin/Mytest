package leetcode;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 第一项是数字 1
 *
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 *
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 *
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 *
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 */
public class CountAndSay {
    public static void main(String[] args) {
        String result = countAndSay(3);
        System.out.println(result);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return Str(countAndSay(n-1));

    }

    //参数是String类型数据才能遍历S的数据
    static String Str(String s) {
        //记录数值出现的次数从1开始记录
        int count = 1;
        //当前数值
        char num = s.charAt(0);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==num){
                //相同时计数+1
                count++;
            }else {
                result.append(count);
                result.append(num);
                num = c;
                count = 1;
            }
        }
        result.append(count);
        result.append(num);
        return result.toString();
    }

}
