package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class FindJudge {
    public static void main(String[] args) {
        System.out.println(findJudgeByGraphy(3, new int[][]{{1, 3}, {2, 3}}));
    }

    public static int findJudge(int n, int[][] trust) {
        // 1-N之中不存在的键值则是法官？存在问题1,2 2,3这个时候不存在，3也是不存在在键值中
        // 值中需要唯一？但是其实指向相同也可以，1,4  4,3

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {

            int people = trust[i][0];
            int jail = trust[i][1];
            // 放入map
            map.put(people, jail);
        }
        int only = trust[0][1];
        int onlyPeople = trust[0][0];
        for (int i = 1; i < trust.length; i++) {
            // 开始判断
            if (map.containsKey(trust[i][0])) {
                if (trust[i][1] != only) {
                    Integer temp = map.get(trust[i][0]);
                    if (map.containsKey(temp)) {
                        // 判断是否·和only相同
                    } else {
                        return -1;
                    }
                }
            }
        }
        boolean flag = false;
        // 增加判断是否互相信任的
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                flag = true;
            }
        }


        return flag ? -1 : only;
    }

    public static int findJudgeRight(int n, int[][] trust) {

        if (n == 1 && trust.length == 0) {
            // 特殊情况
            return 1;
        }

        // 存储人员和被信任的人数
        Map<Integer, Integer> mapCount = new HashMap<>();
        // 存储人员信任关系
        Map<Integer, Integer> mapRelation = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {

            int people = trust[i][0];
            int jail = trust[i][1];
            // 放入map
            mapCount.put(jail, mapCount.getOrDefault(jail, 0) + 1);
            mapRelation.put(people, jail);
        }

        for (int i : mapCount.keySet()) {
            // n - 1个人信任i
            if (mapCount.get(i) == n - 1) {
                //可能是法官
                if (mapRelation.containsKey(i)) {
                    // 存在信任关系不是法官
                    continue;
                } else {
                    return i;
                }
            }
        }

        return -1;
    }

    // 使用图方式记录入度和出度，入度为N的且出度为0的即为想要的结果
    public static int findJudgeByGraphy(int n, int[][] trust) {
        int[][] degree = new int[n][2];

        for (int i = 0; i < trust.length; i++) {
            degree[trust[i][0] - 1][0]++;
            degree[trust[i][1] - 1][1]++;
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i][0] == 0 && degree[i][1] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }

}
