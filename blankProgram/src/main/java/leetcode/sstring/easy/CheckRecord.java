package leetcode.sstring.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:551.学生出勤记录
 * @Date:2024/8/13
 */
public class CheckRecord {
    public static void main(String[] args) {
        System.out.println(checkRecord("LALL"));
    }
    public static boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get('A') != null && map.get('A') >= 2) {
                return false;
            }
        }
        if (s.contains("LLL")){
            return false;
        }
        return true;
    }
}
