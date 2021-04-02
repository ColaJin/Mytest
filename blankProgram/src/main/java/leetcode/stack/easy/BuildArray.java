package leetcode.stack.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BuildArray {
    public static void main(String[] args) {
        int[] target = new int[]{2,3,4};
        int n = 4;
        List<String> rs = buildArrayDirectly(target, n);
        for (String s : rs) {
            System.out.println(s);
        }
    }

    public static List<String> buildArrayWrong(int[] target, int n) {
        //把从1到n的数字放入栈中
        //从后向前遍历target，如果找到栈顶元素和数组当前元素相同1的值开始存储
        //栈为空时，从此位置向前的数组元素都没有都是需要push、pop的
        Stack<Integer> stack = new Stack<>();
        List<String> rs = new ArrayList();

        for (int i = 1; i <= n; i++) {
            //存放到栈中
            stack.push(i);
        }

        //记录开始计算push和pop的标志位
        boolean flag = false;
        for (int i = target.length - 1; i >= 0; ) {
            if (stack.empty() && i >= 0) {
                rs.add("Push");
                rs.add("Pop");
                i--;
            } else {
                if (!flag) {
                    while (!stack.empty() && stack.peek() != target[i]) {
                        //找到最后一个元素相同的
                        stack.pop();

                    }
                    flag = true;
                    rs.add("Push");
                    //更新栈元素
                    stack.pop();
                    i--;
                } else {
                    if (!stack.empty() && stack.peek() != target[i]) {
                        rs.add("Push");
                        rs.add("Pop");
                        //此时i不能--
                    } else {
                        if (!stack.empty() && i == 0) {
                            rs.add("Push");
                            rs.add("Pop");
                        } else {
                            rs.add("Push");
                            i--;
                        }

                    }
                    stack.pop();
                }
            }
        }
        Collections.reverse(rs);
        return rs;
    }

    public static List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> rs = new ArrayList();

        for (int i = 1; i <= n; i++) {
            //存放到栈中
            //可以优化循环的n为target最后一位，取消下面循环的while
            stack.push(i);
        }

        boolean flag = false;
        for (int i = target.length - 1; i >= 0; ) {
            while (!flag && !stack.empty() && stack.peek() != target[i]) {
                //找到最后一个元素相同的
                stack.pop();
            }

            if (stack.peek() == target[i]) {
                flag = true;
                rs.add("Push");
                stack.pop();
                i--;
            } else {
                rs.add("Pop");
                rs.add("Push");
                //此时i不--
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            rs.add("Pop");
            rs.add("Push");
            stack.pop();
        }
        Collections.reverse(rs);
        return rs;
    }

    public static List<String> buildArrayByStackBetter(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> rs = new ArrayList();
        //把元素i push到栈中，如果栈顶的元素和数组的元素相同，Push操作加入结果集,数组元素后移
        //不相同的时候，Push和Pop加入结果集，继续把元素i push到栈中
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            //先push
            stack.push(i);
            //index才是target的索引
            if (target[index] == stack.peek()) {
                rs.add("Push");
                if (index == target.length - 1) {
                    //数组遍历结束
                    break;
                } else {
                    //数组索引++
                    index++;
                }
            } else {
                rs.add("Push");
                rs.add("Pop");
            }
        }
        return rs;
    }

    public static List<String> buildArrayDirectly(int[] target, int n) {
        List<String> rs = new ArrayList();
        //直接比较
        //n=1时
        if (n == 1) {
            if (target.length == 0) {
                rs.add("Push");
                rs.add("Pop");
            } else {
                rs.add("Push");
            }
        } else {
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (target[index] == i) {
                    rs.add("Push");
                    if (index == target.length - 1) {
                        //数组遍历结束
                        break;
                    } else {
                        //数组索引++
                        index++;
                    }
                } else {
                    rs.add("Push");
                    rs.add("Pop");
                }
            }
        }
        return rs;
    }
}
