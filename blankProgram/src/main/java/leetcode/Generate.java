package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        int numRows = 6;
        List<List<Integer>> rs = generate(numRows);
        System.out.println(rs);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();

        //第n行有n个数字
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < arr.length; i++) {
            List tempRs = new ArrayList();
            //由于只是给杨辉三角内的位置赋值，所以是j<=i
            for (int j = 0; j <= i; j++) {
                //根据规律，使用if else 赋值
                if (j == 0 || j == i) {
                    //每一行的开始和结尾数字都为1,用二维数组表示就是a[i][0]=1;  a[i][j]=1(当i==j时)；
                    arr[i][j] = 1;
                } else {
                    //第n+1行的第i个数字等于第n行的i-1个数字加上第n行的i个数字。
                    // a[i+1][j]=a[i][j-1]+a[i][j];
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                tempRs.add(arr[i][j]);
            }
            rs.add(tempRs);
        }
        return rs;
    }


}
