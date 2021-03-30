package leetcode.array.easy;

public class MatrixReshape {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        System.out.println(matrixReshapeByBounds(nums, 4, 1));
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }

        int[][] newArr = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            newArr[i / c][i % c] = nums[i / col][i % col];
        }
        //可以使用双重循环遍历nums然后当col==c时需要换行row++;col=0

        return newArr;
    }

    public static int[][] matrixReshapeByBounds(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        //不相等时不可以转换
        if (row * col != r * c) {
            return nums;
        }

        int[][] newArr = new int[r][c];
        //新数组的行列
        int nrow = 0;
        int ncol = 0;

        //遍历nums
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ncol == c) {
                    //超过列，更新行
                    nrow++;
                    ncol = 0;
                }
                newArr[nrow][ncol] = nums[i][j];
                //更新列
                ncol++;
            }
        }

        return newArr;
    }
}
