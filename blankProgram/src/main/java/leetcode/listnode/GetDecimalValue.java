package leetcode.listnode;

public class GetDecimalValue {
    public static void main(String[] args) {
//        ListNode n3 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n1 = new ListNode(0);
        n1.next = n2;
        n2.next = null;
//        n3.next = null;
        System.out.println(getDecimalValueByOnceTraverse(n1));
    }

    public static int getDecimalValue(ListNode head) {
        //遍历一次记录链表的长度，然后遍历第二次，每次计算当前结点的val的2^(n-1)
        ListNode temp = head;
        int n = 0;
        int count = 0;
        while (head != null) {
            n++;
            head = head.next;
        }

        //此时head已经为null
        while (temp != null) {
            //移动没搞清楚
            count += temp.val * (1 << (n - 1));
            /*count += temp.val*(Math.pow(2,n-1));*/
            n--;
            temp = temp.next;
        }
        return count;
    }


    public static int getDecimalValueByOnceTraverse(ListNode head) {
        //一次遍历
        int rs = 0;
        while (head != null) {
            //rs左移一位(相当乘2)
            rs <<= 1;
            //最右侧加上当前的值
            rs += head.val;
            head = head.next;
        }
        return rs;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
