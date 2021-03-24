package leetcode.Array.easy;

import java.util.HashMap;
import java.util.Map;

public class HasGroupsSizeX {
    public static void main(String[] args) {
        int[] deck = new int[]{1};
        System.out.println(hasGroupsSizeXBetter(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        //遍历数组存储数组到Map中，每次遇到相同的值对应的count++
        //遍历Map判断元素的count是不是>2大于的时候每次遍历的值的多个结果的最大公约数大于=2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (!map.containsKey(deck[i])) {
                map.put(deck[i], 1);
            } else {
                Integer temp = map.get(deck[i]);
                temp++;
                map.put(deck[i], temp);
            }
        }
        int[] num = new int[map.size()];

        int i = 0;
        //遍历Map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num[i] = entry.getValue();
            i++;
        }
        int moreBigDiv = getMoreBigDiv(num, map.size());

        return moreBigDiv >= 2 ? true : false;
    }

    public static int getMoreBigDiv(int num[], int n) { // 求多个数的最大公约数
        if (n == 1) {
            return num[n - 1];
        }
        return getBigDiv(num[n - 1], getMoreBigDiv(num, n - 1));
    }

    public static int getBigDiv(int a, int b) {// 求两个数的最大公约数
        if (b == 0) {
            return a;
        }
        return getBigDiv(b, a % b);
    }

    //Better
    public static boolean hasGroupsSizeXBetter(int[] deck) {
        //新建一个数组计算个数
        int[] arr = new int[10000];
        for (int i : deck) {
            arr[i]++;
        }
        int goc = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (goc == -1) {
                    goc = arr[i];
                } else {
                    goc = getBigDiv(goc, arr[i]);
                }
            }
        }

        return goc >= 2;
    }

}
