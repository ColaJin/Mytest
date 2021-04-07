package leetcode.listnode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    //正向遍历链表的变量
    private ListNode rightPointer;

    public static void main(String[] args) {
        ListNode n1 = null;
        /*ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;*/
        System.out.println(isPalindromeByReverseMiddle(n1));
    }

    public boolean isPalindrome(ListNode head) {
        //变成字符串判断是否是回文的
        StringBuffer sb = new StringBuffer();
        //链表遍历
        while (head != null) {
            sb.append(head.val);
            //移动头结点
            head = head.next;
        }

        String temp = sb.toString();
        sb.reverse();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != sb.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    public boolean isPalindromeByArrays(ListNode head) {
        //复制到数组中，使用双指针法
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            //移动头结点
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        //可以不取=
        while (i <= j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    public boolean isPalindromeByRecursion(ListNode currentNode) {
        //递归
        if (currentNode != null) {
            //一直找到尾部
            if (!isPalindromeByRecursion(currentNode.next)) {
                return false;
            }
            if (currentNode.val != rightPointer.val) {
                return false;
            }
            rightPointer = rightPointer.next;
        }
        return true;
    }


    public static boolean isPalindromeByReverseMiddle(ListNode head) {
        //反转中心点(快慢指针，快指针到尾部，慢指针即为中心位置)之后的链表，比较两个链表的元素是否相同(栈的方式)
        //最后反转回去链表(可不操作)

        //防止空指针异常
        if (head == null){
            return true;
        }

        //快慢指针，当快指针走到末尾的时候慢指针在中间
        //返回慢指针所在的结点，优化封装成方法
        ListNode slow = head;
        ListNode fast = head;

        //可以优化判断fast != null && fast.next != null
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转链表优化封装成方法
        //反转的是slow.next不是slow
        ListNode preNode = reverseList(slow.next);


        //比较链表元素是否相同，需要找其他元素比较，不要改变head和preNode
        ListNode p1 = head;
        ListNode p2 = preNode;

        //此时p2的长度比p1的多一位，导致空指针异常
        boolean result = true;
        //增加一判断位置而不是，直接return false是为了治好反转链表
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result =  false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //链表反转回来
        //反转链表优化封装成方法
        //把slow.next重新反转回来
        slow.next = reverseList(preNode);

        return result;
    }

    public static ListNode reverseList(ListNode head) {
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;//nextNode 指向下一个节点
            curNode.next = preNode;//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }

        return preNode;
    }
    static class ListNode {
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
}


