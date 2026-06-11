package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1903.字符串中的最大奇数
 * @Date:2024/8/19
 */
public class LargestOddNumber {
    public String largestOddNumber(String num) {
        List<String> substrings = new ArrayList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                substrings.add(num.substring(i, j));
            }
        }
        long max = 0;
        String res = "";
        for (String substring : substrings) {
            Long temp = Long.parseLong(substring);
            if (temp > max && temp % 2 != 0){
                max = temp;
                res = substring;
            }
        }
        return res;
    }
}
