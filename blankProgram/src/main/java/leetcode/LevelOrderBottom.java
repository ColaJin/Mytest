package leetcode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LevelOrderBottom {
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
        List<List<Integer>> rs = levelOrderBottom(root);
        System.out.println(rs);
    }

    /**
     * 复杂化操作不需要重现加入到queue只需要把当前结点的左右结点直接放进去就可以
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        //层次遍历后存储的结果倒序排一下,存在问题，[[7], [15, 7], [20], [9, 20], [3]]
        // 结果多出其中遍历的单独结点
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> rs = new ArrayList<>();

        //空指针异常
        if (root == null) {
            return rs;
        }

        queue.add(root);
        // 先进先出
        while (!queue.isEmpty()) {
            //存储每一层的数据
            List<Integer> level = new ArrayList();
            //获取队列的长度
            int size = queue.size();
            while (size > 0) {
                //存储在level中？？？
                TreeNode tempTreeNode = queue.remove();
                /*//删除之后需要把这个结点重新入队列
                queue.add(tempTreeNode);*/
                level.add(tempTreeNode.val);
                size--;

                //对队列重新操作，存在问题，子节点不唯一时，导致队列存储结果出现20,9,15,17
                // 存在问题和上面存储每一层数据冲突解决：？？？？
                /*TreeNode newTreeNode = queue.remove();*/
                if (tempTreeNode.left != null) {
                    queue.add(tempTreeNode.left);
                }
                if (tempTreeNode.right != null) {
                    queue.add(tempTreeNode.right);
                }
            }
            //存储结果
            rs.add(level);


        }
        //逆转rs
        Collections.reverse(rs);

        return rs;

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
