package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int i = romanToInt1(s);
        System.out.println(i);
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (i + 1 < s.length()) {
                    char cr = s.charAt(i + 1);

                    if (cr == 'V') {
                        result = result + 4;
                        i = i + 1;
                    } else if (cr == 'X') {
                        result = result + 9;
                        i = i + 1;
                    } else {
                        result = result + 1;
                    }
                } else {
                    result = result + 1;
                }
            } else if (c == 'V') {
                result = result + 5;
            } else if (c == 'X') {
                if (i + 1 < s.length()) {
                    char cr = s.charAt(i + 1);
                    if (cr == 'L') {
                        result = result + 40;
                        i = i + 1;
                    } else if (cr == 'C') {
                        result = result + 90;
                        i = i + 1;
                    } else {
                        result = result + 10;
                    }
                } else {
                    result = result + 10;
                }
            } else if (c == 'L') {
                result = result + 50;
            } else if (c == 'C') {
                if (i + 1 < s.length()) {
                    char cr = s.charAt(i + 1);
                    if (cr == 'D') {
                        result = result + 400;
                        i = i + 1;
                    } else if (cr == 'M') {
                        result = result + 900;
                        i = i + 1;
                    } else {
                        result = result + 100;
                    }
                } else {
                    result = result + 100;
                }
            } else if (c == 'D') {
                result = result + 500;
            } else if (c == 'M') {
                result = result + 1000;
            }
        }
        return result;
    }

    public static int romanToInt1(String s) {

        int result = 0;
        int clvalue = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int cvalue = getValue(c);
            if (clvalue < cvalue) {
                result = result - clvalue;
            } else {
                result = result + clvalue;
            }
            clvalue = cvalue;
        }
        result = result+clvalue;

        return result;
    }

    public static int getValue(char s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('v', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (s == entry.getKey()) {
                return entry.getValue();
            }
        }

        return 0;
    }
}
