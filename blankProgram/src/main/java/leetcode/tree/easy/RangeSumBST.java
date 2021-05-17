package leetcode.tree.easy;

import weichat.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class RangeSumBST {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(10);
        TreeNode t5 = new TreeNode(15);
        TreeNode t6 = new TreeNode(18);
        t4.left = t2;
        t4.right = t5;
        t2.left = t1;
        t2.right = t3;
        t5.right = t6;

        System.out.println(rangeSumBSTByBfs(t4, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        // 中序遍历， >=low <=high的结点返回
        dfs(root, low, high);
        return sum;

    }

    // sum存不住值，因为是值传递
    /*public static void dfs(TreeNode root, int low, int high, int sum) {
        if (root == null) {
            return;
        }

        dfs(root.left, low, high, sum);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        dfs(root.right, low, high, sum);

    }*/

    static int sum = 0;

    public static void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        dfs(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        dfs(root.right, low, high);

    }

    // dfs优化，4种情况，null，>high,<low,low<<high
    public static int rangeSumBSTByDfsBetter(TreeNode root, int low, int high) {
        // 中序遍历， >=low <=high的结点返回
        if (root == null) {
            return 0;
        }

        if (root.val > high) {
            // 左子树
            rangeSumBSTByDfsBetter(root.left, low, high);
        } else if (root.val < low) {
            rangeSumBSTByDfsBetter(root.right, low, high);
        }
        return root.val + rangeSumBSTByDfsBetter(root.left, low, high) + rangeSumBSTByDfsBetter(root.right, low, high);

    }


    // 层次遍历时比较情况>high,<low,low<<high,决定遍历的结点
    public static int rangeSumBSTByBfs(TreeNode root, int low, int high) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val < low) {
                // 防止空指针异常
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else if (temp.val > high) {
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
            } else {
                sum += root.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return sum;
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
