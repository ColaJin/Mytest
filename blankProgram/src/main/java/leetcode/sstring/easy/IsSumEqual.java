package leetcode.sstring.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1880.检查某单词是否等于两单词之和
 * @Date:2024/8/19
 */
public class IsSumEqual {
    public static void main(String[] args) {
        String s = "001";
        System.out.println(Integer.valueOf(s));

        String[] words = new String[4];
        int len = words.length;
        Map<Character,Integer> map = new HashMap<>();
        for (String word : words){
            int wordLen = word.length();
            for(int i = 0 ; i < wordLen;i++){
                char c = word.charAt(i);
                map.put(c,map.getOrDefault(c,0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> temp : map.entrySet()) {
            if (temp.getValue() % len != 0){

            }
        }
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuffer temp = new StringBuffer();
        for (char c : firstWord.toCharArray()) {
            temp.append(c - 'a');
        }
        Integer first = Integer.valueOf(temp.toString());
        temp = new StringBuffer();
        for (char c : secondWord.toCharArray()) {
            temp.append(c - 'a');
        }
        Integer sec = Integer.valueOf(temp.toString());
        temp = new StringBuffer();
        for (char c : targetWord.toCharArray()) {
            temp.append(c - 'a');
        }
        Integer target = Integer.valueOf(temp.toString());
        return first + sec == target;
    }
}
