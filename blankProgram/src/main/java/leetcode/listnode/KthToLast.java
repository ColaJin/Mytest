package leetcode.listnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode formmer = head;
        ListNode latter = head;
        while (k > 0){
            formmer = formmer.next;
            k--;
        }

        while (formmer != null){
            formmer = formmer.next;
            latter = latter.next;
        }
        //同之前的指针法，先走K步然后再一起走
        return latter.val;
    }

    public int kthToLastByStack(ListNode head, int k) {
        //同之前的栈方法，存储到栈中弹出(倒数)
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        while (k > 1){
            stack.pop();
            k--;
        }
        return stack.pop();
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
