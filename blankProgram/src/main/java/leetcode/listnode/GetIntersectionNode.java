package leetcode.listnode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA4 = new ListNode(2);
        ListNode headA3 = new ListNode(1);
        ListNode headA2 = new ListNode(9);
        ListNode headA1 = new ListNode(0);
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        ListNode headB2 = new ListNode(2);
        ListNode headB1 = new ListNode(3);
        headB1.next = headB2;
        ListNode intersectionNode = getIntersectionNode(headA1, headB1);
        System.out.println(intersectionNode.val);
        ListNode intersectionNodeByMeet = getIntersectionNodeByMeet(headA1, headB1);
        System.out.println(intersectionNodeByMeet);
    }


    //暴力法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preB = headB;
        //条件不要是headA.next否则最后一个结点不进入判断
        while (headA != null) {
            headB = preB;
            while (headB != null) {
                //嵌套循环导致headB一直变成啦最后一个结点，所以preB记录headB，每次都让B从头开始
                //注意此处使用的是结点相同不是值相同否则输出出错
                if (headA.val == headB.val) {
                    return headA;
                }
                headB = headB.next;

            }
            /*//遍历一个结点
            if (headA.val == headB.val) {
                return headA;
            } else {
                headB = headB.next;
            }*/
            headA = headA.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //错的人迟早会走散，而对的人迟早会相逢
    //两个结点都走自己的链表，知道两个链表结点相同返回结点的结果，存在相交返回相交结点，否则返回null结点
    //人家的思路是走对方走过的路
    public static ListNode getIntersectionNodeByMeet(ListNode headA, ListNode headB) {
        //两个结点遍历
        ListNode preA = headA;
        ListNode preB = headB;
        //解决空指针异常
        if (headA == null || headB == null) {
            return null;
        }
        while (headA != headB) {
            //当无交点时最后heaA和headB会重合在null(各自的尾结点)
            headA = headA.next;
            //发生空指针异常
            headB = headB.next;
            if (headA == null && headB != null) {
                //人家的代码
                headA = preB;
                //headA = preA;
            }
            if (headB == null && headA != null) {
                headB = preA;
                //headB = preB;
            }
        }
        //无交点
        if (headA == null) {
            return null;
        }
        //返回交点
        return headA;
    }
}
