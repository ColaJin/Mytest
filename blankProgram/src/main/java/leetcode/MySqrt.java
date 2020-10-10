package leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去
 */
public class MySqrt {
    public static void main(String[] args) {
        int x = 10;
        /*int rs = mySqrt(x);
        System.out.println(rs);
        int rsDiv = mySqrtDivision(x);
        System.out.println(rsDiv);*/
        int rsTwo = mySqrtTwo(x);
        System.out.println(rsTwo);
    }

    /**
     * 首先想到的解决办法，但是大数相乘的乘积会导致结果出错
     */
    public static int mySqrt(int x) {
        int j = 1;
        int multiply = 1;
        if (x == 1) {
            return 1;
        }
        //等于的时候为平方数
        while (multiply <= x) {
            j++;
            multiply = j * j;
        }
        return j - 1;
    }

    /**
     * 选择做除法解决
     */
    public static int mySqrtDivision(int x) {
        int j = 1;
        int div = x;
        if (x == 1) {
            return 1;
        }
        //小于的时候进入循环>=情况退出返回j  10/1=10  10/2=5 10/3=3
        while (j <= div) {
            j++;
            div = x / j;
        }

        /*//20/5=4，此时j=5，但其实结果应该是4，所以返回j-1
        if (j != div) {
            return j-1;
        }*/
        //去掉判断返回j-1否则返回j
        return j - 1;
    }


    /**
     * 二分查找
     *
     * @param x
     * @return
     */
    public static int mySqrtTwo(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        //注意有等于的条件否则结果不正确
        while (left <= right) {
            int mid = left + (right - left) / 2;
            /*if (x / mid > mid) {
                ans = mid;
                left = mid + 1;
            } else if (x / mid == mid) {
                return mid;
            } else {
                right = mid - 1;
            }*/
            //可优化“
            if (x / mid >= mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
