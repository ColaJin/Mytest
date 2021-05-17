package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    private TreeNode rs;
    // 两者都优化为找一个结点-1，然后去中序遍历直接修改节点的指向,左节点指向为null，结果节点的有结点指向当前结点，结果结点为当前结点
    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp = new TreeNode(-1);
        rs = temp;
        inOrder(root);

        return temp.right;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // 栈溢出
        inOrder(root.left);

        rs.right = root;
        // 这里注意是 root.left,不是rs.left，rs变成root
        root.left = null;
        rs = root;

        inOrder(root.right);
    }

    public class TreeNode {
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
