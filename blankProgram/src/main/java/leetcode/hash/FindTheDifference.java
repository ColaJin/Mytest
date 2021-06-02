package leetcode.hash;

import java.util.HashMap;

public class FindTheDifference {

    public static void main(String[] args) {
        findTheDifference("abcd", "abcde");
    }

    public static char findTheDifference(String s, String t) {
        // Hash存储然后计算出现的次数，遍历另外一个字符的时候count--，如果count小于0那么就返回字符
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return ch;
            } else {
                int count = map.get(ch) - 1;
                if (count < 0) {
                    return ch;
                } else {
                    map.put(ch, count);
                }
            }
        }



        // 默认
        return ' ';
        // return '\u0000';
    }

    // 数组：26长度大小，存储 ch-'a'(变成int存储)的数量++；
    // --时判断<0返回


    // 计算字符和然后返回字符和差


    // 异或运算 a^a = 0不同的结果为异或结果

}
