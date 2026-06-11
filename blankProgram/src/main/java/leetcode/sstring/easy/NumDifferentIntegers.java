package leetcode.sstring.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:1805.字符串中不同整数的数目
 * @Date:2024/8/15
 */
public class NumDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("167278959591294"));
    }

    public static int numDifferentIntegers(String word) {
        StringBuffer sb = new StringBuffer();
        Set<String> set = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    String temp = sb.toString();
                    while (temp.startsWith("0")){
                        // 去除前导0
                        temp = temp.substring(1);
                    }
                    set.add(temp);
                }
                sb = new StringBuffer();
            }
        }
        if (sb.length() > 0) {
            String temp = sb.toString();
            while (temp.startsWith("0")){
                // 去除前导0
                temp = temp.substring(1);
            }
            set.add(temp);
        }
        return set.size();
    }
}
