package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestor {
    //二叉搜索树，如果目标值全部小于当前结点的值，在当前结点的左子树查找，cur = cur.left
    //目标值全部大于当前结点的值在当前结点的右子树查找，cur = cur.right
    //一大一小返回当前结点

    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(6);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(8);
        TreeNode tr4 = new TreeNode(0);
        TreeNode tr5 = new TreeNode(4);
        TreeNode tr6 = new TreeNode(7);
        TreeNode tr7 = new TreeNode(9);
        TreeNode tr8 = new TreeNode(3);
        TreeNode tr9 = new TreeNode(5);
        tr1.left = tr2;
        tr1.right = tr3;
        tr2.left = tr4;
        tr2.right = tr5;
        tr4.left = tr8;
        tr4.right = tr9;
        tr3.left = tr6;
        tr3.right = tr7;
        TreeNode treeNode = lowestCommonAncestorBetter(tr1, tr2, tr5);
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历树,查找两个结点并记录路径
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        //记录从根节点到p、q结点的结点内容
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        TreeNode transeP = root;
        queueP.add(transeP);
        while (!queueP.isEmpty()) {
            TreeNode temp = queueP.peek();
            if (p.val < temp.val) {
                queueP.add(transeP.left);
                transeP = transeP.left;
            } else if (p.val == temp.val) {
                break;
            } else {
                queueP.add(transeP.right);
                transeP = transeP.right;
            }
            listP.add(queueP.poll());

        }
        if (!queueP.isEmpty()) {
            listP.add(queueP.poll());
        }
        TreeNode transeQ = root;
        queueQ.add(transeQ);
        while (!queueQ.isEmpty()) {
            TreeNode temp = queueQ.peek();
            if (q.val < temp.val) {
                queueQ.add(transeQ.left);
                transeQ = transeQ.left;
            } else if (q.val == temp.val) {
                break;
            } else {
                queueQ.add(transeQ.right);
                transeQ = transeQ.right;
            }
            listQ.add(queueQ.poll());

        }

        if (!queueQ.isEmpty()) {
            listQ.add(queueQ.poll());
        }

        //遍历链表中找到第一个元素不相等的元素上一个即为最近公共结点
        //可以优化，i放入循环，相等的时候记录List.get(i)最后直接返回记录结果
        int i = 0;
        for (; i < listP.size() && i < listQ.size(); i++) {
            if (!listP.get(i).equals(listQ.get(i))) {
                break;
            }
        }

        return listP.get(i - 1);
    }


    public static TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
        //优化抽离方法获取路径
        //条件是while(当前结点和目标结点不相同)
        //不需要遍历树，查找结点的时候遍历部分结点
        //记录从根节点到p、q结点的结点内容
        List<TreeNode> listP = getPaths(root, p);
        List<TreeNode> listQ = getPaths(root, q);

        TreeNode rs = null;
        //可以优化，i放入循环，相等的时候记录List.get(i)最后直接返回记录结果
        for (int i = 0; i < listP.size() && i < listQ.size(); i++) {
            if (listP.get(i).equals(listQ.get(i))) {
                rs = listP.get(i);
            } else {
                break;
            }
        }
        return rs;
    }

    public static List<TreeNode> getPaths(TreeNode root, TreeNode target) {
        List<TreeNode> rs = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            rs.add(node);
            //大于中间结点，向右移动
            if (node.val < target.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        //target
        rs.add(node);
        return rs;
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
