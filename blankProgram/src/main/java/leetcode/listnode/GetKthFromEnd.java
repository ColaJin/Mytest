package leetcode.listnode;

public class GetKthFromEnd {
    public static void main(String[] args) {

    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        //可以采用former和latter直接的差距一直保持k的距离，返回latter
        ListNode former = head;
        ListNode latter = head;
        while (k > 0) {
            former = former.next;
            k--;
        }

        while (former != null){
            latter = latter.next;
            former = former.next;
        }

        return latter;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
