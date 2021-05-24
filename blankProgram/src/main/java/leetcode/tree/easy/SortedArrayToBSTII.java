package leetcode.tree.easy;

public class SortedArrayToBSTII {
    public static void main(String[] args) {
        /*TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(-3);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(9);*/
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        // 奇数个数组和偶数个数组都取第nums.size()/2个位置
        // 每次取左侧和右侧的数字，作为子节点
//        return becomeTree(nums);
        return dfsBetter(nums, 0, nums.length - 1);
    }

    public static TreeNode becomeTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int[] numsLeft = new int[nums.length / 2];
        // 减掉中间的点
        int[] numsRight = new int[nums.length - nums.length / 2 - 1];
        TreeNode root = new TreeNode(nums[nums.length / 2]);

        System.arraycopy(nums, 0, numsLeft, 0, nums.length / 2);
        // 减掉中间的点
        System.arraycopy(nums, nums.length / 2 + 1, numsRight, 0, nums.length - nums.length / 2 - 1);
        root.left = becomeTree(numsLeft);
        root.right = becomeTree(numsRight);
        return root;
    }

    // 开始位置和结束位置作为参数递归


    public static TreeNode dfsBetter(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 条件不对，相等导致栈溢出
        /*if (start < end) {*/
        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        // mid - 1不是mid
        node.left = dfsBetter(nums, start, mid - 1);
        node.right = dfsBetter(nums, mid + 1, end);

        return node;
        /*}
        return null;*/

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
