package leetcode.stack.easy;

import java.util.Stack;

public class CalPoints {
    public static void main(String[] args) {
        String[] ops = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        //数字直接入栈操作
        //C字符栈的pop操作
        //D字符，栈顶元素*2，再push到栈
        //+字符，弹出栈顶元素并记录temp，计算新栈顶和temp的和，把temp压入栈，和压入栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                stack.pop();
            } else if (ops[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (ops[i].equals("+")) {
                int temp = stack.pop();
                int newPeek = stack.peek();
                stack.push(temp);
                stack.push(temp + newPeek);
            } else {
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        int total = 0;
        while (!stack.empty()) {
            total += stack.pop();
        }

        return total;
    }
}
