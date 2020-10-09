package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 */
public class IsSameTree {
    public static void main(String[] args) {
        //第一个二叉树
        TreeNode fl2 = new TreeNode(4);
        TreeNode fr2 = new TreeNode(5);
        TreeNode fl1 = new TreeNode(2, fl2, fr2);
        TreeNode fr1 = new TreeNode(3);
        TreeNode fv1 = new TreeNode(1, fl1, fr1);

        //相等的第二个二叉树
        TreeNode sl2 = new TreeNode(4);
        TreeNode sr2 = new TreeNode(5);
        TreeNode sl1 = new TreeNode(2, sl2, sr2);
        TreeNode sr1 = new TreeNode(3);
        TreeNode sv1 = new TreeNode(1, sl1, sr1);

        //不相等第二个二叉树
        TreeNode snl1 = new TreeNode(2);
        TreeNode snr1 = new TreeNode(3);
        TreeNode snv1 = new TreeNode(1, snl1, snr1);

        boolean isSame = isSameTree(fv1, sv1);
        boolean isDifferernt = isSameTree(fv1, snv1);

        System.out.println(isSame);
        System.out.println(isDifferernt);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> rs = new ArrayList<>();
        List<Integer> pl = changeArray(p, rs);
        //需要清空rs
        rs = new ArrayList<>();
        List<Integer> ql = changeArray(q, rs);
        //转换成数组后长度不相等直接返回false
        if (pl.size() != ql.size()) {
            return false;
        }
        //数组长度相等时,比较每一位置，不相等就返回false
        for (int i = 0; i < pl.size(); i++) {
            //空指针异常写法null == null
            if ( ! (pl.get(i) == null ? ql.get(i) == null : pl.get(i).equals(ql.get(i)))) {
                return false ;
            }
        }
        //数组完全相同即二叉树完全相同
        return true;
    }

    //rs需要作为参数传进去否则结果总是最后一次的结果
    public static List<Integer> changeArray(TreeNode node, List<Integer> rs) {

        if (node != null) {
            //当前结点不为null时直接加入其结点
            rs.add(node.val);
            //判断左右孩子的情况并把结果返回
            changeArray(node.left, rs);
            changeArray(node.right, rs);
        } else {
            rs.add(null);
        }
        return rs;
    }
}

class TreeNode {
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
