package leetcode.array.easy;

import org.bouncycastle.jcajce.provider.symmetric.TEA;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:2053. 数组中第 K 个独一无二的字符串
 * @Date:2023/12/22
 */
public class KthDistinct {
    public static void main(String[] args) {
        String[] arr = new String[]{"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }
    public static String kthDistinct(String[] arr, int k) {
        String rs = "";
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (map.containsKey(s) && map.get(s) == 1){
                k--;
                if (k == 0){
                    return s;
                }
            }
        }

        return rs;
    }
}
