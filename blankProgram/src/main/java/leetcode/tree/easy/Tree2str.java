package leetcode.tree.easy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Tree2str {

    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(1);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(3);
        TreeNode tr4 = new TreeNode(4);
        tr1.left = tr2;
        tr1.right = tr3;
        tr2.left = tr4;

        System.out.println(tree2strByIterator(tr1));

    }

    public String tree2str(TreeNode t) {
        //递归：四种情况，null的情况，左右都为null，右子树为null，都不为null
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return "" + t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    public static String tree2strByIterator(TreeNode t) {

        //[]空指针异常
        if (t == null){
            return "";
        }
        //迭代，使用栈，判断结点的左子树存在右子树存在,字符串加上(当前结点
        //左右都为null弹出栈，字符串)，左子树为null，右子树不为null，字符串(),
        //使用HashSet存储是否遍历过结点是则一直弹出字符串加)
        //先放右子树
        //结果去掉开头和结尾两个(
        Deque<TreeNode> deque = new LinkedList<>();
        //存储值有重复出现问题
        Set<TreeNode> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        deque.push(t);

        while (!deque.isEmpty()) {
            TreeNode node = deque.peek();
            /*if (!set.contains(node.val)) {
                set.add(node.val);
                sb.append("(").append(node.val);
            } else {
                //少了一个)当左子树为不为null右子树为null时
                deque.pop();
                if (node.left == null && node.right == null) {

                    sb.append(")");
                }

                if (node.left == null && node.right != null) {
                    sb.append("()");
                }

                if (node.right != null) {
                    deque.push(node.right);
                }
                if (node.left != null) {
                    deque.push(node.left);
                }
            }*/

            if (set.contains(node)) {
                deque.pop();
                sb.append(")");
            } else {
                set.add(node);
                sb.append("(").append(node.val);
                /*
                //不需要增加)
                if (node.left == null && node.right == null) {

                    sb.append(")");
                }*/

                if (node.left == null && node.right != null) {
                    sb.append("()");
                }

                if (node.right != null) {
                    deque.push(node.right);
                }
                if (node.left != null) {
                    deque.push(node.left);
                }
            }
        }

        return sb.substring(1, sb.length() - 1);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
