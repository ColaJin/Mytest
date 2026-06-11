package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:LCR 146.螺旋遍历二维数组
 * @Date:2024/8/12
 */
public class SpiralArray {
    public static void main(String[] args) {

    }

    public int[] spiralArray(int[][] array) {
        int row = array.length;
        int col = array[0].length;

        int[] res = new int[row * col];
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        int index = 0;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                res[index] = array[top][column];
                index++;
            }
            for (int tempRow = top + 1; tempRow <= bottom; tempRow++) {
                res[index] = array[tempRow][right];
                index++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res[index] = array[bottom][column];
                    index++;
                }
                for (int tempRow = bottom; tempRow > top; tempRow--) {
                    res[index] = array[tempRow][left];
                    index++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        /*res[0] = array[0][0];
        array[0][0] = -1;
        int i = 0;
        int j = 1;
        int index = 1;
        while (array[i][j] != -1) {
            while (i < row && array[i][j] != -1) {
                res[index] = array[i][j];
                i++;
                array[i][j] = -1;
                index++;
            }
            while (j < col && array[i][j] != -1) {
                res[index] = array[i][j];
                j++;
                array[i][j] = -1;
                index++;
            }
            while (i > 0 && array[i][j] != -1) {
                res[index] = array[i][j];
                i--;
                array[i][j] = -1;
                index++;
            }
            while (j > 0 && array[i][j] != -1) {
                res[index] = array[i][j];
                j--;
                array[i][j] = -1;
                index++;
            }
        }*/
        return res;
    }

}
