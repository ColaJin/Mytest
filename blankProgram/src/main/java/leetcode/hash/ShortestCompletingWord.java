package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {

    public static void main(String[] args) {
        String licensePlate = "GrC8950";
        String[] words = new String[]{"measure","other","every","base","according","level","meeting","none","marriage","rest"};
        System.out.println(shortestCompletingWordBetter(licensePlate, words));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        // 把licesePlate中的字母存储到Map中，然后遍历words判断是否含有这个Map
        Map<Character, Integer> map = new HashMap<>();
        // S和s不同的map
        licensePlate = licensePlate.toLowerCase();
        for (Character ch : licensePlate.toCharArray()) {
            if (65 <= ch && ch <= 90 || ch >= 97 && ch <= 122) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        String rs = "";
        int index = Integer.MAX_VALUE;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            boolean flag = true;
            for (Map.Entry entry : map.entrySet()) {
                Character key = (Character) entry.getKey();
                Integer count = (Integer) entry.getValue();
                int strcount = 0;
                for (Character ch : str.toCharArray()) {
                    if (key.equals(ch)) {
                        strcount++;
                    }
                }
                if (flag) {
                    if (strcount < count) {
                        // 字符的数量少的时候也是存在问题的
                        flag = false;
                    }
                }
            }
            if (flag) {
                // 先比较长度，然后在长度相等的情况下比较索引
                if (length > str.length()) {
                    index = i;
                    rs = str;
                    length = str.length();
                } else if (length == str.length()) {
                    if (i < index) {

                        index = i;
                        rs = str;
                        length = str.length();
                    }
                }

            }

        }
        return rs;
    }


    // 方法拆分
    // 字符串转换成int[]数组包括的字符-'a'位置的数量
    // 比较两个int[]是否数量相同的方法
    // 判断条件word的长度更小于结果的长度，而且满足两个int[]相同
    public static int[] convert(String words) {
        int[] rs = new int[26];
        // 或者直接在外面转换成小写
        words = words.toLowerCase();
        for (int i = 0; i < words.length(); i++) {
            // 需要转换成小写
            char ch = words.charAt(i);
            if (ch >= 97 && ch <= 122) {
                rs[ch - 'a']++;
            }

        }
        return rs;
    }

    public static boolean isEqual(int[] words1, int[] words2) {
        for (int i = 0; i < words1.length; i++) {
            // 遍历1的所有判断2是不是符合,不为0且大于2(可多不可少)
            // 直接26大小数组，判断大小即可words1 > words2
            if (words1[i] != 0 && words1[i] > words2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String shortestCompletingWordBetter(String licensePlate, String[] words) {
        String rs = "";
        int[] convert = convert(licensePlate);
        for (int i = 0; i < words.length; i++) {
            if ((words[i].length() < rs.length() || rs.length() == 0) && isEqual(convert, convert(words[i]))) {
                rs = words[i];
            }
        }

        return rs;
    }

}
