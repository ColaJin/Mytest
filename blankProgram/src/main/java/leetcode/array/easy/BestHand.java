package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:2347. 最好的扑克手牌
 * @Date:2023/12/29
 */
public class BestHand {
    public static void main(String[] args) {
        int[] ranks = new int[]{4, 4, 2, 4, 4};
        char[] suits = new char[]{'d', 'a', 'a', 'b', 'c'};
        System.out.println(bestHand(ranks, suits));
    }

    public static String bestHand(int[] ranks, char[] suits) {
        String s = "High Card";
        /*char c1 = suits[0];
        boolean isFive = false;
        for (int i = 1; i < suits.length; i++) {
            if (c1 != suits[i]){
                isFive = true;
                break;
            }
        }
        if (!isFive) {
            return "Flush";
        }*/
        Map<Character, Integer> mapS = new HashMap<>();
        for (char suit : suits) {
            mapS.put(suit, mapS.getOrDefault(suit, 0) + 1);
        }
        if (!mapS.isEmpty()) {
            if (mapS.size() == 1) {
                return "Flush";
            }
        }
        Map<Integer, Integer> mapR = new HashMap<>();
        for (int rank : ranks) {
            mapR.put(rank, mapR.getOrDefault(rank, 0) + 1);
        }

        boolean isThree = false;
        boolean isTwo = false;
        for (Map.Entry<Integer, Integer> temp : mapR.entrySet()) {
            if (temp.getValue() >= 3) {
                isThree = true;
            } else if (temp.getValue() == 2) {
                isTwo = true;
            }
        }
        if (isThree) {
            return "Three of a Kind";
        }

        if (isTwo) {
            return "Pair";
        }

        return s;
    }
}
