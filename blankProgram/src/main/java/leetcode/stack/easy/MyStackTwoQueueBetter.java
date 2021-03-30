package leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackTwoQueueBetter {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStackTwoQueueBetter() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //往队列尾部插入元素，当超出队列界限的时候，add()方法是抛出异常让你处理，而offer()方法是直接返回false
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            //queue2加入弹出的queue1的元素
            queue2.offer(queue1.poll());
        }

        //再把queue2的元素放到queue1
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        //清空queue
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
