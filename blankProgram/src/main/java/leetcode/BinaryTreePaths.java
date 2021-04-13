package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(1);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(3);
        TreeNode tr4 = new TreeNode(5);
        tr1.left = tr2;
        tr1.right = tr3;
        tr2.right = tr4;
        List<String> rs = binaryTreePathsByBroad(tr1);
        for (String s : rs) {
            System.out.println(s);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        //List存储路径，遍历树的结点，如果该结点的左右子树都为null证明是叶子结点，此时加入到List中
        //遍历一个结点的如果他的左子树不为null，遍历左子树的时候加上本身这个结点
        //遍历一个结点如果他的右子树不为null，遍历右子树的时候就加上本身这个结点
        //遍历一个结点如果左右子树都为null，返回List
        List<String> rs = new ArrayList<>();
        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            queue.add(root.left);
            queue.add(root.right);*/
        //不用再赋值啦此时rs已经改变
        //rs = appendNode(root, "", rs);

        appendNodeBetter(root, "", rs);
        //rs.add(rootS);
        /*}*/
        return rs;
    }

    //深度优先遍历
    public static List<String> appendNode(TreeNode root, String str, List<String> rs) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            rs.add(sb.toString());
            return rs;
        }
        if (root.left != null && root.right != null) {
            sb.append(root.val);
            sb.append("->");
            appendNode(root.left, sb.toString(), rs);
            appendNode(root.right, sb.toString(), rs);
        } else if (root.left != null) {
            sb.append(root.val);
            sb.append("->");
            appendNode(root.left, sb.toString(), rs);
        } else if (root.right != null) {
            sb.append(root.val);
            sb.append("->");
            appendNode(root.right, sb.toString(), rs);
        }

        //不能是null
        return rs;
    }


    public static void appendNodeBetter(TreeNode root, String str, List<String> rs) {
        //深度优先遍历
        //可以优化无参返回，先sb.append(root.val)然后处理第一种的其他都是 sb.append("->");左右
        if (root != null) {
            //防止NullPointerException
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                rs.add(sb.toString());
            } else {
                sb.append("->");
                appendNodeBetter(root.left, sb.toString(), rs);
                appendNodeBetter(root.right, sb.toString(), rs);
            }
        }
    }


    public static List<String> binaryTreePathsByBroad(TreeNode root) {
        //广度优先维持一个存储路径的队列和一个遍历的队列，当时叶子结点的时候加入到List中当前路径队列的出队列的元素
        //遍历一个结点如果左右子树都为null，加入List
        List<String> rs = new ArrayList<>();

        if (root == null) {
            return rs;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //存储root到结点的路径
        Queue<String> path = new LinkedList<>();


        queue.add(root);
        path.add(String.valueOf(root.val));
        //队列判空不能用 != null
        while (!queue.isEmpty()) {

            TreeNode peek = queue.poll();
            String curPath = path.poll();

            if (peek.left == null && peek.right == null) {
                rs.add(curPath);
            } else {
                if (peek.left != null){
                    queue.add(peek.left);
                    path.add(new StringBuffer(curPath).append("->" + peek.left.val).toString());
                }
                if (peek.right != null){
                    queue.add(peek.right);
                    //需要拼接字符串
                    path.add(new StringBuffer(curPath).append("->" + peek.right.val).toString());

                }
            }


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
