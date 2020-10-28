package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 *                  5
 *                 / \
 *                4   8
 *              /   / \
 *             11  13  4
 *           /  \      \
 *          7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode lll = new TreeNode(7);
        TreeNode llr = new TreeNode(2);
        TreeNode ll = new TreeNode(11);
        TreeNode l = new TreeNode(4);
        TreeNode root = new TreeNode(5);
        TreeNode r = new TreeNode(8);
        TreeNode rl = new TreeNode(13);
        TreeNode rr = new TreeNode(4);
        TreeNode rrr = new TreeNode(1);
        root.left = l;
        root.right = r;
        l.left = ll;
        ll.left = lll;
        ll.right = llr;
        r.left = rl;
        r.right = rr;
        rr.right = rrr;
        int sum = 25;
        boolean hasPathSum = hasPathSum(root, sum);
        System.out.println(hasPathSum);
        boolean hasPathSumBFS = hasPathSumBFS(root, sum);
        System.out.println(hasPathSumBFS);

    }

    //递归方式
    public static boolean hasPathSum(TreeNode root, int sum) {
        //把二叉树变成数组，然后计算数组元素的和是否是当前和，是则返回true,错误
        //根结点到叶子结点，深度优先遍历遍历过程计算结点的和相等返回true
        // 不能使用深度优先，不知道其余的叶子结点怎么计算
        //计算所有根节点到叶子结点的值看是否存在相等的情况
        //叶子结点的子结点(null)也会执行一次
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            //叶子结点值经过计算后的sum相同返回true
            return sum == root.val;
        }

        //左右子树中只要存在就返回true使用||,2作为11结点右子树，左子树返回false，右子树返回true
        //不明白为什么找到啦之后就一直返回啦，为什么没有其他结点判断呐
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    //失败，没有存储每次根节点到叶子结点的和
    public static int sum(TreeNode root, int sum) {
        if (root == null) {

            return 0;
        }
        sum -= root.val;
        if (root.left != null) {
            sum -= root.left.val;
            sum(root.left, sum);
        }
        if (root.right != null) {
            sum -= root.right.val;
            sum(root.right, sum);
        }
        if (root.left == null && root.right == null) {
            if (sum == 0) {

                return 0;
            }

        }
        return -1;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //广度优先遍历方式
    public static boolean hasPathSumBFS(TreeNode root, int sum) {

        //空指针异常
        if (root == null) {
            return false;
        }

        //每层遍历，找两个队列分别存储结点和结点和(根节点到当前结点)
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> nodeSum = new LinkedList<>();
        queueNode.offer(root);
        nodeSum.offer(root.val);
        //不可以使用== null判断，TreeNode tempNode = queueNode.poll();导致出现空指针异常问题
        while (!queueNode.isEmpty() && !nodeSum.isEmpty()) {
            //弹出结点比较是否是叶子结点，sum和节点和比较
            TreeNode tempNode = queueNode.poll();
            int tempSum = nodeSum.poll();
            if (tempNode.left == null && tempNode.right == null) {
                //叶子结点
                if (sum == tempSum) {
                    return true;
                }
                //从while重新开始判断
                continue;
            }
            if (tempNode.left != null) {
                queueNode.offer(tempNode.left);
                nodeSum.offer(tempSum + tempNode.left.val);
            }
            if (tempNode.right != null) {
                queueNode.offer(tempNode.right);
                nodeSum.offer(tempSum + tempNode.right.val);
            }

        }
        return false;

    }
}
