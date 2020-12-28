package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 10;
        int rs = countPrimesLine(n);
        System.out.println(rs);
    }

    //暴力超时
    public static int countPrimes(int n) {
        //质数因数只有1和他本身，从2开始一直计算到本身时都没有因数，那么就是质数，进行n次判断(小于n大于1的数都要算)
        //优化仍超时：一个合数分解质因数时，最大质因数不会大于它的平方根，所以循环从2到sqrt(n)即可。超时+1
        //2也是质数,从1开始
        /*int count = 1;
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
*/
        //count从0开始i从2开始
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }

        return count;
    }

    public static boolean isPrime(int n) {
        for (int j = 2; j * j <= n; ++j) {

            if (n % j == 0) {
                return false;
            }
            //此处不能直接+，需要判断是质数才+
                /*else {
                    count++;
                }*/
        }
        return true;
    }

    //埃氏筛,x是质数，大于x的x的倍数2x，3x，一定不是质数
    public static int countPrimesEgypt(int n) {
        int[] isPrims = new int[n];
        int count = 0;
        //初始化所有都为1
        Arrays.fill(isPrims, 1);
        for (int i = 2; i < n; i++) {

            if (isPrims[i] == 1) {
                //从2开始是质数
                count++;
                //从i*i开始计算，2x，3x
                if ((long) i * i < n) {

                    for (int j = i * i; j < n; j += i) {
                        //乘积会导致数组超出异常
                        isPrims[j] = 0;
                    }
                }
            }

        }
        return count;
    }

    //优化线性筛，在埃及筛基础上，删除重复标记的合数(15被3和5标记)
    //标记质数集合中的数与x相乘的数，直到满足最后一个质数停止
    //埃氏筛,x是质数，大于x的x的倍数2x，3x，一定不是质数
    public static int countPrimesLine(int n) {
        //判断是否是质数
        int[] isPrims = new int[n];
        //存储质数
        List<Integer> prim = new ArrayList();
        int count = 0;
        //初始化所有都为1
        Arrays.fill(isPrims, 1);
        for (int i = 2; i < n; i++) {
            if (isPrims[i] == 1) {
                count++;
                prim.add(i);
                //j<prim.size()不是n
                for (int j = 0; j < prim.size() && prim.get(j) * i < n; j++) {
                    //此处不是-1就是这个???
                    isPrims[prim.get(j) * i ] = 0;
                    if (prim.get(j) % i == 0) {
                        break;
                    }
                }
            }

        }
        return count;

    }
}
