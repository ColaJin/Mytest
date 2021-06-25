package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        // Map存储char和数量，然后遍历单词，每次要count--
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int length = 0;
        for (String str : words) {
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // map不存在时map.get(ch)返回null不能赋值给int
                // int count = map.get(ch);
                if (map.containsKey(str.charAt(i))) {
                    int count = map.get(ch);
                    if (getCount(str, str.charAt(i)) > count) {
                        flag = true;
                        break;
                    }
                } else {
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                length += str.length();
            }
        }

        return length;
    }

    // 查看一个字符串中含有相同的字符的数量
    public static int getCount(String word, char ch) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}