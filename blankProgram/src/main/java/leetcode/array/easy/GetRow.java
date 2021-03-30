package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class GetRow {
    public static void main(String[] args) {
        int rowIndex = 5;
        List<Integer> rs = getRow(rowIndex);
        System.out.println(rs);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> rs = new ArrayList<>();
        //第n+1行有n+1个数字,要使用n+1，可查看题目描述
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i < arr.length; i++) {
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
                if (i == arr.length - 1) {

                    rs.add(arr[i][j]);
                }
            }
        }
        return rs;
    }
}
