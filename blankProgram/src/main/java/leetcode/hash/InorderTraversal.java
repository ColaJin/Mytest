package leetcode.hash;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        List<Integer> rs = inorderTraversal(t1);
        rs.stream().forEach(System.out::println);
    }

    // 迭代
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 优化后可取消判断
        /*if(root == null) {
            return list;
        }*/
        // 需要栈作为迭代存储的结构
        Deque<TreeNode> deque = new LinkedList<>();
        // deque.offer(root);
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                /*root = root.left;
                // 取消判断，需要调整到root更新之前
                if (root != null) {
                    // push()
                    deque.offer(root);
                }*/
                deque.push(root);
                root = root.left;
            }

            // pop()
            // TreeNode temp = deque.pollLast();
            TreeNode temp = deque.pop();
            list.add(temp.val);

            /*if (temp.right != null) {
                root = temp.right;
                deque.offer(root);
            }*/
            root = root.right;

        }
        return list;
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
