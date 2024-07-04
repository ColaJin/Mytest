package leetcode;

import leetcode.tree.easy.HasPathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:二叉树前序遍历
 * @Date:2023/8/28
 */
public class BinaryTreePreOrder {
    static List<Integer> rs = new ArrayList();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        // 前序：根左右
        if (root == null) {
            return rs;
        }
        rs.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return rs;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        // 后序：左右根
        if (root == null) {
            return rs;
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        rs.add(root.val);
        return rs;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(preorderTraversal(treeNode));
    }
}
