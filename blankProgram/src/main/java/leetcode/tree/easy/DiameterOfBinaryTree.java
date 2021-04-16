package leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(3);
        TreeNode tr2 = new TreeNode(1);
        TreeNode tr3 = new TreeNode(2);
        TreeNode tr4 = new TreeNode(4);
        TreeNode tr5 = new TreeNode(5);

        tr1.left = tr2;
        tr2.right = tr3;
        /*tr2.left = tr4;
        tr2.right = tr5;*/

        /*int rs = diameterOfBinaryTree(tr1);
        System.out.println(rs);*/

        dfs(tr1);
        System.out.println(max + "dfs");
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        //计算结点左叶子结点和右叶子结点距离的最大值
        //遍历结点，找当前结点对应的左叶子结点和右叶子结点，然后计算结点距离的最大值

        //老公：子树的高度
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);

            //计算左右高度之后，路径就为左右高度
            int high = leftHeight + rightHeight;
            if (max < high) {

                max = high;
            }
            if (node.left != null) {

                queue.add(node.left);
            }
            if (node.right != null) {

                queue.add(node.right);
            }
        }
        return max;

    }

    //可优化直接深度优先遍历的时候计算高度然后比较
    public static void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        dfs(root.left);
        getPath(root);
        dfs(root.right);
    }

    public static int getPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getPath(root.left);
        int rigth = getPath(root.right);

        max = Math.max(max, left + rigth);

        return Math.max(left, rigth) + 1;
    }

    //计算树的高度:是左右结点的高度的最大值+1
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int rigth = getHeight(root.right);

        return Math.max(left, rigth) + 1;
    }

    //是否是叶子结点
    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
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
