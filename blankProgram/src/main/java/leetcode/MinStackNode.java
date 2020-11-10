package leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStackNode {
    //定义结点存储当前值和最小值
    private Stack<Node> stack;

    public MinStackNode() {
        stack = new Stack<>();
    }

    public void push(int x) {
        //空栈
        if (stack.empty()) {

            Node node = new Node(x, x);
            stack.push(node);
        } else {
            //最小值比较，存入时如果小那么就直接存储新的最小值，否则不变
            if (stack.peek().min > x) {
                Node node = new Node(x, x);
                stack.push(node);
            } else {
                Node node = new Node(x, stack.peek().min);
                stack.push(node);
            }
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        int top = stack.peek().val;
        return top;
    }

    public int getMin() {
        int min = stack.peek().min;
        return min;
    }

    public static void main(String[] args) {
        MinStackNode obj = new MinStackNode();
        int x = 3;
        obj.push(x);
        int y = 4;
        obj.push(y);
//        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }

    class Node {
        private int val;
        private int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

    }
}
