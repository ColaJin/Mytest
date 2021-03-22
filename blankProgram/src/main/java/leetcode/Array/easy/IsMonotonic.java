package leetcode.Array.easy;

public class IsMonotonic {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,2};
        System.out.println(isMonotonicOneValue(A));
    }

    public static boolean isMonotonicWrong(int[] A) {
        //维持一个大小为3的窗口，然后比较当前元素和后一个元素、前一个元素之间的大小关系错误
        // 前面确定了增那么后面一定是增，前面确定了是减，一定就是减
        //首尾开始从1开始到A.length-2结束
        //需要判断2位和1位的长度数组
        //当数组确定是增还是减的时候记录一个temp值，用来确定数组的最大或者最小值，每次遍历时更新该值
        int tempMax = Integer.MIN_VALUE;
        int tempMin = Integer.MAX_VALUE;
        if (A.length == 1 || A.length == 2) {
            return true;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                //增减
                return false;
            } else if (A[i] < A[i - 1] && A[i] < A[i + 1]) {
                //减增
                return false;
            } else if (A[i - 1] < A[i] && A[i] < A[i + 1]) {
                //增增
                if (tempMax <= A[i]) {
                    tempMax = A[i];
                } else {
                    //比递增的最小值还小那就是变小啦
                    return false;
                }
            } else if (A[i - 1] > A[i] && A[i] > A[i + 1]) {
                //减减
                if (tempMin >= A[i]) {
                    tempMin = A[i];
                } else {
                    //比递减的最大值还大那就是变大啦
                    return false;
                }
            }
        }
        return true;
    }

    //遍历一次，假设都是递增或者递减，遇到递减的时候递增设置为false，遇到递增的时候递减设置为false
    public static boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.length - 1; i++) {
            //刚开始为true,不满足条件是设置为false然后break循环，否则这个值还好发生变化
            if (A[i] > A[i + 1]) {
                inc = false;
                break;
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {

                dec = false;
                break;
            }
        }
        //要么递增，要么递减，不会出现前面都递增啦，后面还递减的情况、、、、、
        return inc || dec;
    }

    //遍历一次，找个变量记录是否是递增或者递减
    public static boolean isMonotonicOneValue(int[] A) {
        int change = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                if (change == -1 || change == 0) {
                    change = 0;
                } else {
                    return false;
                }
            }
            if (A[i] < A[i + 1]) {
                if (change == -1 || change == 1) {
                    change = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
