package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(sumRootToLeaf(t1));
    }

    private static List<String> list = new ArrayList<>();
    private static StringBuffer path = new StringBuffer();

    public static int sumRootToLeaf(TreeNode root) {
        // 深度优先遍历，存储根到叶子结点的路径，每次到叶子结点放入到List中，计算List中的二进制的值
        /*int sum = 0;
        dfs(root);
        for (String i : list) {

            sum += Integer.parseInt(i, 2);
        }
        return sum;*/
        dfsDirectly(root, 0);
        return sum;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path.append(String.valueOf(root.val));
            list.add(path.toString());
            // 什么时候清空String：无效,导致最外层级的被删除掉
            // path = new StringBuffer();

            // 不是清空而是删除最后一位
            path.deleteCharAt(path.length() - 1);
        }


        if (root.left != null) {
            path.append(String.valueOf(root.val));
            dfs(root.left);
        }

        if (root.right != null) {
            path.append(String.valueOf(root.val));
            dfs(root.right);
        }

    }

    static int sum = 0;

    // 递归的时候直接计算
    // 当叶子结点的时候，+=当前路径和
    public static void dfsDirectly(TreeNode root, int cur) {
        if (root == null) {
            return;
        }

        cur = (cur << 1) + root.val;
        if (root.left == null && root.right == null) {
            sum += cur;
        }


        if (root.left != null) {
            dfsDirectly(root.left, cur);
        }

        if (root.right != null) {
            dfsDirectly(root.right, cur);
        }

    }

    public static class TreeNode {
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
