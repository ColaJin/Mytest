package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:1037. 有效的回旋镖
 * @Date:2023/11/27
 */
public class IsBoomerang {
    public static void main(String[] args) {

    }

    public boolean isBoomerang(int[][] points) {
        // [[1,1],[2,3],[3,2]] [[1,1],[2,2],[3,3]]
        // 三点共线：A、B、C |AC|=|AB|+|BC| C在AB延长线  |AC|=||AB|-|BC|| C在AB上 / C在BA延长线上
        // 向量叉乘为0，a向量与b向量的向量积为a向量大小*b向量大小*sin角度，共线时sin0和sin180都是0
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
