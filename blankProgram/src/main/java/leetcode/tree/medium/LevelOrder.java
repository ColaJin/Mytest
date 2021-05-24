package leetcode.tree.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        List<List<Integer>> lists = levelOrder(t1);
        for (List<Integer> lo : lists){
            for (Integer li :lo){
                System.out.println(li);
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 层次遍历，每次遍历队列长度次存储到List中
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null){
            // return null和[]不一样
            return rs;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            rs.add(list);

        }

        return rs;
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
}
