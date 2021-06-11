package leetcode.hash;

import java.util.*;

public class GetImportance {
    public static void main(String[] args) {
        Employee e3 = new Employee(3, 3, null);
        Employee e2 = new Employee(2, 3, null);
        List<Integer> sub = new ArrayList<>();
        sub.add(e3.id);
        sub.add(e2.id);
        Employee e1 = new Employee(1, 5, sub);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(getImportanceDFS(employees, 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        // 遍历数组，找到目标员工的直接下属，记录当前的度
        // 遍历数组，找到直系下属的度
        int degree = 0;
        Queue<Integer> sub = new LinkedList<>();
        for (Employee e : employees) {
            if (e.id == id) {
                degree += e.importance;
                for (int i : e.subordinates) {
                    sub.offer(i);
                }
                break;
            }
        }

        /*for (Employee e : employees) {
            while (!sub.isEmpty()) {
                // 不可以直接poll，导致数量变少，比较peek()又会导致死循环
                if (e.id == sub.poll()) {
                    degree += e.importance;
                    for (int i : e.subordinates) {
                        sub.offer(i);
                    }
                }
            }
        }*/

        // 可以优化成map存储employee信息

        while (!sub.isEmpty()) {
            for (Employee e : employees) {

                if (e.id == sub.peek()) {
                    sub.poll();
                    degree += e.importance;
                    if (e.subordinates != null) {
                        for (int i : e.subordinates) {
                            // 数组为空不能这样遍历
                            sub.offer(i);
                        }
                    }
                    if (sub.isEmpty()) {
                        break;
                    }
                }
            }
        }

        return degree;
    }

    public static int getImportanceBetter(List<Employee> employees, int id) {
        int degree = 0;
        Queue<Integer> sub = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        // 此处可以不操作找员工，队列中放入id开始找
        for (Employee e : employees) {
            // 放入到map中
            map.put(e.id, e);
            if (e.id == id) {
                // 找到当前的员工
                degree += e.importance;
                for (int i : e.subordinates) {
                    // 把下属放到队列
                    sub.offer(i);
                }
            }
        }


        // 可以优化成map存储employee信息
        while (!sub.isEmpty()) {
            // 队首的元素的员工id
            Integer tempId = sub.poll();
            if (map.containsKey(tempId)) {
                Employee tempEmp = map.get(tempId);
                degree += tempEmp.importance;
                for (int i : tempEmp.subordinates) {
                    // 把下属放到队列
                    sub.offer(i);
                }
            }
        }

        return degree;
    }

    // map存储id和Employee,深度优先遍历返回total
    static Map<Integer, Employee> map = new HashMap<>();

    public static int getImportanceDFS(List<Employee> employees, int id) {
        for (Employee e : employees) {
            // 放入到map中
            map.put(e.id, e);
        }

        return dfs(id, 0);
    }

    // 可优化的是degree不需要作为参数传递，每次局部变量创建即可
    private static int dfs(int id, int degree) {
        if (!map.containsKey(id)) {
            return 0;
        }
        Employee employee = map.get(id);
        degree += employee.importance;
        if (employee.subordinates != null) {
            for (int i : employee.subordinates) {
                // +=
                degree = dfs(i, degree);
            }
        }
        return degree;
    }


    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
