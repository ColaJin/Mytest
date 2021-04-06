package leetcode.listnode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        ListNode rs = reverseList(l1);
        ListNode node = reverseListByR(l1);
        System.out.println(node.val);

    }

    //这种叫做迭代
    public static ListNode reverseList(ListNode head) {
        /*//存储成字符串反转之后再变成链表
        StringBuffer sb = new StringBuffer();
        ListNode pre = head;
        while (pre != null){
            sb.append(pre.val);
            pre = pre.next;
        }
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            System.out.println(c);
            if (Character.isDigit(c)){  // 判断是否是数字
                int num = (int)c - (int)('0');
                head.val = num;
                head = head.next;//然后再吧要添加的元素做为头部
            }
//		Node node=new Node(e);//要添加的元素
//		node.next=head;//元素指向 原来头部的元素
//		head=node;//然后再吧要添加的元素做为头部
        }
        return head;*/
        if (head == null || head.next == null){
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;

        while (curNode != null){
            nextNode = curNode.next;//nextNode 指向下一个节点
            curNode.next = preNode;//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }

        return preNode;
    }

    //递归
    public static ListNode reverseListByR(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = reverseListByR(head.next);
        head.next.next = head;
        //head最后的next为null
        head.next = null;
        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
