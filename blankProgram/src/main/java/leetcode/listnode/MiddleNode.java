package leetcode.listnode;

public class MiddleNode {
    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        ListNode rs = middleNodeByArrays(n1);
        System.out.println(rs.val);
    }

    public static ListNode middleNode(ListNode head) {
        //快慢指针，当快指针走到末尾的时候慢指针在中间
        //返回慢指针所在的结点
        ListNode slow = head;
        ListNode fast = head;

        //可以优化判断fast != null && fast.next != null
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null && fast.next.next == null) {
            //返回第二个结点
            slow = slow.next;
        }
        return slow;
    }


    public static ListNode middleNodeByArrays(ListNode head) {
        //存储到数组中然后返回数组的n/2位置
        //数组类型为ListNode
        //int[] arr = new int[]{};
        /*int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int i = 0;
        while (i < n / 2) {
            head = head.next;
            i++;
        }
        return head;*/

        //1~100之间
        ListNode[] arr = new ListNode[100];
        int n = 0;
        while (head != null) {
            arr[n++] = head;
            head = head.next;
        }

        return arr[n/2];
    }

    //单指针遍历两次，第一次算N，第二次运行到n/2,上方法注解内容


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}



