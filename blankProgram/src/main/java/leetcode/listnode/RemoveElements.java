package leetcode.listnode;

public class RemoveElements {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        /*ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;*/

        ListNode listNode = removeElements(n1, 1);
        System.out.println(listNode.val);
    }

    public static ListNode removeElements(ListNode head, int val) {
        //遍历链表存在相同的值就删除，最后一个结点next设置为null
        /*ListNode temp = head;
        ListNode rs = null;
        while (temp != null) {
            if (temp.val == val) {
                temp = temp.next;
            }
            rs.next = temp;
        }
        return temp;*/


        //链表头部都是当前值情况需要放在head==null判断前，否则到pre.next空指针异常
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }


        //当前指针
        ListNode prev = head;
        /*//存在链表数字全是val的情况
        if (prev.next == null && prev.val == val) {
            return null;
        }*/
        while (prev.next != null) {

            if (prev.next.val == val) {
                //下一个作为判断条件
                prev.next = prev.next.next;
            }
            /*//这样会把所有的都删掉，prev就是null，prev就是遍历的，head完全没有变化
            prev = prev.next;*/
            else {
                //移动prev
                prev = prev.next;
            }
        }

        //为什么head会发生变化???
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
