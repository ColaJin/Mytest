package leetcode.listnode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;
        ListNode listNode = deleteDuplicatesJ(l11);
        //判断条件是listNode不是.next
        while (listNode != null) {
            System.out.println(listNode.val);
            //一定要有否则一直输出listNode.next的值
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        //j指针记录不重复数据
        //未遍历结束的时候如果下一个结点和当前的值一致，那么指针后移否则赋值指针

        //移动指针
        ListNode j = head.next;

        //当前指针
        ListNode prev = head;
        while (prev != null && prev.next != null) {

            if (prev.next.val != prev.val) {
                prev = prev.next;
            } else {

                prev.next = prev.next.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicatesJ(ListNode head) {
        //j指针记录不重复数据
        //未遍历结束的时候如果下一个结点和当前的值一致，那么指针后移否则赋值指针

        //链表为null一定要增加判断
        if (head == null) {
            return head;
        }

        //移动指针
        ListNode j = head.next;

        //当前指针
        ListNode prev = head;

        //记录结果的指针
        ListNode rs = head;
        while (prev != null && j != null) {

            if (j.val != prev.val) {
                //元素不相等时，prev指向该元素
                prev.next = j;
                //赋值prev为这个元素
                prev = j;
                //j跟着prev的下一个指向的位置
                j = prev.next;
            } else {
                //相等元素时，j后移
                j = j.next;
                //最后两位相同的情况直接让prev的下一个指向为null，是j不是j.next空指针
                if (j == null) {
                    prev.next = null;
                }
            }
        }
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
