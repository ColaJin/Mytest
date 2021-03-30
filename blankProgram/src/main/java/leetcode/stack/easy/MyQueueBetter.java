package leetcode.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueueBetter {
    //deque双端队列，支持迭代器，有push_back()方法，跟vector差不多，比vector多了个pop_front,push_front方法；
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueueBetter() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        //入栈放入数据
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //判断出栈是否为null，此时需要把入栈的数据弹出至出栈中，出栈达到先入后出的队列效果
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        //判断出栈是否为null，此时需要把入栈的数据弹出至出栈中，出栈达到先入后出的队列效果
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        //两个栈都为null则为空，否则为不空
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
