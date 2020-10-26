package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 *          1
 *         / \
 *        2   2
 *      / \
 *     3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class IsBalanced {
    public static void main(String[] args) {
        //高度平衡
        TreeNode lll = new TreeNode(1);
        TreeNode ll = new TreeNode(9, lll, null);
        TreeNode lrl = new TreeNode(15);
        TreeNode lrr = new TreeNode(7);
        TreeNode lr = new TreeNode(20, lrl, lrr);

        TreeNode root = new TreeNode(5, ll, lr);


        /*//高度不平衡
        TreeNode l = new TreeNode(2);
        TreeNode lll = new TreeNode(4);
        TreeNode llr = new TreeNode(4);
        TreeNode ll = new TreeNode(3, lll, llr);
        TreeNode lr = new TreeNode(3);
        TreeNode r = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);*/

        /*TreeNode llr = new TreeNode(2);
        TreeNode ll = new TreeNode(1,null,llr);
        TreeNode l = new TreeNode(9,ll,null);

        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode r = new TreeNode(20,rl,rr);
        TreeNode root = new TreeNode(3,l,r);*/

        /*boolean balanced = isBalanced(root);
        System.out.println(balanced);*/
        boolean balancedRecursive = isBalancedRecursive(root);
        System.out.println(balancedRecursive);
        boolean balancedRecursiveDownToUp = isBalancedRecursiveDownToUp(root);
        System.out.println(balancedRecursiveDownToUp);

    }

    public static boolean isBalanced(TreeNode root) {
        //遍历每一个结点，判断结点的左子树和右子树的高度差是否是2，左-右=2，右-左=-2

        //空指针异常
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先进先出
        while (!queue.isEmpty()) {
            TreeNode tempTreeNode = queue.remove();
            //注意>=2
            if (Math.abs(heigth(tempTreeNode.left) - heigth(tempTreeNode.right)) >= 2) {
                //打破平衡
                return false;
            }
            if (tempTreeNode.left != null) {
                queue.add(tempTreeNode.left);
            }
            if (tempTreeNode.right != null) {
                queue.add(tempTreeNode.right);
            }
        }
        return true;
    }

    //计算树的高度
    private static int heigth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算左子树的高度
        int i = heigth(root.left);
        //计算右子树的高度存在疑惑？？？为什么这个递归会变成3
        int j = heigth(root.right);
        //比较大小然后返回+1的结果
        return i < j ? j + 1 : i + 1;
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


    //自顶而下的递归
    public static boolean isBalancedRecursive(TreeNode root) {

        if (root == null) {
            return true;
        }

        /*//直接return或者直接递归，返回的结果并不是想要的
        if (root.left != null) {
            isBalancedRecursive(root.left);
        }
        if (root.right != null) {
             return isBalancedRecursive(root.right);
        }*/

        /*//这样处理也不可以，返回结果平衡的变成非平衡
        if (Math.abs(heigth(root.left) - heigth(root.right)) > 1 || isBalancedRecursive(root.left) || isBalancedRecursive(root.right)) {
            return false;
        }*/

        //注意是！左子树平衡和！右子树平衡的情况
        if (Math.abs(heigth(root.left) - heigth(root.right)) > 1 || !isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }


        /*//可优化,是小于等于1
        return ((Math.abs(heigth(root.left) - heigth(root.right)) <= 1) && isBalancedRecursive(root.left) && isBalancedRecursive(root.right));*/

        return true;
    }


    //自底向上的递归
    public static boolean isBalancedRecursiveDownToUp(TreeNode root) {
        return heigthRecurive(root) >= 0;

    }

    //计算树的高度
    private static int heigthRecurive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //计算左子树高度
        int leftHight = heigthRecurive(root.left);
        //计算右子树高度
        int rightHight = heigthRecurive(root.right);

        //不平衡时返回树的高度就是-1
        if (Math.abs(leftHight - rightHight) > 1 || leftHight == -1 || rightHight == -1) {
            return -1;
        }
        //平衡时返回树的高度
        return Math.max(leftHight, rightHight) + 1;

    }

}
