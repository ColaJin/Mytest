package leetcode.listnode;

/**
 *给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 */
public class HasCycle {
    public static void main(String[] args) {

        /*ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(0);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(3);
        n1.next = n2;
        n4.next = n2;*/
        ListNode n2 = new ListNode(2);

        ListNode n1 = new ListNode(3);
        n1.next = n2;
        boolean hasCycle = hasCycle(n1);
        System.out.println(hasCycle);
    }

    public static boolean hasCycle(ListNode head) {

        /*//设置一个pre指向头结点
        ListNode pre = new ListNode(-1);
        pre.next = head;

        //循环不太行走不出去
        while (pre.next != null) {
            int count = 0;
            int val = pre.next.val;
            while (pre.next.next != null) {
                //进入环循环不能结束
                int next = pre.next.next.val;
                if (val == next) {
                    count++;
                }
                pre=pre.next;
                if (count != 0) {
                return true;
            }
            }

            pre = pre.next;
        }*/
        //没有next为空的结点就是有环的
        ListNode slow = head;
        ListNode fast = head;

        //如果有两个头结点指针，一个走的快，一个走的慢，那么若干步以后，快的指针总会超过慢的指针一圈。
        // 需要增加判断fast != null否则，fast.next != null空指针异常
        //不能使用slow.next!=null && fast.next.next!=null出现空指针异常[],-1还有其他情况
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

        //可以优化while条件使用slow != fast
        //head==null或者head.next==null返回false
        //循环中fast==null或者fast.next==null返回false
        //注意此时的fast不是head而是head.next


    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //使用HashSet存储，head需要移动，不能存储时返回键true(存在环)，不存在环时跳出while循环然后返回false


    //存在环时，链表反转后头结点还是头结点，否则不存在环(链表反转后头结点变成尾结点)
}
