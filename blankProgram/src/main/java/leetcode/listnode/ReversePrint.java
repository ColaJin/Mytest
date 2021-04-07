package leetcode.listnode;

import java.util.Stack;

public class ReversePrint {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n3.next = n3;
        n3.next = null;
        int[] rs = reversePrintNoReverse(n1);
        for (int i:rs) {
            System.out.println(i);
        }
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

    public static int[] reversePrint(ListNode head) {

        int n = 0;
        //先反转链表然后再打印到数组中
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            n++;
        }
        int[] arr = new int[n];
        int index = 0;
        while (preNode != null) {
            arr[index] = preNode.val;
            preNode = preNode.next;
            index++;
        }

        return arr;
    }


    public static int[] reversePrintByStack(ListNode head) {
        //遍历的时候直接用栈存储，遍历栈就是逆序
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            arr[index] = stack.pop();
            index++;
        }
        return arr;
    }


    public static int[] reversePrintNoReverse(ListNode head) {
        //不需要反转，直接遍历的时候计算个数，然后逆向放入数组中
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            //不写死循环
            temp = temp.next;
        }

        int[] arr = new int[n];
        int index = n - 1;
        while (head != null) {
            arr[index] = head.val;
            index--;
            //不写数组下标越界(死循环导致)
            head = head.next;
        }
        return arr;
    }
}
