package leetcode.tree.easy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxDepthN {
    public static void main(String[] args) {
        List<Node> n1c = new ArrayList<Node>();
        List<Node> n2c = new ArrayList<Node>();
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n2c.add(n5);
        n2c.add(n6);
        Node n2 = new Node(3, n2c);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        n1c.add(n2);
        n1c.add(n3);
        n1c.add(n4);
        Node n1 = new Node(1, n1c);


        System.out.println(maxDepthByIteration(n1));
    }

    public static int maxDepth(Node root) {
        //从1开始
        int max = 1;
        if (root == null) {
            return 0;
        }
        if (root.children != null) {
            //防止空指针
            for (Node children : root.children) {
                max = Math.max(max, maxDepth(children) + 1);
            }
        }

        return max;
    }


    public static int maxDepthByIteration(Node root) {
        //采用迭代的·方式Pair存储结点和最大值(getKey(),getValue())
        Stack<Pair<Node, Integer>> stack = new Stack<Pair<Node, Integer>>();

        //从1开始
        if (root == null) {
            return 0;
        }

        Pair<Node, Integer> pair = new Pair<>(root, 1);
        stack.push(pair);
        int depth = 0;
        //迭代的条件
        while (!stack.isEmpty()) {
            //弹出结点压入子节点
            Pair<Node, Integer> temp = stack.pop();
            //方式Pair存储结点和最大值
            Node key = temp.getKey();
            int curDepth = temp.getValue();

            if (key.children != null) {

                for (Node children : key.children) {
                    //压入子结点
                    stack.push(new Pair<>(children, curDepth + 1));
                }
            }
            //if外层比较否则少1层,或者判断是root != null
            depth = Math.max(curDepth, depth);
        }


        return depth;
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

    ;
}
