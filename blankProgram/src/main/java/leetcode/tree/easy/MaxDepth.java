package leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(20);
        TreeNode rrl = new TreeNode(15);
        TreeNode rrr = new TreeNode(7);
        root.left = rl;
        root.right = rr;
        rr.left = rrl;
        rr.right = rrr;
        int depth = maxDepthRecursive(root);
        int depth1 = maxDepth(root);
        System.out.println(depth);
        System.out.println(depth1);
    }

    public static int maxDepthRecursive(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //计算左子树的高度
        int i = maxDepth(root.left);
        //计算右子树的高度存在疑惑？？？为什么这个递归会变成3
        int j = maxDepth(root.right);
        //比较大小然后返回+1的结果
        return i < j ? j + 1 : i + 1;
    }

    public static int maxDepth(TreeNode root) {
        //广度优先遍历的层次，深度优先遍历的高度,不能直接高度加一，增加判断就是队列的长度>0
        //记录深度
        int count = 0;

        //空指针异常
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先进先出
        while (!queue.isEmpty()) {
            //计算当前队列的长度
            int size = queue.size();
            while (size > 0) {
                TreeNode tempTreeNode = queue.remove();
                if (tempTreeNode.left != null) {
                    queue.add(tempTreeNode.left);
                }
                if (tempTreeNode.right != null) {
                    queue.add(tempTreeNode.right);
                }
                //长度要减少
                size--;
            }
            //计算每层
            count++;
        }

        return count;
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

