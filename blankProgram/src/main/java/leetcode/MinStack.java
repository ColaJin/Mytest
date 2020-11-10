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
public class MinStack {
    private Stack<Integer> myStack;
    private Stack<Integer> minStack;

    public MinStack() {
        myStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {

        myStack.push(x);
        //此处需要判断最小栈是否为null'否则导致空栈异常
        //注意此处需要<=否则后面如果遇到相同栈顶元素的数字导致栈空
        // 例如["MinStack","push","push","push","getMin","pop","getMin"]
        //[[],[0],[1],[0],[],[],[]]
        //此时如果是<那么min栈中只有0一个元素(第一次push的0),弹出0时弹出导致栈空
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = myStack.pop();
        //最小栈顶元素相同
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {

        int top = myStack.peek();
        return top;
    }

    public int getMin() {
        /*//不需要增加判断，题目说明pop、top 和 getMin 操作总是在 非空栈 上调用。
        if (minStack.empty()){
            return -1;
        }*/
        int top = minStack.peek();
        return top;
    }

    public static void main(String[] args) {
        int x = 0;
        MinStack obj = new MinStack();
        obj.push(x);
        int y = 1;
        obj.push(y);
        int z = 0;
        obj.push(z);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
