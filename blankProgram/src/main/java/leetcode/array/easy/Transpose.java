package leetcode.array.easy;

public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6}};
        int[][] rs = transpose(matrix);
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[0].length; j++) {
                System.out.print(rs[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        //创建一个col行row列的二维数组，然后判断横纵是否相同不相同时转换横纵数据到新数组
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] newMatrix = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //不需要增加判断直接转换就行，即使相等的时候转换也不会出现问题
                if (i==j){
                    newMatrix[i][j] = matrix[i][j];
                }else {
                    newMatrix[j][i] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }
}
