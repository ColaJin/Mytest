package leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(1);
        TreeNode tr1 = new TreeNode(2);
        tr.left = tr1;
        invertTreeByQueue(tr);
    }

    public static TreeNode invertTree(TreeNode root) {
        //递归优化，对左子树翻转得到的树变成右子树，对右子树翻转得到的树变成左子树
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        //交换左右子树
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        return root;
    }

    public static TreeNode invertTreeByQueue(TreeNode root) {
        if(root == null){
            return null;
        }
        //广度优先遍历，队列存储结点，每次交换改左右结点，如果结点左右子树不为null，子树放入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            //使用||而不是&&，空的也要变成null
            if (peek.left != null || peek.right != null){
                TreeNode temp = peek.left;
                peek.left = peek.right;
                peek.right = temp;
            }
            if (peek.left != null){
                queue.add(peek.left);
            }
            if (peek.right != null){
                queue.add(peek.right);
            }
            queue.poll();
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
