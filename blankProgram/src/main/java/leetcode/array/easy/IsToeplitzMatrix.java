package leetcode.array.easy;

public class IsToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrixOnce(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        //遍历数组然后判断数组对角线位置是否相同
        //i+1,j+1;m<row n<col
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //从i和j开始
                int m = i;
                int n = j;
                //不需要循环可以省略直接判断matix[i-1][j-1]和matrix[i][j]是否相等就行
                while (m < row && n < col) {
                    if (matrix[i][j] != matrix[m][n]) {
                        return false;
                    } else {
                        m++;
                        n++;
                    }

                }
            }
        }
        return true;
    }

    public static boolean isToeplitzMatrixOnce(int[][] matrix) {
        //一次循环操作两个变量，每次比较对角线上的数字，注意从row-1到0和col-1到0都要执行一遍防止漏下对角线(中间对角线遍历两次)

        //遍历数组然后判断数组对角线位置是否相同
        int row = matrix.length;
        int col = matrix[0].length;
        while (col-- > 0) {
            //++不能放在循环内部否则数组越界，col和row变化，注意判断条件不能再使用row和col否则不进入循环
            for (int i = 0, j = col, val = matrix[i++][j++]; i < matrix.length && j < matrix[0].length; i++, j++) {
                if (matrix[i][j] != val) {
                    return false;
                }
            }
        }
        while (row-- > 0) {
            for (int i = row, j = 0, val = matrix[i++][j++]; i < matrix.length && j < matrix[0].length; i++, j++) {
                if (matrix[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    //进阶：如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，即最多一次for循环
    //如果矩阵太大，以至于一次只能将不完整的一行加载到内存中即for循环不能使用
}
