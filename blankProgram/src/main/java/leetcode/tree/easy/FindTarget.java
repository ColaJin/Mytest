package leetcode.tree.easy;

import java.util.*;

public class FindTarget {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        findTargetByTwoPoint(t1,1);
    }

    // 递归变成迭代
    public boolean findTarget(TreeNode root, int k) {
        // 需要一个Set判断当前结点和traget的差是否存在存在返回true
        Set<Integer> set = new HashSet<>();

        //BFS 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (set.contains(k - temp.val)) {
                return true;
            } else {
                set.add(temp.val);
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return false;
    }

    // 采用双指针的方式，返回的排好序的list，然后双指针找
    public static boolean findTargetByTwoPoint(TreeNode root, int k) {
        // 中序遍历返回一个有序的数组
        List<Integer> list = new ArrayList<>();
        getModel(root, list);

        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            if (list.get(low) + list.get(high) < k) {
                low++;
            } else if (list.get(low) + list.get(high) > k) {
                high--;
            } else {
                return true;
            }
        }

        return false;
    }

    // 不需要返回值list跟着改变
    public static void getModel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }

        getModel(root.left, list);
        list.add(root.val);
        getModel(root.right, list);
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
