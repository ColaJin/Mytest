package leetcode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStackLink {
    //定义结点包含val、min、next
    //push操作结点，结点比较当前链表上的结点的最小值，是则存入，否则使用当前链表结点的最小值

    private Node head;

    public MinStackLink() {
        head = new Node();
    }

    public void push(int x) {

        //刚开始
        if (head.next == null) {
            head = new Node(x, head, x);
        } else {
            //存入最小的值
            if (head.min < x) {
                head = new Node(x, head, head.min);
            } else {
                head = new Node(x, head, x);
            }
        }
    }

    public void pop() {
        //把头结点扔掉啦
        head = head.next;
    }

    public int top() {
        int top = head.val;
        return top;
    }

    public int getMin() {
        int min = head.min;
        return min;
    }

    public static void main(String[] args) {
        int x = 3;
        MinStackLink obj = new MinStackLink();
        obj.push(x);
        int y = 4;
        obj.push(x);
        obj.push(y);
//        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }

    class Node {
        private int val;
        private Node next;
        private int min;

        public Node() {
        }

        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }
}
