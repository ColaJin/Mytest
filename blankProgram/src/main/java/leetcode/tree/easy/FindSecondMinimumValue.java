package leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class FindSecondMinimumValue {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(5);
//        TreeNode t4 = new TreeNode(5);
//        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        /*t3.left = t4;
        t3.right = t5;*/

        int rs = findSecondMinimumValueBetter(t1);
        System.out.println(rs);
    }


    public static int findSecondMinimumValue(TreeNode root) {
        // 不存在返回-1,必须使用Long类型否则存在Integer的最大值的情况
        long first = Long.MAX_VALUE;
        long second = Long.MAX_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // 遍历的时候如果根存在子树，那么遍历根中子树最小的一面就可以
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                // 存在子树，如果第二小的值在大的那面也就是类似右斜树
                /*if (temp.left.val < temp.right.val) {
                    queue.add(temp.left);
                }

                if (temp.right.val < temp.left.val) {
                    queue.add(temp.right);
                }*/
                queue.add(temp.left);
                queue.add(temp.right);
            }

            if (temp.val < first) {
                second = first;
                first = temp.val;
            } else if (temp.val < second && temp.val > first) {
                // 大于第一个
                second = temp.val;
            }
        }

        return second != Long.MAX_VALUE ? (int) second : -1;
    }

    static int min = Integer.MAX_VALUE;
    static int subMin = Integer.MAX_VALUE;

    // 深度优先遍历(可以直接在遍历的时候判断根和左右子树是否是相同的3个结点)
    public static boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val < min) {
            subMin = min;
            min = root.val;
        } else if (root.val < subMin && root.val > min) {
            // 大于第一个
            subMin = root.val;
        }

        boolean left = dfs(root.left, root.val);
        boolean right = dfs(root.right, root.val);

        return left || right || root.val != val;
    }

    public static int findSecondMinimumValueDfs(TreeNode root) {

        boolean isSame = dfs(root, root.val);
        if (!isSame) {
            return -1;
        }

        return subMin;
    }


    // 判断最小值之后取第二大的,减少遍历的次数
    static int rs = -1;

    public static int findSecondMinimumValueBetter(TreeNode root) {
        if(root == null){
            return rs;
        }

        // 双条件else，否则遍历的减少
        if (root.left != null && root.left.val != root.right.val) {
            // 左右结点比较
            int bigger = root.left.val > root.right.val ? root.left.val : root.right.val;

            // 可能存在第二小的值,比较在bigger和被修改的rs最小为第二小
            rs = rs == -1 ? bigger : Math.min(bigger,rs);
            // 不能直接return,选择小的一面
            findSecondMinimumValue(root.left.val > root.right.val ? root.right : root.left) ;

        }else {
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }

        return rs;
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
