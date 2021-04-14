package leetcode.tree;

import java.util.*;

public class FindMode {
    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(1);
        TreeNode tr2 = new TreeNode(2);
        /*TreeNode tr3 = new TreeNode(2);
        TreeNode tr4 = new TreeNode(1);*/
        tr1.right = tr2;
        /*tr1.left = tr4;
        tr2.left = tr3;*/
        int[] mode = findMode(tr1);
        for (int count : mode) {
            System.out.println(count);
        }
    }

    public static int[] findModeWorng(TreeNode root) {
        //存储结点和其相同结点个数
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            //判断map中是否存在该结点
            TreeNode temp = queue.poll();
            if (!map.containsKey(temp.val)) {
                //需要计算当前结点的众数
                map.put(temp.val, valueCount(temp));
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }

        if (map.size() == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        //找map中最大的值元素
        for (Integer key : map.keySet()) {
            if (map.get(key) >= max) {
                max = map.get(key);
            }
        }
        //找map中最大的值元素
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                count++;
            }
        }

        //声明大小不应该是map的大小
        int[] rs = new int[count];
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                rs[index] = key;
                index++;
            }
        }

        /*for (int i = 0; i < map.size(); i++) {
            //map不是从0开始的
            rs[i] = map.get(i);
        }*/

        return rs;
    }

    //计算众数的个数,只能局限结点左右孩子
    public static int valueCount(TreeNode root) {
        //当前结点算一个
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    if (node.val == node.left.val) {
                        count++;
                        //没有算隔代

                    }
                    queue.add(node.left);

                }
                if (node.right != null) {
                    if (node.val == node.right.val) {
                        count++;
                    }
                    queue.add(node.right);

                }
            }
        }
        return count;
    }

    //需要记录前一个元素、前一个元素的个数、最大元素、元素和个数的数组
    private static ArrayList<Integer> maxArrays = new ArrayList<>();
    //不能用static否则0为root出错
    static int pre = 0;
    static int count = 0;
    static int maxCount = Integer.MIN_VALUE;


    public static int[] findMode(TreeNode root) {
        //中序遍历二叉搜索树，会产生从小到大排序的数据，然后遍历数据的个数存储在数组中

        dfs(root);

        int[] rs = new int[maxArrays.size()];

        for (int i = 0; i < maxArrays.size(); i++) {
            rs[i] = maxArrays.get(i);
        }
        return rs;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        //操作结点
        update(root.val);
        dfs(root.right);
    }

    public static void update(int cur) {
        if (cur != pre) {
            //前后不一致时，
            count = 1;
            pre = cur;
        } else {

            count++;
        }
        //都要更新最大值和数组、
        if (count > maxCount) {
            //大于最大值时
            maxCount = count;
            //清空数组
            maxArrays.clear();
            //
            maxArrays.add(cur);
        } else if (count == maxCount) {
            //等于最大值时
            maxArrays.add(cur);
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