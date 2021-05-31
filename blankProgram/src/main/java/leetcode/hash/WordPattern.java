package leetcode.hash;

import java.util.*;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPatternBetter("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        // Map存储
        Map<Character, List<Integer>> mapC = new LinkedHashMap<>();
        Map<String, List<Integer>> mapS = new LinkedHashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (mapC.containsKey(ch)) {
                List<Integer> temp = mapC.get(ch);
                temp.add(i);
                mapC.put(ch, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                mapC.put(ch, temp);
            }
        }

        // 导致长度最后一个匹配不到
        int out = 0;
        for (int i = 0; out < s.length(); ) {
            int index = s.indexOf(" ");
            String str = "";
            if (index == -1) {
                str = s;
            } else {
                str = s.substring(0, index);
            }


            if (mapS.containsKey(str)) {
                List<Integer> temp = mapS.get(str);
                temp.add(i);
                mapS.put(str, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                mapS.put(str, temp);
            }
            if (index == -1) {
                s = "";
            } else {
                s = s.substring(index + 1, s.length());
            }
            i++;
        }

        if (mapC.size() != mapS.size()) {
            return false;
        }

        Iterator<String> iter1 = mapS.keySet().iterator();
        Iterator<Character> iter2 = mapC.keySet().iterator();

        while (iter1.hasNext()) {
            String m1Key = (String) iter1.next();
            Character m2Key = (Character) iter2.next();
            List<Integer> listS = mapS.get(m1Key);
            List<Integer> listC = mapC.get(m2Key);
            boolean compare = compare(listC, listS);
            // listC.retainAll(listS);// 返回的结果是二者不同的数据存在true完全相同的话返回false
            if (!compare) {
                return false;
            }
        }

        return true;
    }

    // 比较两个list内容是否相同
    public static synchronized <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if (a.size() != b.size()) {
            return false;
        }
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }


    // 双射，每次更新j int j = i;更新j的位置到" ",截取字符串i,j，内部i > m返回false因为pattern比单词模式多
    // 外侧则证明true，二者模式相同
    public static boolean wordPatternBetter(String pattern, String s) {
        // Map存储
        Map<Character, String> mapC = new HashMap<>();
        Map<String, Character> mapS = new HashMap<>();
        // s长度
        int m = s.length();
        // 截取字符串的初始位置
        int i = 0;

        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }

            int j = i;
            // j < m
            while (j < m && s.charAt(j) != ' ') {
                j++;
            }
            String str = s.substring(i, j);
            // 字符串比较是equals,加上!
            if (mapC.containsKey(ch) && !mapC.get(ch).equals(str)) {
                return false;
            }
            if (mapS.containsKey(str) && mapS.get(str) != ch) {
                return false;
            }

            mapC.put(ch, str);
            mapS.put(str, ch);
            // 不需要改变s
            // s = s.substring(j + 1, s.length());
            i = j + 1;
        }

        return i >= m;

    }

}
