package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Postorder {

    public static void main(String[] args) {
        List<Node> son = new ArrayList<>();

        Node n1 = new Node(5);
        Node n2 = new Node(6);
        son.add(n1);
        son.add(n2);
        Node n3 = new Node(3, son);

        Node n4 = new Node(2);
        Node n5 = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(n3);
        children.add(n4);
        children.add(n5);
        Node n6 = new Node(1, children);
        dfs(n6);
        for (Integer i : list) {

            System.out.println(i);
        }
    }

    //必须指定类型，否则遍历报错
    static LinkedList<Integer> list = new LinkedList<>();
    static Deque<Node> deque = new LinkedList<Node>();

    public static List<Integer> postorder(Node root) {
        dfs(root);
        return list;
    }

    public static void dfs(Node root) {
        //非递归后序遍历
        if (root == null) {
            return;
        }

        deque.push(root);

        //会进入死循环怎么写条件呐
        while (!deque.isEmpty()) {

            Node node = deque.poll();
            //头插
            list.addFirst(node.val);

            //从右向左加入子节点,栈的方式队列的方式是层次遍历不是后序遍历
            if (node.children != null) {
                //没有子节点直接遍历
                for (Node children : node.children) {
                    deque.push(children);
                }
            }

        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
