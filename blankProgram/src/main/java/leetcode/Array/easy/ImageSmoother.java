package leetcode.Array.easy;

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 1, 6}, {1, 0, 5, 1}, {1, 1, 3, 1}};
        //不能输出二维数组
        Arrays.toString(M);
//        System.out.println(M[0][0]);
        int[][] rs = imageSmootherViolenceBetter(M);
//        System.out.println(rs[0][0]);
//        System.out.println(rs[0][2]);
//        System.out.println(rs[2][0]);
//        System.out.println(rs[2][2]);
        for (int[] ints : rs) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmootherWrong(int[][] M) {
        //数组的长度小于3的时候


        int row = M.length;
        int col = M[0].length;
        int[][] newArr = new int[row][col];
        //1行的所有情况，1列的所有情况还有2列的所有情况，两行的所有情况分不清
        if (row <= 2 && col <= 2) {
            int sum = 0;
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    sum += M[i][j];
                }
            }
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    newArr[i][j] = sum / (row * col);
                }
            }

        } else {
            //就是每遍历到一个点A，就将周围8个点（只计算有效点）加上点A，最后求一个平均值
            //四个角落/4加上四条边/6的判断
            //第一种情况的角[0,0]
            //第一种情况的角[0,col-1]
            //第一种情况的角[row-1,0]
            //第一种情况的角[row-1,col-1]

            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    if (i == 0 && j == 0) {
                        newArr[i][j] = (M[i + 1][j] + M[i + 1][j + 1] + M[i][j + 1] + M[i][j]) / 4;
                    } else if (i == 0 && j == col - 1) {
                        newArr[i][j] = (M[i][j - 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i][j]) / 4;
                    } else if (i == row - 1 && j == col - 1) {
                        newArr[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i][j - 1] + M[i][j]) / 4;
                    } else if (i == row - 1 && j == 0) {
                        newArr[i][j] = (M[i - 1][j] + M[i - 1][j + 1] + M[i][j + 1] + M[i][j]) / 4;
                    } else if (i == 0) {
                        newArr[i][j] = (M[i][j - 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j + 1] + M[i][j + 1] + M[i][j]) / 6;
                    } else if (j == 0) {
                        newArr[i][j] = (M[i - 1][j] + M[i + 1][j] + M[i + 1][j + 1] + M[i][j + 1] + M[i - 1][j + 1] + M[i][j]) / 6;
                    } else if (j == col - 1) {
                        newArr[i][j] = (M[i - 1][j] + M[i - 1][j - 1] + M[i][j - 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i][j]) / 6;
                    } else if (i == row - 1) {
                        newArr[i][j] = (M[i - 1][j - 1] + M[i][j - 1] + M[i][j + 1] + M[i - 1][j + 1] + M[i - 1][j] + M[i][j]) / 6;

                    } else {
                        newArr[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j - 1] + +M[i][j + 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j + 1] + M[i][j]) / 9;
                    }

                }
            }

            //第二种情况的边[0,x]
            //第二种情况的边[x,0]
            //第二种情况的边[row-1,x]
            //第二种情况的边[col-1,x]

            //第三种情况其他的/9

        }

        return newArr;
    }

    //暴力法
    public static int[][] imageSmootherViolence(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] arr = new int[row][col];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int sum = M[i][j];
                int count = 1;
                if (i > 0) {
                    //有上
                    sum += M[i - 1][j];
                    count++;
                    if (j > 0) {
                        //有左上
                        sum += M[i - 1][j - 1];
                        count++;
                    }
                    if (j < col - 1) {
                        //有右上
                        sum += M[i - 1][j + 1];
                        count++;
                    }
                }

                if (i < row - 1) {
                    //有下
                    sum += M[i + 1][j];
                    count++;
                    if (j > 0) {
                        //有左下
                        sum += M[i + 1][j - 1];
                        count++;
                    }
                    if (j < col - 1) {
                        //有右下
                        sum += M[i + 1][j + 1];
                        count++;
                    }
                }

                if (j > 0) {
                    //有左
                    sum += M[i][j - 1];
                    count++;
                }
                if (j < col - 1) {
                    //有右
                    sum += M[i][j + 1];
                    count++;
                }
                arr[i][j] = sum / count;
            }
        }
        return arr;
    }

    //查看相邻元素及个数(r-1，c+1)，计算总和之后/=个数

    public static int[][] imageSmootherViolenceBetter(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int nr = i - 1; nr <= i + 1; nr++) {
                    for (int nc = j - 1; nc <= j + 1; nc++) {
                        //-1的时候不算,判断的不是i，j而是nr和nc,注意=号的时候是满足条件的
                        if (nr >= 0 && nr <= row - 1 && nc >= 0 && nc <= col - 1) {
                            count++;
                            //i和j不变
                            arr[i][j] += M[nr][nc];
                        }
                    }
                }
                //arr[i][j]已经为所有相邻的和
                arr[i][j] /= count;
            }
        }
        return arr;
    }
}
