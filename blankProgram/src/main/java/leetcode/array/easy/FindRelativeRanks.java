package leetcode.array.easy;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author:jinyandong
 * @description:506. 相对名次；官方题解？
 * @Date:2023/8/29
 */
public class FindRelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        String[] rs = new String[score.length];
        int[] scoreCopy = new int[score.length];
        System.arraycopy(score,0,scoreCopy,0,score.length);
        // 不存在基本类型数组的降序排列
        Arrays.sort(scoreCopy);

        /*int[] scoreCopy = new int[score.length];
        System.arraycopy(score,0,scoreCopy,0,score.length);
        Arrays.sort(scoreCopy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });*/
        // 不可使用，应该用Integer
        /*Arrays.sort(score,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Arrays.sort(score,Collections.reverseOrder());*/
        Object[] objects = IntStream.of(score)    //创建IntStream
                // 去掉boxed报错
                .boxed()
                .sorted(Comparator.reverseOrder()) //倒序排序
                //.peek(System.out::println)    //打印结果
                //.mapToInt(e -> (int)e)
                .toArray();
        // 记录最大值对应的结果
        Map<Integer, String> scRan = new HashMap<>();
        for (int i = 0; i < objects.length; i++) {
            if (i == 0) {
                scRan.put((Integer) objects[i], "Gold Medal");
            } else if (i == 1) {
                scRan.put((Integer) objects[i], "Silver Medal");
            } else if (i == 2) {
                scRan.put((Integer) objects[i], "Bronze Medal");
            } else {
                scRan.put((Integer) objects[i], String.valueOf(i + 1));
            }
        }
        for (int i = 0; i < score.length; i++) {
            rs[i] = scRan.get(score[i]);
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] score = new int[]{5, 4, 3, 2, 1};
        // int[] score = new int[]{10,3,8,9,4};
        String[] rs = findRelativeRanks(score);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
