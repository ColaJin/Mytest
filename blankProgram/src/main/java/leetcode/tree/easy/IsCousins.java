package leetcode.tree.easy;

import java.util.HashMap;
import java.util.Map;

public class IsCousins {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        IsCousins isCousins = new IsCousins();
        System.out.println(isCousins.isCousins(t1, 5, 4));
        System.out.println(isCousinsWrong(t1, 5, 4));
        System.out.println(dfsLevel(t1, 4, 0));
    }


    // 遍历时全部设置成全局变量设置，不要作为参数传入
    TreeNode parentX = null;
    int levelX = 0;
    //用来比较的不需要判断是x还是y直接计算parentX和levelX
    int x = 0;
    static TreeNode parentY = null;
    static int levelY = 0;
    int y = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        // 静态的不可以调用哦
        this.x = x;
        this.y = y;
        dfsBetter(root, 0, null);
        return parentY != parentX && levelX == levelY;
    }

    public void dfsBetter(TreeNode root, int level, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentX = parent;
            levelX = level;
        } else if (root.val == y) {
            parentY = parent;
            levelY = level;
        }

        // +1不是++会改变level的值导致右侧的level结果高
        dfsBetter(root.left, level + 1, root);
        dfsBetter(root.right, level + 1, root);
    }


    static Map<TreeNode, Integer> result;

    public static boolean isCousinsWrong(TreeNode root, int x, int y) {
        // 遍历树计算结点的深度，同时，记录当前结点的父结点
        Map<TreeNode, Integer> mapX = dfs(root, x, 0, root);
        Map<TreeNode, Integer> mapY = dfs(root, y, 0, root);


        TreeNode pX = null;
        int levelX = -1;

        TreeNode pY = null;
        int levelY = -1;

        for (Map.Entry<TreeNode, Integer> vo : mapX.entrySet()) {
            pX = vo.getKey();
            levelX = vo.getValue();
        }

        for (Map.Entry<TreeNode, Integer> vo : mapY.entrySet()) {
            pY = vo.getKey();
            levelY = vo.getValue();
        }


        return pX != pY && levelX == levelY;
    }

    // 左侧的parent遍历右侧时被覆盖，右侧的高度左侧遍历时增加
    public static Map<TreeNode, Integer> dfs(TreeNode root, int val, int level, TreeNode pre) {
        if (root == null) {
            return null;
        }

        Map<TreeNode, Integer> map = new HashMap<>();
        if (root.val == val) {
            map.put(pre, level);
            return map;
        }


        if (root.left != null) {
            // 左侧遍历时level会++
            map = dfs(root.left, val, level + 1, root);
        }

        // 解决覆盖问题
        if (map.size() != 0) {
            return map;
        }

        if (root.right != null) {
            // 覆盖
            map = dfs(root.right, val, level +1, root);
        }
        // level会发生更新
        // map.put(pre, level);
        return map;
    }

    public static int dfsLevel(TreeNode root, int val, int level) {
        if (root == null) {
            return 0;
        }

        if (root.val == val) {
            return level;
        }

        if (root.left != null) {
            // 使用++level不是level++

            level = dfsLevel(root.left, val, ++level);
        }

        if (root.right != null) {
            level = dfsLevel(root.right, val, ++level);
        }


        return level;
    }


    // 广度优先遍历，队列存储结点和深度

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

    public static void dfs1(TreeNode root, int val, int level, TreeNode pre) {
        if (root == null) {
            return;
        }

        if (root.val == val) {
            result.put(pre, level);
        }

        if (root.left != null) {
            dfs1(root.left, val, ++level, root);
        }

        if (root.right != null) {
            // 覆盖
            dfs1(root.right, val, ++level, root);
        }
    }
}
