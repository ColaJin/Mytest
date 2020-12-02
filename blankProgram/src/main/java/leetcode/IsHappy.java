package leetcode;

import java.util.*;

public class IsHappy {
    public static void main(String[] args) {
        int n = 13;
        boolean rs = isHappy(n);
        System.out.println(rs);
    }

//    static List list = new ArrayList();

    public static boolean isHappy(int n) {
        /*//条件n==1会无限循环的话就出现死循环啦
        //获取每一位的平方和
        int temp = square(n);
        //无限循环会产生相同的平方和，存储平方和，一旦存在返回false，否则返回true
        if (temp != 0) {
            if (list.contains(temp)) {
                return false;
            }
            if (temp == 1) {
                //最后返回true就行啦，不知道为啥又退出走到了list.contains(temp)，然后就返回false啦
                return true;
            }
            list.add(temp);
            return(isHappy(temp));
        }
        return false;*/
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = square(n);
        }
        return n == 1;

        /*//快慢指针方式
        int slow = n;
        int fast = square(n);
        while (fast != 1 && fast != slow){
            //对本身进行嵌套调用使用slow和fast而不是n(n始终不变)
            slow = square(slow);
            fast = square(square(fast));
        }
        return fast==1;

        //数学方法，Hash集合都是这些数字
        new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));*/
    }

    //获取每一位的平方和
    public static int square(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
