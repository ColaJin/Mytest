package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1252. 奇数值单元格的数目
 * @Date:2023/11/29
 */
public class OddCells {
    public static void main(String[] args) {
        int m= 2;
        int n = 3;
        int[][] in = new int[][]{{0,1},{1,1}};
        int i = oddCells(m, n, in);
        System.out.println(i);
    }
    public static int oddCells(int m, int n, int[][] indices) {
        // m = 2, n = 3, indices = [[0,1],[0,1]]
        int[][] arr = new int[m][n];
        for (int[] index : indices) {
            int x = index[0];
            int y = index[1];
            for (int i = 0; i < n; i++) {
                arr[x][i]++;
            }
            for (int i = 0; i < m; i++) {
                arr[i][y]++;
            }
        }
        int rs = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt % 2 != 0){
                    rs++;
                }
            }
        }
        return rs;
    }
}
