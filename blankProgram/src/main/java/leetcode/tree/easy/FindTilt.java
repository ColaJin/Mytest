package leetcode.tree.easy;


public class FindTilt {
    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(4);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(9);
        TreeNode tr4 = new TreeNode(3);
        TreeNode tr5 = new TreeNode(5);
        TreeNode tr6 = new TreeNode(7);

        tr1.left = tr2;
        tr1.right = tr3;
        tr2.left = tr4;
        tr2.right = tr5;
        tr3.right = tr6;
        //System.out.println(findTilt(tr1));
        //System.out.println(max);
        System.out.println(findTiltInterpret(tr1));
        System.out.println(max);
    }

    static int max = 0;

    public static int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = findTilt(root.left);

        int right = findTilt(root.right);

        max += Math.abs(left - right);

        //遍历结点的时候需要把结点的所有左右子节点val相加

        //这样只算了儿子左右子树的值不是所有的左右子树
        return left + right + root.val;
    }

    //计算整个树的和
    public static int findTiltInterpret(TreeNode node) {
//        int max = 0;
        if (node == null) {
            return 0;
        }
        //左子树和
        int left = findTiltInterpret(node.left);
        int right = findTiltInterpret(node.right);
        //计算坡度
        max += Math.abs(left - right);
        //整个树的和
        return left + right + node.val;
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
