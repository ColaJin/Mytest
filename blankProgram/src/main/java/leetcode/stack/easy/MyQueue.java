package leetcode.stack.easy;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack2.isEmpty()) {
            stack2.add(x);
        } else {
            //把栈2的元素都弹出放入栈1中
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
            //使最后放入的元素在栈顶，然后再copy到栈1中
            stack1.add(x);
        }

        //栈1的元素弹出放入到栈2中，使得栈2中元素变成先进的元素在栈顶，后进的元素在栈底
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty();
    }
}
