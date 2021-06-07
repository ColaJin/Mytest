package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static void main(String[] args) {
        int[] candyType = new int[]{6, 6, 6, 6};
        System.out.println(distributeCandies(candyType));
    }

    public static int distributeCandies(int[] candyType) {
        // 看糖果种类和平均分的个数，如果说平均分的个数  < 种类,/ + %
        int every = candyType.length / 2;

        int[] temp = new int[candyType.length];

        // 数据下标越界因为temp[6]不存在  {6,6,6,6}
        /*for(int i : candyType) {
            temp[i]++;
        }*/

        int index = 0;
        for (int i : temp) {
            if (i != 0) {
                index++;
            }
        }

        if (every % index == 0) {
            return index;
        } else if (every > index) {
            return index;
        } else {
            return every % index;
        }
    }

    public static int distributeCandiesBetter(int[] candyType) {
        // HashSet
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }

        int type = set.size();
        int every = candyType.length / 2;

        // 可优化
        return Math.min(type, every);
        /*if (type == every) {
            return type;
        } else if (type > every) {
            return every;
        } else {
            return type;
        }*/

    }
}
