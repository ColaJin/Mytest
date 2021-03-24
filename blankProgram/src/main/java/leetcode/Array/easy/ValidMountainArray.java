package leetcode.Array.easy;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2};
        System.out.println(validMountainArrayByTwoPointAnother(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        //判断i和i+1位置是否是i<i+1
        //存在三种情况不满足条件
        //第一种是i=i+1位的值时
        //第二种是i一直小于i+1位置的值
        //第三种是i小于i+1,i+2<i+1,i+3>i+2就是多峰的情况
        //第四种是i一直大于i+1的位置

        //什么时候满足条件？
        //i<i+1位置的值
        //增的标志 false
        //减的标志 false
        //同时存在满足条件 true && true
        boolean inc = false;
        boolean dec = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            if (arr[i] > arr[i + 1]) {
                dec = true;
            }
            if (arr[i] < arr[i + 1]) {
                if (dec) {
                    //减完了之后不能再次增，否则返回false
                    return false;
                }
                inc = true;
            }
            //增减增减的情况也是不满足条件的
        }
        return inc && dec;
    }


    public static boolean validMountainArrayByTraverse(int[] arr) {
        //线性遍历，从左向右遍历数组，如果a[i]<a[i+1]时i++，找到最大值的时候i的位置
        //判断最大值位置是不是0(递减开始)或者N-1(一直递增)
        //继续遍历数组，判断a[i]>a[i+1]，i++如果一直递减那么返回i的值为最后一位，如果继续增那么返回的位置就不是最后一位
        int i = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] < arr[j + 1]) {
                i++;
            } else {
                break;
            }
        }
        if (i == 0 || (i == arr.length - 1)) {
            return false;
        }
        for (int j = i; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                i++;
            } else {
                break;
            }
        }
        return i == arr.length - 1;
    }


    public static boolean validMountainArrayByTwoPointAnother(int[] arr) {
        //判断从左遍历到山峰和从右遍历到山峰的位置是否相同
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                left++;
            }else {
                //不满足时结束遍历
                break;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                right--;
            }else {
                //不满足时结束遍历
                break;
            }
        }
        if (left == 0 || left == arr.length - 1 || left != right) {
            return false;
        }
        return true;
    }
}
