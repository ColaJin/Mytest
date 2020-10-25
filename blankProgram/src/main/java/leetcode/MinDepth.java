package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode ll = new TreeNode(9);
        TreeNode lrl = new TreeNode(15);
        TreeNode lrr = new TreeNode(7);
        TreeNode lr = new TreeNode(20, lrl, lrr);

        TreeNode root = new TreeNode(3, ll, lr);

        /*//2 minDepth
        TreeNode r = new TreeNode(4);
        TreeNode root = new TreeNode(3,null,r);*/

        /*
        //3minDepth
        TreeNode lr = new TreeNode(4);
        TreeNode l = new TreeNode(1,null,lr);

        TreeNode rrr = new TreeNode(6);
        TreeNode rr = new TreeNode(5,null,rrr);
        TreeNode r = new TreeNode(3,null,rr);

        TreeNode root = new TreeNode(2,l,r);*/

        int minDepth = minDepth(root);
        System.out.println(minDepth);
        int minDepthDepthOrderTraverse = minDepthDepthOrderTraverse(root);
        System.out.println(minDepthDepthOrderTraverse);
    }

    public static int minDepth(TreeNode root) {
        //计算所有根节点到叶子结点的高度，返回最小的高度，相当于深度优先遍历
        //遍历所有结点，找到叶子结点，同时计算高度，相当于层次遍历
        // 官方的层次遍历使用啦一个QueueNode 类存储结点和最小高度

        //层次遍历遇到的第一个叶子节点为minDepth
        // 此想法有问题（其实没有），右子树比左子树要短，在层次遍历中也是先遍历到短的叶子结点
        if (root == null) {
            return 0;
        }

        //记录最小深度
        int count = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先进先出
        while (!queue.isEmpty()) {
            //计算每层
            count++;
            //计算当前队列的长度，否则出现问题（一直遍历到底层的叶子结点）
            int size = queue.size();
            while (size > 0) {
                TreeNode tempTreeNode = queue.remove();
                if (tempTreeNode.left != null) {
                    queue.add(tempTreeNode.left);
                }
                if (tempTreeNode.right != null) {
                    queue.add(tempTreeNode.right);
                }
                //层次遍历的叶子结点
                if (tempTreeNode.left == null&&tempTreeNode.right == null) {
                    return count;
                }
                //长度要减少
                size--;
            }


        }

        return count;
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

    //TODO：深度优先遍历(前序遍历)
    public static int minDepthDepthOrderTraverse(TreeNode root) {
        /*if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int size = Integer.MAX_VALUE;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);//先放根节点
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right == null && node.left == null ){
                //这样导致只要是子树都会进入判断，导致最后一个结点size少1使结果不正确
                size = Math.min(stack.size()+1,size);
            }
            //然后放右结点
            if (node.right != null) {
                stack.push(node.right);
            }
            //最后放左节点
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return size;*/

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int size = Integer.MAX_VALUE;

        if (root.left != null) {
            //使用递归达到深度优先遍历
            size = Math.min(minDepthDepthOrderTraverse(root.left), size);
        }
        if (root.right != null) {
            size = Math.min(minDepthDepthOrderTraverse(root.right), size);
        }
        return size;
    }
}
