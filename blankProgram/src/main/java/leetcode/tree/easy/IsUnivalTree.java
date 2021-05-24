package leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class IsUnivalTree {
    private int val = 0;

    public boolean isUnivalTreeByDfs(TreeNode root) {
        val = root.val;

        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        boolean left = true;
        if (root.left != null){
            left = dfs(root.left);
        }
        boolean right = true;
        if (root.right != null){
            right = dfs(root.right);
        }

        return left && right && root.val == val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
