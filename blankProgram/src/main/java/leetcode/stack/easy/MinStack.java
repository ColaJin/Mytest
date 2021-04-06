package leetcode.stack.easy;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    //这一时期的最小值
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //可以优化，先把min栈中放入MAX_VALUE，比较最小的值放入到min栈中
        if (min.empty() || min.peek() > x) {
            //为null或者最小值大于当前压入的值
            min.push(x);
        } else {
            //栈顶元素不变
            min.push(min.peek());
        }
    }

    public void pop() {

        stack.pop();
        //要popmin栈
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        //超时
        /*Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            if (min > stack.peek()) {
                min = stack.peek();
            }
            temp.push(stack.pop());
        }
        //导致栈逆序
        //stack = temp;
        while (!temp.empty()){
            stack.push(temp.pop());
        }*/
        //获取peek不是要pop
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

