package leetcode.tree.easy;

import java.util.*;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode tr5 = new TreeNode(7);
        TreeNode tr4 = new TreeNode(15);
        TreeNode tr3 = new TreeNode(20, tr4, tr5);
        TreeNode tr2 = new TreeNode(9);
        TreeNode tr1 = new TreeNode(2, tr2, tr3);

        //int count = sumOfLeftLeaves(tr1);
        int count = sumOfLeftLeavesByBroad(tr1);
        System.out.println(count);
    }


    public static int sumOfLeftLeaves(TreeNode root) {
        //遍历二叉树如果当前结点有左右孩子，遍历左孩子的左孩子...
        //遍历二叉树如果当前结点有左右孩子，遍历右孩子的左孩子...
        List<Integer> rs = new ArrayList();
        if (root.left == null && root.right == null) {
            return 0;
        }
        Boolean isRight = false;
        //getLeftLeaf(root, rs, isRight);
        //getLeftLeafByBroad(root, rs);
        int total = 0;
        for (int i : rs) {
            total += i;
        }
        return total;
    }

    public static List<Integer> getLeftLeaf(TreeNode root, List<Integer> rs, Boolean isRight) {
        //根节点需要判断不能放入

        if (root.left == null && root.right == null && !isRight) {
            rs.add(root.val);
            return rs;
        } else {
            if (root.left != null) {
                isRight = false;
                getLeftLeaf(root.left, rs, isRight);
            }
            //这样会导致缺失左子树的右子树的左叶子丢失
            if (root.right != null) {
                isRight = true;
                getLeftLeaf(root.right, rs, isRight);
            }
        }
        return rs;
    }


    public static List<Integer> getLeftLeaf(TreeNode root, List<Integer> rs) {
        //根节点需要判断不能放入
        //可以优化取消标志位，判断条件做修改，只计算左叶子

        if (root.left != null) {

            getLeftLeaf(root.left, rs);
        }
        //这样会导致缺失左子树的右子树的左叶子丢失
        if (root.right != null) {
            getLeftLeaf(root.right, rs);
        }

        //不可以放在上面判断终，计算缺失
        if (root.left != null && root.left.left == null && root.left.right == null) {
            //左子树的时候加上左值
            rs.add(root.left.val);
            return rs;
        }


        return rs;
    }


    public static List<Integer> getLeftLeafByBroad(TreeNode root, List<Integer> rs) {
        //广度遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                getLeftLeafByBroad(root.left, rs);
            }
            if (root.right != null) {
                getLeftLeafByBroad(root.right, rs);
            }

            //不可以放在上面判断，计算缺失
            if (root.left != null && root.left.left == null && root.left.right == null) {
                //左子树的时候加上左值
                rs.add(root.left.val);
            }

        }


        return rs;
    }


    public static int sumOfLeftLeavesByBroad(TreeNode root) {
        //广度优化：直接计算结果左子树不空的时候判断左子树是否是叶子结点，是加上结果否则是广度遍历左子树
        //计算结果+=右子树广度遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int total = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                boolean isleaf = isLeaf(node.left);
                if (isleaf) {
                    total += node.left.val;
                } else {
                    //减少了叶子结点加入到队列中
                    queue.add(node.left);
                }
            }
            //左右都要放入
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        return total;
    }

    public static int getLeftLeafByDeep(TreeNode root) {
        //判空需要放在最外面否则返回0
        /*if (root == null){
            return 0;
        }*/
        //深度遍历
        int total = 0;
        if (root.left != null) {
            total += isLeaf(root.left) ? root.left.val : getLeftLeafByDeep(root.left);
        }
        if (root.right != null) {
            total += getLeftLeafByDeep(root.right);
        }
        return total;
    }

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