package leetcode.stack.easy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "}(";
        boolean result = isValid(s);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        boolean result = false;
        if (s.length()%2 == 1) {
            return false;
        }
        ArrayList<Character> cold = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            cold.add(s.charAt(i));
        }
        ArrayList<Character> cnew = new ArrayList<>();
        for (int i = 0; i < cold.size(); i++) {
            if (cold.get(i) == '(' || cold.get(i) == '[' || cold.get(i) == '{') {
                cnew.add(cold.get(i));
            } else {
                //此字符串在右括号前没有左括号"}("
                if (cnew.size()==0) {
                    return false;
                }
                int top = cnew.size() - 1;
                if (cold.get(i) == ')') {
                    if (cnew.get(top) != '(') {

                        return false;
                    } else {
                        cnew.remove(top);
                    }
                }
                if (cold.get(i) == ']') {
                    top = cnew.size() - 1;
                    if (cnew.get(top) != '[') {

                        return false;
                    } else {
                        cnew.remove(top);
                    }
                }
                if (cold.get(i) == '}') {
                    top = cnew.size() - 1;
                    if (cnew.get(top) != '{') {

                        return false;
                    } else {
                        cnew.remove(top);
                    }
                }
            }
        }
        if (cnew.size()==0){
            return true;
        }
        return result;
    }

    public boolean isValid1(String s) {
        if (s.length() % 2 == 0) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        return false;
    }
}
