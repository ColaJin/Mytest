package leetcode.array.easy;

import org.springframework.util.CollectionUtils;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1030. 距离顺序排列矩阵单元格
 * @Date:2023/11/27
 */
public class AllCellsDistOrder {

    public static void main(String[] args) {
        allCellsDistOrder(1, 2, 0, 0);
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        System.out.println(Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter));

        // 曼哈顿距离：处理网格数据，计算结果都相同d=|x1-x2|+|y1-y2|
        int[][] rs = new int[cols * rows][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rs[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(rs, new Comparator<int[]>() {
            @Override
            public int compare(int[] x1, int[] x2) {
                return (Math.abs(x1[0] - rCenter) + Math.abs(x1[1] - cCenter)) - (Math.abs(x2[0] - rCenter) + Math.abs(x2[1] - cCenter));
            }
        });
        return rs;
    }

    public static int[][] allCellsDistOrderBucket(int rows, int cols, int rCenter, int cCenter) {
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        List<List<int[]>> bucket = new ArrayList<>();
        // <=个桶
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int d = dist(i, j, rCenter, cCenter);
                bucket.get(d).add(new int[]{i, j});
            }
        }

        // 曼哈顿距离：处理网格数据，计算结果都相同d=|x1-x2|+|y1-y2|
        int[][] rs = new int[cols * rows][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                rs[index++] = it;
            }
        }
        return rs;
    }

    public static int dist(int row, int col, int rCenter, int cCenter) {
        return Math.abs(row - rCenter) + Math.abs(col - cCenter);
    }
}
