package leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String S = "()()";
        System.out.println(removeOuterParenthesesByTwoStack(S));
    }

    public static String removeOuterParentheses(String S) {
        //记录(和)的个数，当个数相等时，重新开始计算(和)个数
        //不等的时候把(和)压入栈
        //弹出栈的元素返回String
        int left = 0;
        int right = 0;
        //使用队列，栈是反向输出
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
                if (left == 1) {
                    continue;
                }
            } else {
                right++;
            }
            if (left == right) {
                left = 0;
                right = 0;
            } else {
                queue.offer(S.charAt(i));
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    //直接字符操作，遇到)，左括号个数--，左括号个数>0的时候开始append,遇到(，左括号个数++
    public static String removeOuterParenthesesDirectly(String S) {
        StringBuffer sb = new StringBuffer();
        int leftCount = 0;
        for (Character c : S.toCharArray()) {
            if (c == ')') {
                //不能使用equals
                leftCount--;
            }
            if (leftCount > 0) {
                sb.append(c);
            }
            if (c == '(') {
                leftCount++;
            }
        }
        return sb.toString();
    }


    //两个栈操作，其中一个栈2存储左括号，另外一个栈2存储最外层括号的位置
    //遇到左括号，判断栈是否为空，是则为最外层(记录位置到栈2中
    //遇到右括号，弹出栈1栈顶元素判断是否为空，是则为最外层的)记录位置到栈2中
    //遍历栈2然后删除字符串中该位置的字符即可

    public static String removeOuterParenthesesByTwoStack(String S) {
        Stack<Character> cStack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < S.length(); i++) {
            //用来删除元素
            sb.append(S.charAt(i));
            if (S.charAt(i) == '(') {
                if (cStack.isEmpty()) {
                    //最外层左括号位置存储到iStack
                    iStack.push(i);
                }
                //放入左括号到cStack
                cStack.push(S.charAt(i));
            } else {
                //弹出左括号
                cStack.pop();
                if (cStack.isEmpty()) {
                    //最外层右括号位置存储到iStack
                    iStack.push(i);
                }
            }
        }

        //把字符串中的iStack位置的字符删除
        while (!iStack.isEmpty()) {
            sb.deleteCharAt(iStack.pop());
        }

        return sb.toString();
    }


}
