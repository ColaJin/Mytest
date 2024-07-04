package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2515. 到目标字符串的最短距离
 * @Date:2024/2/1
 */
public class ClosetTarget {
    public static void main(String[] args) {
        String[] words = new String[]{"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(closetTarget(words, target, startIndex));
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        int rs = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (target == words[i]) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return -1;
        }
        for (Integer temp : list) {
            if (startIndex > temp) {
                rs = Math.min(rs, startIndex - temp);
                rs = Math.min(rs, len - (startIndex - temp));
            } else {
                rs = Math.min(rs, temp - startIndex);
                rs = Math.min(rs, len - (temp - startIndex));
            }
        }
        return rs;
    }
}
