package leetcode.stack.easy;

import java.util.Stack;

public class BackspaceCompare {
    public static void main(String[] args) {
        String S = "a##c";
        String T = "#a#c";
        //System.out.println(backspaceCompare(S, T));
        //System.out.println(build(S).equals(build(T)));
        System.out.println(backspaceCompareByTwoPoint(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        //遍历S的字符把的元素放入栈中，判断当字符为#执行栈的pop操作，如果栈为null时，不操作，否则执行栈的push操作
        //同样遍历T的字符把元素放入栈2中
        //比较栈1和栈2的元素是否相同
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#' && !stack1.empty()) {
                stack1.pop();
            } else if (c != '#') {
                stack1.push(c);
            }
        }
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#' && !stack2.empty()) {
                stack2.pop();
            } else if (c != '#') {
                stack2.push(c);
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.empty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }

        return true;
    }

    //重构字符串，比较字符串是否相同
    public static String build(String s) {
        //遍历字符串，判断字符是否是#，是的话新字符串删除最后一个字符，否直接加上字符
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    //双指针
    //是否删除比较字符取决于后面的#个数，从后遍历两个字符串的字符，每次找到有效的字符进行比较
    //不相等返回false，或者两个都变为空时结束

    public static boolean backspaceCompareByTwoPoint(String S, String T) {
        int sp = S.length() - 1;
        int tp = T.length() - 1;
        int sk = 0;
        int tk = 0;
        while (sp >= 0 || tp >= 0) {
            while (sp >= 0) {
                if (S.charAt(sp) == '#') {
                    sp--;
                    sk++;
                } else if (sk > 0) {
                    //else if否则直接跳过#
                    sk--;
                    sp--;
                } else {
                    break;
                }
            }

            while (tp >= 0) {
                if (T.charAt(tp) == '#') {
                    tp--;
                    tk++;
                }else if (tk > 0) {
                    //else if否则直接跳过#
                    tk--;
                    tp--;
                } else {
                    break;
                }
            }
            if (tp >= 0 && sp >= 0) {
                if (S.charAt(sp) != T.charAt(tp)) {
                    return false;
                }
            } else {
                //其中一个已经结束，另外一个还没结束
                if (tp >= 0 || sp >= 0) {
                    return false;
                }
            }


            //比较之后需要更新指针位置
            sp--;
            tp--;
        }

        return true;
    }
}
