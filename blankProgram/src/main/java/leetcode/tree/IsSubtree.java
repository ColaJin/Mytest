package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubtree {

    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(3);
        TreeNode tr2 = new TreeNode(4);
        TreeNode tr3 = new TreeNode(5);
        TreeNode tr4 = new TreeNode(1);
        TreeNode tr5 = new TreeNode(2);
        tr1.left = tr2;
        tr1.right = tr3;
        tr2.left = tr4;
        tr2.right = tr5;
        TreeNode s1 = new TreeNode(4);
        TreeNode s2 = new TreeNode(1);
        TreeNode s3 = new TreeNode(2);

        s1.left = s2;
        s1.right = s3;

        System.out.println(isSubtree(tr1, s1));
    }

    public static boolean isSubtreeWrong(TreeNode s, TreeNode t) {
        //先要找到结点所在的位置
        //然后找到结点及其子树，然后比较子树是否相同
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queueChi = new LinkedList<TreeNode>();
        boolean find = false;
        queue.add(s);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (find) {
                TreeNode children = queueChi.poll();
                if (temp.val != children.val) {
                    return false;
                } else {
                    if (children.left != null) {

                        queueChi.add(children.left);
                    }
                    if (children.right != null) {

                        queueChi.add(children.right);
                    }
                }

            } else {
                if (temp.val == t.val) {
                    //找到相同的结点此时要存入结点然后和t比较
                    find = true;
                    if (t.left != null) {

                        queueChi.add(t.left);
                    }
                    if (t.right != null) {

                        queueChi.add(t.right);
                    }
                    //需要清空queue
                    queue.clear();
                }
            }
            if (temp.left != null) {

                queue.add(temp.left);
            }
            if (temp.right != null) {

                queue.add(temp.right);
            }
        }

        if (!queueChi.isEmpty()) {
            return false;
        }

        return true;
    }

    //比较结点是否相同直接比较结点的值就可以，不需要把左右结点算进去
    public static boolean isSameNode(TreeNode t1, TreeNode t2) {
        /*if (t1.val == t2.val) {
            //左面子树相同的时候右子树也的相同
            if (t1.left == null && t2.left == null) {
                if (t1.right == null && t2.right == null) {
                    return true;
                } else if (t1.right != null && t2.right != null && t1.right.val == t2.right.val) {
                    return true;
                }
            } else if (t1.left != null && t2.left != null && t1.left.val == t2.left.val) {
                if (t1.right == null && t2.right == null) {
                    return true;
                } else if (t1.right != null && t2.right != null && t1.right.val == t2.right.val) {
                    return true;
                }
            }
        }*/
        return t1.val == t2.val;
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        //遍历树，找到结点，判断结点的树和目标树是否相同
        if (s == null){
            return false;
        }
        boolean temp = isSameTree(s,t);

        //遍历树，找到结点，不管是左右找到该子树就返回true
        boolean left = isSubtree(s.left,t);
        boolean right = isSubtree(s.right,t);

        return left || right || temp;
    }

    //比较两个数是否相同，完全相同
    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
            return false;
        }

        //相等的时候返回true&&之后还是true不需要加
        if (t1.val != t2.val) {
            return false;
        }

        boolean left = isSameTree(t1.left, t2.left);
        boolean right = isSameTree(t1.right, t2.right);

        return left && right;
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
