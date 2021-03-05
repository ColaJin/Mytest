package leetcode.Array.easy;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibByIterator(n));
    }

    public static int fib(int n) {

        if (n == 0) {
            //根据题情况，可能从0开始可能从1开始
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        //以上可以简化成if(n<2){return n;}
        return fib(n - 1) + fib(n - 2);
    }

    //递归容易造成超时，需要优化，可以存储结果到map中，然后判断是否计算过，直接返回不需要重复计算
    public static int fibByMap(int n, Map<Integer, Integer> map) {
        if (n < 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        //使用递归
        int first = fibByMap(n - 1, map);
        int second = fibByMap(n - 2, map);
        int result = first + second;
        map.put(n, result);

        return result;

    }


    //非递归，即迭代的方式优化
    public static int fibByIterator(int n) {
        /*if (n < 2) {
            return n;
        }*/
        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {//可以使用while(n-->0)
            //从0开始，先计算和，再赋值first和second
            int temp = first + second;
            first = second;
            second = temp;
        }

        return first;

    }
}
