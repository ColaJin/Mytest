package leetcode.tree.easy;

import javax.xml.soap.Node;
import java.util.*;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class IsSymmetric {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);

        TreeNode ll1 = new TreeNode(2);
        TreeNode rl1 = new TreeNode(2);

        root.left = l1;
        root.right = r1;

        l1.left = ll1;
        r1.left = rl1;

        boolean symmetric = isSymmetricDigui(root, root);
        System.out.println(symmetric);

    }

    public static boolean isSymmetric(TreeNode root) {
        //广度遍历，存储数据变成满二叉树，即空的子树用null存储

        //从第一个位置的数组进行比较每次比较2的0次，1次...数据是否是回文数列


        //递归？？？？
        //判断根结点的的左右子孩子，有的话

        //迭代？？？？？

        if (root == null) {
            System.out.print("empty tree");
            return true;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode rnode = deque.remove();
            System.out.print(rnode.val + "  ");
            if (rnode.left != null) {
                deque.add(rnode.left);
            }
            if (rnode.right != null) {
                deque.add(rnode.right);
            }
            //存在这种情况就是该根节点存在一个子树、而且只有一个兄弟子树时，队列中剩下的元素是两个，此时是兄弟子树和子树比较
            if (deque.size() % 2 == 0) {
                //队列中元素是2的次数幂时判断是否是回文数字
                //deque在方法中会清空???怎么办
                /*ArrayDeque<TreeNode> oldDeque = deque;*/
                boolean isPalindrome = IsPalindrome(deque);
                if (!isPalindrome) {
                    return false;
                } else {
                    //广度遍历的队列变成null啦，需要重新放进去队列，继续下一层的遍历
                    if (rnode.left != null) {
                        deque.add(rnode.left);
                    }
                    if (rnode.right != null) {
                        deque.add(rnode.right);
                    }
                }
            }
        }


        return true;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //遍历队列方法
    static boolean IsPalindrome(ArrayDeque<TreeNode> deque) {
        //根据栈和队列判断是否是回文，存储后依次弹出，相等则是回文，否则不是回文
        int i = 0;
        /*//这种设置方法old也会随着队列变空变空
        ArrayDeque<TreeNode> olddeque =  deque;*/
        ArrayDeque<TreeNode> olddeque = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack();
        while (!deque.isEmpty()) {
            //移除元素啦
            TreeNode rnode = deque.remove();
            stack.push(rnode);
            olddeque.add(rnode);
            i++;
        }

        for (i = i; i > 0; i--) {
            TreeNode s = stack.pop();
            TreeNode q = olddeque.pop();
            if (s.val != q.val) {
                return false;
            }
        }
        //赋值的方法不对，返回的队列还是null
        /*deque = copydeque;*/
        return true;
    }

    public static boolean isSymmetricArray(TreeNode root) {
        // 借用102题层序遍历的代码，取出二叉树的各层list，分别看是否左右对称，只要有一个不对称就返回false
        // 对于null子节点（末端），设置为Integer的最大值，便于识别null
        List<List<Integer>> listSet = new ArrayList<>();
        listSet = levelOrder(root);
        for (List<Integer> list : listSet) {
            int size = list.size();
            if (size > 1) {
                for (int i = 0; i <= size / 2; i++) {
                    if (list.get(i) != list.get(size - 1 - i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 借用102题层序遍历的代码，取出二叉树的各层list
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();   // que队列用于按顺序存入各node，并弹出，弹出的node添加到本层的list level中
        if (root != null) {   // 如果根节点不为空，就给到que
            que.offer(root);
        }

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> level = new LinkedList<Integer>();  // 本层各node的list，每层一个level
            for (int i = 0; i < n; i++) {  // 处理某一层的node
                TreeNode current = que.peek();  // 队列第一个元素
                que.poll(); // 队列第一个元素出队列
                if (current == null) {  // 在第一个元素出队之前，current就已经是空队列的话，继续下一循环
                    level.add(127);   // 对于null子节点（末端），设置为Integer的最大值，便于识别null
                    continue;
                }
                level.add(current.val);  // 弹出的node添加到本层的list level中
                que.offer(current.left);
                que.offer(current.right);
            }
            if (!level.isEmpty()) {   // 如果本层存在node，把这一层的list加入到res这个总list中。
                res.add(level);
            }
        }
        return res;
    }


    public static boolean isSymmetricDigui(TreeNode t1, TreeNode t2) {
        //递归
        /**
         * 判断两个指针当前节点值是否相等
         * 判断 A 的右子树与 B 的左子树是否对称
         * 判断 A 的左子树与 B 的右子树是否对称
         */
        //都为null的情况
        if (t1 == null && t2 == null) {
            return true;
        }
        //其中有一个不为null的情况
        if (t1 == null || t2 == null) {
            return false;
        }
        //使用短路&&
        /**
         * a&b  9&8
         * 1001
         * 1000
         *
         * 结果是1000
         * a&&b  9&&8 结果是1
         *
         * &对每一个都判断；
         * &&只要前面是false就输出false，而不继续判断后面了
         */
        return (t1 == t2) && isSymmetricDigui(t1.right, t2.left) && isSymmetricDigui(t1.left, t2.right);

    }

    //迭代
    public static boolean isSymmetricDiedai(TreeNode t1, TreeNode t2) {

        //把根节点放进队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            //更新t1和t2为根节点
            t1 = queue.poll();
            t2 = queue.poll();
            if (t2 == null && t1 == null) {
                continue;
            }
            /**
             * u不空，v空
             * v不空 u空
             * u和v值不相等
             */
            if (t2 == null || t1 == null || (t2.val != t1.val)) {
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }


}
