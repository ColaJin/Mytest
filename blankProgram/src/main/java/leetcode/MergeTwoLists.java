package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        /*ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;
        ListNode result = mergeTwoLists(l11, l21);
        System.out.println(result);*/
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode ll = mergeTwoLists(l1, l2);

        /*do {

            result = result.next;
        } while (result != null);*/


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        List<Integer> list = new ArrayList<>();
        if (l1.next != null) {
            do {
                list.add(l1.val);
                l1 = l1.next;
            } while (l1 != null);
        }
        if (l2.next != null) {
            do {
                list.add(l2.val);
                l2 = l2.next;
            } while (l2 != null);
        }

        Collections.sort(list);

        if (list.size() > 0) {
            ListNode head = new ListNode(list.get(0)); // 把数组的第一个位置定义为头结点
            ListNode other = head; // 一个指针，此时指向头结点
            for (int i = 1; i < list.size(); i++) { //头结点已经定义，从1开始
                ListNode temp = new ListNode(list.get(i));
                other.next = temp;
                other = other.next;

            }//在此处打印结点容易导致head的变化
            return head;
        }

        //ListNode l1 = new ListNode();这种方式创建的val为0，next为null的链表，返回结果new ListNode()会导致输出链表为[0]
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsDIGUI(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsDIGUI(l1.next, l2);
            return l1;

        } else {
            l2.next = mergeTwoListsDIGUI(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsDIEDAI(ListNode l1, ListNode l2) {

        //头结点
        ListNode prehead = new ListNode(-1);
        //头指针
        ListNode prev = prehead;
        //循环
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        //至多有一个是非空的，有序直接接在链表后
        prev.next = l1 == null ? l1 : l2;
        return prehead.next;

    }
}
