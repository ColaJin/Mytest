package leetcode;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9, 10, 11, 12, 13, 14, 15, 16};
        TreeNode node = sortedArrayToBST(nums);
//        TreeNode node = sortedArrayToBSTRecursion(nums);
        ergodic(node);


    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        /**
         * 二叉搜索树(二叉排序树、二叉查找树)
         *         若他的左子树不为空，则左子树上所有节点的值都小于根节点的值
         *         若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
         *         它的左右子树也分别是二叉搜索树
         *
         * 平衡二叉搜索树(AVL)
         *          左子树与右子树高度之差的绝对值不超过1
         *          树的每个左子树和右子树都是AVL树
         *          每一个节点都有一个平衡因子（balance factor），任一节点的平衡因子是-1、0、1（每一个节点的平衡因子 = 右子树高度 - 左子树高度）
         */

        //超出数组边界
        if (nums.length == 0) {
            return null;
        }

        //先插入一个结点，但是树是null的,作为根节点,
        TreeNode root = new TreeNode(nums[0]);


        //遍历nums作为结点然后组成树
        //每次插入的结点都是比前一个结点大，那么就让他做根节点，需要高度
        //递归需要有的
        TreeNode rs = root;
        //从第一个开始存储数据
        for (int i = 1; i < nums.length; i++) {

            rs = insert(nums[i], rs);
        }
        return rs;

    }

    //插入
    private static TreeNode insert(int x, TreeNode t) {
        if (t == null) {
            //根节点插入时只有当前结点
            TreeNode root = new TreeNode(x);
            return root;
        }

        int compareResult = 0;
        if (x > t.val) {
            compareResult = 1;
        } else if (x < t.val) {
            compareResult = -1;
        }

        if (compareResult < 0) {
            //插入进来的值小于当前结点的值
            t.left = insert(x, t.left);//将x插入左子树中
            if (heigth(t.left) - heigth(t.right) == 2) {
                //打破平衡
                if (x < t.left.val) {
                    //LL型（左左型），不存在这种情况因为插入的结点的值都是大的,可以插入比之前结点小的数字，查看情况
                    t = rotateWithLeftChild(t);
                } else {
                    //LR型（左右型），不存在这种情况因为插入的结点的值都是大的
                    t = doubleWithLeftChild(t);
                }
            }
        }
        if (compareResult > 0) {
            //插入进来的值小于当前结点的值
            t.right = insert(x, t.right);//将x插入右子树中
            if (heigth(t.right) - heigth(t.left) == 2) {
                //打破平衡
                if (x > t.right.val) {
                    //RR型（右右型）
                    t = rotateWithRightChild(t);
                } else {
                    //RL型
                    t = doubleWithRightChild(t);
                }
            }
        }
        // 重复数据，什么也不做
        return t;
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

    //带左子树旋转,适用于LL型
    private static TreeNode rotateWithLeftChild(TreeNode k2) {
        TreeNode k1 = k2.left;
        //k2.left变成k1的的右子树
        k2.left = k1.right;
        //k1变成根节点，k2作为右子树
        k1.right = k2;
        return k1;
    }

    //带右子树旋转，适用于RR型
    private static TreeNode rotateWithRightChild(TreeNode k1) {
        TreeNode k2 = k1.right;
        //k1.right变成k2的左子树
        k1.right = k2.left;
        //k2变成根节点，k1作为左子树
        k2.left = k1;
        return k2;
    }

    //双旋转,适用于RL型先左子树转再右子树转
    private static TreeNode doubleWithRightChild(TreeNode k1) {
        //先把结点的右子树LL
        k1.right = rotateWithLeftChild(k1.right);
        //根据该节点再进行RR
        return rotateWithRightChild(k1);
    }

    //双旋转，适用于LR型，先右子树转再左子树转
    private static TreeNode doubleWithLeftChild(TreeNode k3) {
        //先把结点的左子树RR
        k3.left = rotateWithRightChild(k3.left);
        //根据该结点再进行LL
        return rotateWithLeftChild(k3);
    }

    //遍历平衡二叉树
    public static void ergodic(TreeNode root) {

        //空指针异常
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先进先出
        while (!queue.isEmpty()) {
            TreeNode tempTreeNode = queue.remove();
            System.out.println(tempTreeNode.val);
            if (tempTreeNode.left != null) {
                queue.add(tempTreeNode.left);
            }
            if (tempTreeNode.right != null) {
                queue.add(tempTreeNode.right);
            }
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //TODO：递归的方式

    public static TreeNode sortedArrayToBSTRecursion(int[] nums) {
        //有序数组，查找中间结点，使用中间结点的左侧或者右侧的结点作为根节点递归
        // 或者说是使用任意一个结点做根节点，然后递归

        int left = 0;
        int right = nums.length - 1;
        TreeNode node = subTreeNode(left, right, nums);
        return node;

    }

    //子树
    public static TreeNode subTreeNode(int left, int right, int[] nums) {

        //跳出递归
        if (left > right) {
            return null;
        }

        //有序数组，查找中间结点，使用中间结点的左侧或者右侧的结点作为根节点递归
        // 或者说是使用任意一个结点做根节点，然后递归


        //使用中间结点左面结点作为根节点
//        int mid = (left + right) / 2;

        //使用中间结点的右面结点作为根节点
//        int mid = (left + right + 1) / 2;

        //使用任意结点做根节点，随机数产生需要注意能转换成int否则报错，不能*100数组会超出范围
        int mid = (left + right + (int) (Math.random())) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //不能使用while循环因为一直是left<right
//        while (left < right) {
        root.left = subTreeNode(left, mid - 1, nums);
        root.right = subTreeNode(mid + 1, right, nums);
//        }

        return root;

    }
}
