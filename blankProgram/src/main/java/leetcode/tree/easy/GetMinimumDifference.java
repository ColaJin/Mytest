package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {

    //可以优化不使用数组，直接比较最小值
    List<Integer> arr = new ArrayList<>();
    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        //暴力法
        //数组存储所有的结点
        //每次访问新结点遍历数组计算最小绝对值
        //维持一个变量是最小绝对值
        //中序遍历按照从小大到遍历，然后计算最小的绝对值

        dfs(root);
        return min;

    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        //cal(root.val);
        //直接比较
        if (pre == -1) {
            pre = root.val;
        } else {
            //比较最小值
            min = Math.min(min, Math.abs(root.val - pre));
            //更新pre
            pre = root.val;
        }

        dfs(root.right);
    }

    public void cal(int cur) {
        if (pre == -1) {
            //第一个点

        } else {
            //计算绝对值
            for (int i = 0; i < arr.size(); i++) {
                int abs = Math.abs(cur - arr.get(i));
                if (abs < min) {
                    min = abs;
                }
            }
        }
        pre = cur;
        arr.add(pre);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
