package leetcode.hash;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class FindWords {
    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        for (String word : findWordsByString(words)) {
            System.out.println(word);
        }
    }


    public static String[] findWords(String[] words) {
        String[] rs = new String[words.length];
        int index = 0;
        // 数组存储字母的所在，然后判断一个单词的所有字母是否都在在则返回
        HashMap<Character, Integer> map = getMap();
        for (String str : words) {
            String temp = str.toUpperCase();
            boolean flag = true;
            int site = map.get(temp.charAt(0));
            for (int i = 1; i < temp.length(); i++) {
                if (map.get(temp.charAt(i)) != site) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                rs[index] = str;
                index++;
            }
        }

        return Arrays.copyOfRange(rs, 0, index);
    }

    public static HashMap getMap() {
        HashMap<Character, Integer> map = new HashMap();
        //第一行
        map.put('Q', 1);
        map.put('W', 1);
        map.put('E', 1);
        map.put('R', 1);
        map.put('T', 1);
        map.put('Y', 1);
        map.put('U', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('P', 1);
        //第二行
        map.put('A', 2);
        map.put('S', 2);
        map.put('D', 2);
        map.put('F', 2);
        map.put('G', 2);
        map.put('H', 2);
        map.put('J', 2);
        map.put('K', 2);
        map.put('L', 2);
        //第三行
        map.put('Z', 3);
        map.put('X', 3);
        map.put('C', 3);
        map.put('V', 3);
        map.put('B', 3);
        map.put('N', 3);
        map.put('M', 3);
        return map;

    }

    // 不用map直接就是String类型的字符串(小写)，遍历word的字符，最后算含有的字符结果是否是单词长度个数字，每个单词清零长度
    // List.toArray(list);

    public static String[] findWordsByString(String[] words) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";

        List<String> list = new ArrayList<>();

        for (String str : words) {
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            // 转换成小写，赋值操作但是不可以更改str否则后面数据改变
            String temp = str.toLowerCase();
            for (Character ch : temp.toCharArray()) {
                if (line1.contains("" + ch)) {
                    num1++;
                }
                if (line2.contains("" + ch)) {
                    num2++;
                }
                if (line3.contains("" + ch)) {
                    num3++;
                }
            }
            if (num1 == str.length() || num2 == str.length() || num3 == str.length()) {
                list.add(str);
            }
        }

        return list.toArray(new String[list.size()]);
    }

    // 流处理??
    public static String[] findWordsByStream(String[] words) {
        String[] strs = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        return Arrays.stream(words)
                .filter(str -> str.chars()
                        .filter(ch -> !saml(str.charAt(0), strs).contains
                                (Character.toString((char) Character.toLowerCase(ch)))).count() == 0)
                .toArray(String[]::new);
    }

    public static String saml(Character ch, String[] strs) {
        ch = Character.toLowerCase(ch);
        for (String str : strs) {
            if (str.contains(Character.toString(ch))) {
                return str;
            }
        }
        return "";
    }

}
