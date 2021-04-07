package leetcode.listnode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(deleteNode(n1, 1).val);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        //找到该结点，然后删除结点
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                //存储下一个结点
                ListNode next = cur.next;
                //删除当前结点(head和pre都是指向同一链表的)
                pre.next = next;

            }
            //之前的这个全被更新掉，导致结果出现问题
            //上一个结点后移
            pre = cur;
            //当前结点后移
            cur = cur.next;
        }

        return head;
    }

    public static ListNode deleteNodeBetter(ListNode head, int val) {
        if (head.val == val) {
            //头结点相等直接返回头结点的下一个结点(删除头结点)
            return head.next;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        //可以优化判断条件cur != null && cur.val!=val
        while (cur != null) {
            if (cur.val == val){
                //找到结点退出循环
                break;
            }
            pre = cur;
            //死循环哦
            cur = cur.next;
        }

        //可优化直接判断cur != null
        if (cur == null){
            //不存在这样的结点
        }else {
            //删除结点
            pre.next = cur.next;
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
