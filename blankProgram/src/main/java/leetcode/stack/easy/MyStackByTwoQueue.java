package leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackByTwoQueue {
    private Integer top;
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStackByTwoQueue() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //更新栈顶元素为最新的元素
        top = x;
        //queue1为空的时候证明队列是空的，栈也是空的
        if (queue1.isEmpty()) {
            queue1.add(x);
        } else {
            //queue2加入元素
            queue2.add(x);
            while (!queue1.isEmpty()) {
                //queue2加入弹出的queue1的元素
                queue2.add(queue1.poll());
            }

            //再把queue2的元素放到queue1
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        //弹出栈顶元素即队列的队首元素
        int temp = queue1.poll();
        //更新top，如果队列为null的时候top = queue1.peek();空指针异常
        if (queue1.isEmpty()){
            top = null;
        }else {
            top = queue1.peek();
        }
        return temp;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStackByTwoQueue myStackByTwoQueue = new MyStackByTwoQueue();
        myStackByTwoQueue.push(1);
        myStackByTwoQueue.pop();
        System.out.println(myStackByTwoQueue.empty());
    }
}
