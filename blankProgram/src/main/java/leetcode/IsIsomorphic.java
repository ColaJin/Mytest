package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);

    }

    public static boolean isIsomorphic(String s, String t) {
        //遍历两个字符串的字符，然后每个字符的个数存储在栈中，比较两个栈是否相同，字符的个数无法统计
        /*Stack<Integer> ss = new Stack<>();
        Stack<Integer> ts = new Stack<>();

        //用来计数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = 1;
            //判断map容器中是否包含key
            if (map.containsKey(ch)) {
                //如果集合中已经存在

                count += 1;
                //重新存入
                map.put(ch, count);
            }

            //map没有时存储1，我不能删掉，删掉不能用来之后比较啦
            //map.clear();
            ss.push(count);

        }
        while (!ss.isEmpty()) {
            System.out.println(ss.pop());
        }*/

        /*for (int i = 0; i < s.length(); i++) {
            //判断s字符串是否和后一个字符相同的同时比较字符串t前后是否满足相同模式
            int j = i + 1;
            if (j < s.length() && s.charAt(i) == s.charAt(j)) {
                //s字符串前后相同比较t字符串是否满足相同模式，不满足返回false,存在问题需要主要title和plate是false
                if (t.charAt(i) != t.charAt(j)) {
                    return false;
                }

            } else if (j < s.length() && s.charAt(i) != s.charAt(j)) {
                if (t.charAt(i) == t.charAt(j)) {
                    return false;
                }
            }
        }*/

        //用来存储字符,辅助查询。需要两边查询调用参数是s,t和t,s
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs)) {
                //判断之前存在相同的key的是不是同一个值，不是就返回false
                if (map.get(cs) != ct) {
                    return false;
                }
            } else {
                map.put(cs, ct);
            }
        }


        return true;
    }

    public static boolean IsIsomorphic(String s, String t) {
        //Ascii128
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            //当前硬是是否相同，不相同返回false
            if (mapS[cs] != mapS[ct]) {
                return false;
            }
            if (mapS[cs] == 0) {
                //是否已经修改过，修改过就不需要再处理
                mapS[cs] = i + 1;
                mapT[ct] = i + 1;
            }
        }


        return true;
    }
}
