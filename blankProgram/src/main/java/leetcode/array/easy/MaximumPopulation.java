package leetcode.array.easy;

import org.python.modules.itertools.count;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1854. 人口最多的年份
 * @Date:2023/12/20
 */
public class MaximumPopulation {
    public static void main(String[] args) {
        // int[][] logs = new int[][]{{1993, 1999}, {2000, 2010}};
        int[][] logs = new int[][]{{1950,1961}, {1960,1971},{1970,1981}};
        System.out.println(maximumPopulation(logs));
    }

    public static int maximumPopulation(int[][] logs) {
        int rs = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int ageSub = logs[i][1] - logs[i][0];
            for (int k = 1; k <= ageSub; k++) {
                int age = logs[i][1] - k;
                map.put(age, map.getOrDefault(age, 0) + 1);
            }
            /*for (int j = i + 1; j < logs.length; j++) {
                if (logs[j][0] < logs[i][1]) {
                    // 出生小于死亡时,年龄差
                    int ageSub = logs[i][1] - logs[j][0];
                    for (int k = 1; k <= ageSub; k++) {
                        int age = logs[i][1] - k;
                        map.put(age, map.getOrDefault(age, 0) + 1);
                    }
                }
            }*/
        }
        // 不存在交集选择一个年份最小的
        int count = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            int age = temp.getKey();
            int tempCount = temp.getValue();
            if (tempCount > count) {
                rs = age;
                count = tempCount;
            }else if (tempCount == count){
                if (age < rs){
                    rs = age;
                }
            }
        }
        return rs;
    }
}
