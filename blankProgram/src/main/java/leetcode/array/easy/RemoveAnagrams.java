package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:2273. 移除字母异位词后的结果数组
 * @Date:2023/12/28
 */
public class RemoveAnagrams {
    public static void main(String[] args) {
        String[] words = new String[]{"abba","baba","bbaa","cd","cd"};
        List<String> list = removeAnagrams(words);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> rs = new ArrayList<>();
        String prefix = "";
        for(int i = 0; i < words.length;i++){
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);
            String change = String.valueOf(temp);
            if(i >= 1 && change.equals(prefix)){
                continue;
            }
            rs.add(words[i]);
            prefix = change;
        }
        return rs;
    }
}
