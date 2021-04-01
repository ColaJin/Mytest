package leetcode.stack.easy;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String S = "aabbcc";
        System.out.println(removeDuplicatesDirectly(S));
    }

    public static String removeDuplicates(String S) {
        //栈存储字符串的字符，每次遍历的时候和栈顶元素比较如果相等的话，弹出栈顶元素
        //把栈中的元素逆向组成字符串返回
        Stack<Character> stack = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                //同栈顶元素相同，弹出
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        //也可以采用for循环遍历栈，不再是逆序
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    //直接操作字符串，类似栈的实现
    public static String removeDuplicatesDirectly(String S) {
        StringBuffer sb = new StringBuffer();
        sb.append(S.charAt(0));
        //可优化，创建标志位top=-1，append时++，delete(top>=0)时--,top为sb的索引
        for (int i = 1; i < S.length(); i++) {
            //sb长度要>0否则sb.length() - 1变成-1索引越界，需要是sb.length() - 1否则i-1造成sb索引越界
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == S.charAt(i)) {
                //删除当前字符串
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }

}
