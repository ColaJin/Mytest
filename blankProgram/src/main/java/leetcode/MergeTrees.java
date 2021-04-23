package leetcode;

public class MergeTrees {

    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(1);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(3);
        TreeNode sr1 = new TreeNode(1);
        TreeNode sr2 = new TreeNode(2);
        TreeNode sr3 = new TreeNode(3);

        tr1.left = tr2;
        tr2.left = tr3;

        sr1.right = sr2;
        sr2.right = sr3;

        mergeTrees(tr1, sr1);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //两个结点如果都为null那么返回null
        //两个结点一个为空返回另外一个
        //两个结点不为空返回结点和

        TreeNode node = new TreeNode();

        if (root1 == null && root2 == null) {
            //return的是null不是node否则初始为0
            return null;
        }

        if (root1 == null && root2 != null) {
            node.val = root2.val;
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
            return node;
        }

        if (root1 != null && root2 == null) {
            node.val = root1.val;
            //也需要左右子树
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
            return node;
        }

        if (root1 != null && root2 != null) {
            node.val = root1.val + root2.val;
        }

        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
    }

    //可优化，直接根据t1，t2是否为null返回t1或者t2，其他时候直接返回
    public static TreeNode mergeTreesBetter(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            //返回root2
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode node = new TreeNode(root1.val + root2.val);

        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
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
