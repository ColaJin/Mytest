package leetcode.array.easy;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1560. 圆形赛道上经过次数最多的扇区
 * @Date:2023/12/13
 */
public class MostVisited {
    public static void main(String[] args) {
        int[] rounds = new int[]{1, 3, 1, 2};
        int n = 4;
        List<Integer> rs = mostVisited(n, rounds);
        for (int i = 0; i < rs.size(); i++) {
            System.out.println(rs.get(i));
        }
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        // 输入：n = 4, rounds = [1,3,1,2]
        // 输出：[1,2]
        List<Integer> rs = new ArrayList<>();
        // 只与起点和终点有关
        int len = rounds.length;
        int start = rounds[0];
        int end = rounds[len - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                rs.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                rs.add(i);
            }
            for (int i = start; i < n; i++) {
                rs.add(i);
            }
        }
        return rs;
    }
}
