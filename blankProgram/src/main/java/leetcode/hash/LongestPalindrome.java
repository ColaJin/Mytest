package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeByArray("abccccdd"));
    }

    // 全是相同的数字
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 每个字母至少偶数个，可以加1
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        boolean flag = false;

        // 遍历map
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 == 0) {
                // 加上偶数个
                count += m.getValue();
            } else {
                // 还有就是奇数个相同字母但是>2
                count += m.getValue() / 2 * 2;
                flag = true;
            }
        }

        return flag ? (count + 1) : count;
    }

    // 数组存储count遍历的时候ans += count/2 * 2 返回判断是否是奇数首次+1，ans % 2 == 0
    public static int longestPalindromeByArray(String s) {
        int[] count = new int[128];
        int sum = 0;
        for (Character ch : s.toCharArray()) {
            count[ch]++;
        }

        // 遍历的应该是count不是s
        for (int i : count) {
            sum += i / 2 * 2;
            //
            if (i % 2 != 0 && sum % 2 == 0) {
                sum++;
            }
        }

        return sum;
    }
}
