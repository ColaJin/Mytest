package leetcode.tree.easy;

public class IsBalancedII {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t4.right = t7;

        boolean balanced = isBalanced(t1);
        System.out.println(balanced);
    }

    static boolean flag = true;

    public static boolean isBalanced(TreeNode root) {
        high(root, 0);
        return flag;
    }

    // 计算树的高度差的时候如果超过1那么返回false
    public static int high(TreeNode root, int high) {
        if (root == null) {
            return high;
        }
        int left = high(root.left, high + 1);
        int right = high(root.right, high + 1);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right);
    }

    // 求高度单纯的，然后递归判断是不是平衡
    public static boolean isBalancedBetter(TreeNode root) {
        if (root == null) {
            return true;
        }
        highBetter(root);
        int left = highBetter(root.left);
        int right = highBetter(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalancedBetter(root.left) && isBalancedBetter(root.right);
    }

    public static int highBetter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(highBetter(root.left) + 1, highBetter(root.right) + 1);
    }

    // 求树的高度的同时比较高度是非负数否则不平衡
    public static boolean isBalancedBoth(TreeNode root) {
        // =0为树空
        return highBoth(root) >= 0;

    }

    public static int highBoth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = highBoth(root.left);
        int right = highBoth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(highBoth(root.left) + 1, highBoth(root.right) + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
