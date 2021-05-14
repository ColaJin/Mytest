package leetcode.tree.easy;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {

        /*if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }*/

        // 简化
        if (root == null || root.val == val) {
            return root;
        }

        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    // 迭代
    public TreeNode searchBSTByIterator(TreeNode root, int val) {

        /*if (root == null) {
            return null;
        }

        while (root != null) {

            if (root.val == val) {
                return root;
            }
            root = root.val > val ? root.left : root.right;
        }
        return null;*/

        while (root != null && root.val != val) {
            // 不能return
            // return root = root.val > val ? root.left : root.right;
            root = root.val > val ? root.left : root.right;
        }

        return root;
    }


    class TreeNode {
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
