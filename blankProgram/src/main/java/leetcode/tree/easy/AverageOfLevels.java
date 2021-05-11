package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
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

        averageOfLevelsByDep(t1);
    }

    // 广度遍历
    public List<Double> averageOfLevels(TreeNode root) {
        // 两个队列存储，父节点和孩子结点，当父节点的队列为null时，队列copy
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueC = new LinkedList<>();
        List<Double> list = new ArrayList<>();

        // 层次遍历树，计算每层的结果计算
        if (root == null) {
            return null;
        }
        queueP.add(root);
        list.add(Double.valueOf(root.val));
        while (!queueP.isEmpty()) {
            TreeNode node = queueP.poll();

            if (node.left != null) {
                queueC.add(node.left);
            }

            if (node.right != null) {
                queueC.add(node.right);
            }

            if (queueP.isEmpty() && !queueC.isEmpty()) {
                Double temp = 0.0;
                int count = 0;
                while (!queueC.isEmpty()) {
                    TreeNode child = queueC.poll();
                    temp += child.val;
                    count++;
                    queueP.add(child);
                }
                list.add(temp / count);
            }
        }

        return list;
    }

    // 广度遍历优化
    public static List<Double> averageOfLevelsByBroadBetter(TreeNode root) {
        // 使用一个队列，每次遍历队列长度次
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();

        // 层次遍历树，计算每层的结果计算
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {

            Double temp = 0.0;
            int count = queue.size();
            // 使用count不是queue.size()
            for (int i = 0; i < queue.size(); i++) {
                // 队列长度
                TreeNode node = queue.poll();
                temp += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(temp / count);

        }

        return list;
    }

    // 深度优先遍历
    public static List<Double> averageOfLevelsByDep(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        dfs(root, 0, sum, count);

        for (int i = 0; i < sum.size(); i++) {

            list.add(sum.get(i) / count.get(i));
        }

        return list;
    }

    // 深度优先遍历，两个数组记录层数和sum
    public static void dfs(TreeNode root, int level, List<Double> sum, List<Integer> count) {
        if (root == null) {
            return;
        }

        // 条件是<sum，此时sum中存在level的数据
        if (level < sum.size()) {
            // set(int index, E element);
            // 修改的是level位置，值变成加上当前的root
            sum.set(level, sum.get(level) + root.val);
            // 修改level位置的个数+1
            count.set(level, count.get(level) + 1);
        } else {
            // 此时为root是根节点的时候0！<0
            sum.add(Double.valueOf(root.val));
            count.add(1);
        }

        if (root.left != null) {
            dfs(root.left, level + 1, sum, count);
        }

        if (root.right != null) {
            dfs(root.right, level + 1, sum, count);
        }
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
