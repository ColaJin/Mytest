package leetcode.sstring.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:1446.连续字符
 * @Date:2024/8/14
 */
public class MaxPower {
    public int maxPower(String s) {
        /*Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ;  i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            max = Math.max(max,map.get(s.charAt(i)));
        }*/
        int i = 0;
        int j = 1;
        int max = 0;
        if(s.length() == 1){
            return 1;
        }
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                i = j;
            }
            j++;
            max = Math.max(j - i, max);
        }
        return max;
    }
}
