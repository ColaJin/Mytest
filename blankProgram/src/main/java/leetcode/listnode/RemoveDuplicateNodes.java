package leetcode.listnode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        System.out.println(removeDuplicateNodesByViolence(n1));
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        //遍历的时候放入set中，如果set包含这个值的话，那么就直接删除当前元素
        Set<Integer> set = new HashSet<>();
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //可以优化：pre=cur和pre.next = cur.next,cur都是=cur.next
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                //记录当前元素
                pre = cur;
                cur = cur.next;
            } else {
                //包含元素的时候需要删除当前元素
                ListNode next = cur.next;
                pre.next = cur.next;
                /*if(next == null){
                    //到尾
                    break;
                }*/
                //不可以是next.next会连跳两位
                cur = next;
            }

        }

        return head;
    }

    //暴力法(时间换空间)
    public static ListNode removeDuplicateNodesByViolence(ListNode head) {
        //从头遍历链表
        ListNode out = head;
        while (out != null) {
            ListNode in = out.next;
            ListNode pre = out;
            while (in != null) {
                if (in.val == out.val) {
                    //删除元素，如果pre没有赋值给in时，pre为null，产生空指针异常
                    pre.next = in.next;
                } else {
                    //else,否则删除结果变少
                    pre = in;
                }
                in = in.next;
            }
            out = out.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
