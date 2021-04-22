package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Preorder {

    public static void main(String[] args) {
        List<Node> son = new ArrayList<>();

        Node n1 = new Node(6);
        Node n2 = new Node(5);
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

    static List<Integer> list = new ArrayList<>();
    static Deque<Node> deque = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        recursive(root);
        return list;
    }

    //前序遍历递归
    public void recursive(Node root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        for (Node node : root.children) {
            recursive(node);
        }
    }

    //前序非递归
    public static void dfs(Node root) {
        if (root == null) {
            return;
        }

        deque.push(root);

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            list.add(node.val);
            //从右向左加入子节点,栈的方式队列的方式是层次遍历不是前序遍历
            if (node.children != null) {
                //没有子节点直接遍历
                int n = node.children.size();
                for (int i = n - 1; i >= 0; i--) {
                    deque.push(node.children.get(i));
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
