package leetcode.stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] rs = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < rs.length; i++) {
            System.out.print(rs[i] + "\t");
        }
    }

    public static int[] nextGreaterElementWrong(int[] nums1, int[] nums2) {
        //每次把数组2的数据放入到Stack中
        //遍历数组数组一
        //遇到栈顶元素和当前值相同时，放入数组-1
        //遇到栈顶元素和当前值不同，弹出栈顶元素，比较再次比较栈顶元素是否>当前值，此时把当前值放入数组
        //此时需要重新把nums2的数据放入到栈中，
        //遇到栈为空的时候，放入数组-1
        int[] rs = new int[nums1.length];
        int index = 0;
        Stack<Integer> myStack = new Stack<>();
        int stackIndex = 0;
        for (int i = 0; i < nums2.length; i++) {
            myStack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (myStack.peek() != nums1[i]) {
                //不对找不到首个大于的元素
                myStack.pop();
                stackIndex++;
                if (myStack.empty()) {
                    rs[index] = -1;
                } else {
                    while (!myStack.empty()) {
                        if (myStack.peek() > nums1[i]) {
                            myStack.pop();
                            stackIndex++;
                            rs[index] = nums1[i];
                            break;
                        }
                        if (myStack.peek() == nums1[i]) {
                            rs[index] = -1;
                            break;
                        }
                    }
                }
                /*while(stack.pop()!= nums1[i]) {
                    stackIndex++;
                    if (stack.empty()) {
                        rs[index] = -1;
                    } else {
                        if (stack.empty()) {
                            rs[index] = -1;
                        } else if (stack.peek() > nums1[i]) {
                            rs[index] = nums1[i];
                        }
                    }
                }*/

                myStack = getNums2Stack(myStack, nums2.length - stackIndex, nums2);
            } else {
                rs[index] = -1;
            }
            index++;
        }
        return rs;
    }

    //获取Nums2的栈，起始位置,nums2的长度
    public static Stack getNums2Stack(Stack stack, int start, int[] nums2) {
        for (int i = start; i < nums2.length; i++) {
            stack.add(nums2[i]);
        }
        return stack;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //栈存储nums2的数据，栈顶元素和插入的nums2的数据比较
        //如果栈顶元素大，nums2的数据直接压入栈，
        //如果插入的nums2的数据大于栈顶元素，一直弹出栈的元素，直到栈为空，此过程记录栈顶元素和插入的nums2的元素到Map中
        int[] rs = new int[nums1.length];
        Stack<Integer> myStack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while (!myStack.isEmpty() && myStack.peek() < i) {
                map.put(myStack.pop(), i);
            }
            myStack.push(i);
        }
        //不知道map的getOrdefault方法可以增加
        /*for (int i = 0; i < nums2.length; i++) {
            //重新遍历一次nums1看不存在的元素然后设置为-1
            if (!map.containsKey(nums2[i])) {
                map.put(nums2[i], -1);
            }
        }*/

        /*//或者直接判断栈中的数据，设置为-1
        while (!myStack.isEmpty()) {
            map.put(myStack.pop(), -1);
        }*/

        for (int i = 0; i < nums1.length; i++) {
            rs[i] = map.getOrDefault(nums1[i], -1);
            //rs[i] = map.get(nums1[i]);
        }

        return rs;
    }
}
