package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:jinyandong
 * @description:1700. 无法吃午餐的学生数量
 * @Date:2023/12/18
 */
public class CountStudents {
    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 0, 0};
        int[] sandwiches = new int[]{0, 1, 0, 1};
        int rs = countStudents(students, sandwiches);
        System.out.println(rs);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int rs = 0;
        /*Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        for (int i = students.length - 1; i >= 0; i--) {
            temp1.push(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            temp2.push(sandwiches[i]);
        }
        for (Integer temp : temp2) {
            if (temp1.peek() == temp){
                temp1.pop();
                temp2.pop();
            }else {
                Integer pop = temp1.pop();
                temp1.push(pop);
            }
        }*/

        return rs;
    }
}
