package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }else if (strs.length==1) {
            return strs[0];
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() != o2.length() ? Integer.compare(o1.length(),o2.length()):o1.compareTo(o2);
            }
        });
        String result = "";
        int length = strs[0].length();
        for (int j = 0; j < length; j++) {
            char first = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {

                if (first == strs[i].charAt(j)) {

                    if (i == strs.length - 1) {

                        result = result.concat(String.valueOf(first));
                    }
                }else {
                    return result;
                }
            }
        }
        return result;
    }
}
