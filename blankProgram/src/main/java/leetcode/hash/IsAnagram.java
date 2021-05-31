package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "b"));
    }

    public static boolean isAnagram(String s, String t) {
        // 长度相同，需要字母的个数相同
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i <= t.length() - 1; i++) {
            char key = t.charAt(i);
            if (mapT.containsKey(key)) {
                int value = mapT.get(key);
                mapT.put(key, value + 1);
            } else {
                mapT.put(key, 1);
            }
        }


        return map.equals(mapT);
    }

    // 排序
    public static boolean isAnagramBySort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        Arrays.sort(charsS);
        Arrays.sort(charsT);


        /*for (int i = 0; i < charsS.length; i++) {
            if (charsS[i] != charsT[i]) {
                return false;
            }
        }
        return true;*/

        // 可优化
        return Arrays.equals(charsS, charsT);
    }

    // -1方式
    public static boolean isAnagramBetter(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                int value = map.getOrDefault(key, 0);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i <= t.length() - 1; i++) {
            char key = t.charAt(i);
            if (map.containsKey(key)) {
                int value = map.getOrDefault(key, 0);
                if (value - 1 < 0) {
                    return false;
                } else {
                    map.put(key, value - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
