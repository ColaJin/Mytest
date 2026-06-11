package leetcode.array.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:jinyandong
 * @description:LCR 186.文物朝代判断
 * @Date:2024/8/12
 */
public class HalfQuestions {
    public static void main(String[] args) {
        int[] questions = new int[]{8,11,6,10};
        System.out.println(halfQuestions(questions));
    }
    public static int halfQuestions(int[] questions) {
        int len = questions.length;
        int people = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(questions[i], map.getOrDefault(questions[i], 0) + 1);
            if (map.get(questions[i]) >= people) {
                return 1;
            }
        }
        LinkedHashMap<Integer, Integer> collect = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new));
        int res = 0;
        for (Map.Entry<Integer, Integer> temp : collect.entrySet()) {
            if (temp.getValue() >= people) {
                res++;
                return res;
            } else {
                people -= temp.getValue();
                res++;
            }
        }
        return res;
    }
}
