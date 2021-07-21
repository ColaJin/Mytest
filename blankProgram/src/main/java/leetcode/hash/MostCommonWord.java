package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.isLetter;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "abc abc? abcd the jeff!";
        String[] banned = new String[]{"abc", "abcd", "jeff"};
        System.out.println(mostCommonWordBetter(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        // 整理字符后，需要全部变成小写的单词
        // 存储单词出现次数

        // 遍历map如果值最大时且不为禁用单词的时候更新最大长度和单词
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace(".", " ");
        paragraph = paragraph.replace(";", " ");
        paragraph = paragraph.replace("!", " ");
        paragraph = paragraph.replace("?", " ");
        paragraph = paragraph.replace("'", " ");
        paragraph = paragraph.replace("，", " ");

        paragraph = paragraph.toLowerCase();
        // 去掉字符的时候导致之间没有空格
        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            /*for (String s : banned) {

                if (!word.equals(s)) {
                    // 不禁止的元素放入map,出现问题哦，和第一个元素不相同，但是和后面元素相同 【abc abcd】，abcd和abc比较时不同放入了map中
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
            // 存在banned为null的情况，也需要放入map中存储单词
            if (banned.length == 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }*/

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String s : banned) {
            // 删除禁止元素的map
            if (map.containsKey(s)) {
                map.remove(s);
            }
        }

        String rs = "";
        int maxLen = Integer.MIN_VALUE;
        System.out.println(map.size());
        for (String key : map.keySet()) {
            System.out.println(key + "---->" + map.get(key));
            if (maxLen < map.get(key)) {
                System.out.println(map.get(key));
                maxLen = map.get(key);
                rs = key;
            }
        }

        return rs;
    }


    public static String mostCommonWordBetter(String paragraph, String[] banned) {
        // 防止结尾不是字符的字符串
        paragraph += ".";
        // 之前再放入之前判断的逻辑可以是banned数组中的字符串放到Set中处理
        // 不需要分割字符，判断是否是字母，是就一直StringBuffer append
        // 放入的时候直接判断是否是最大就可
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            if (!set.contains(s)) {
                set.add(s);
            }
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        StringBuffer sb = new StringBuffer();
        String rs = "";
        // 最大的单词长度
        int maxCount = Integer.MIN_VALUE;
        for (Character ch : paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                // 转换成小写
                sb.append(Character.toLowerCase(ch));
            }else if (sb.length() > 0) {
                if (!set.contains(sb.toString())) {
                    // map统计的是出现的次数单词
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    if (maxCount < map.get(sb.toString())) {
                        rs = sb.toString();
                        maxCount = map.get(sb.toString());
                    }
                }
                sb = new StringBuffer();
            }
        }

        return rs;
    }
}
