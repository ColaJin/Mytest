package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1232. 缀点成线
 * @Date:2023/11/29
 */
public class CheckStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        /*int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};*/
        for (int i = 0; i < coordinates.length - 2; i++) {
            int[] v1 = {coordinates[i + 1][0] - coordinates[i][0], coordinates[i + 1][1] - coordinates[i][1]};
            int[] v2 = {coordinates[i + 2][0] - coordinates[i][0], coordinates[i + 2][1] - coordinates[i][1]};
            if (v1[0] * v2[1] - v1[1] * v2[0] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // [1,2],[2,3],[3,4],[4,5],[5,6],[6,7]
        int[][] arr = new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        boolean b = checkStraightLine(arr);
        System.out.println(b);
    }
}
