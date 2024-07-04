package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1380. 矩阵中的幸运数
 * @Date:2023/12/7
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,7,8},{9,11,13},{15,16,17}};
        List<Integer> rs = luckyNumbers(matrix);
        for (Integer r : rs) {
            System.out.println(r);
        }
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        // 查找每行中最小
        // 查找每列中最大
        // 取交集
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int tempMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (tempMin > matrix[i][j]){
                    tempMin = matrix[i][j];
                }
            }
            min.add(tempMin);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int tempMax = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if (tempMax < matrix[i][j]){
                    tempMax = matrix[i][j];
                }
            }
            max.add(tempMax);
        }
        min.retainAll(max);

        return min;
    }
}
