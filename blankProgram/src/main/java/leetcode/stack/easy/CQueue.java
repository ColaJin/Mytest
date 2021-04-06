package leetcode.stack.easy;

import java.util.Stack;

class CQueue {
    //临时栈存储数据
    Stack<Integer> inStack;
    //存储队列中的元素
    Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        //可优化代码，先判断outStack是否为空，为空的时候把inStack数据放入，然后再判断outStack是否为空返回正确的值
        /*if(outStack.empty() && inStack.empty()){
         return -1;
         }else if(outStack.empty() && !inStack.empty()){
         while(!inStack.empty()){
         outStack.push(inStack.pop());
         }
         }*/


        return outStack.pop();
    }
}
