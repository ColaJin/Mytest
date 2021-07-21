package leetcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumSpecialEquivGroups {
    public static void main(String[] args) {
        String[] words = new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        System.out.println(numSpecialEquivGroupsOffical(words));
    }
    // 奇偶位排序后拼接
    public static int numSpecialEquivGroupsOffical(String[] A) {
        // 存储奇偶位置的元素的个数[1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        Set<String> seen = new HashSet();
        for (String S : A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    // 奇偶位排序后拼接
    public static int numSpecialEquivGroups(String[] words) {
        Set<String> rs = new HashSet<>();
        for (String word : words) {
            StringBuffer even = new StringBuffer();
            StringBuffer odd = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    // 偶数位
                    even.append(word.charAt(i));
                } else {
                    //
                    odd.append(word.charAt(i));
                }
            }
            // even排序不了？
            char[] evenChar = even.toString().toCharArray();
            char[] oddChar = odd.toString().toCharArray();
            Arrays.sort(evenChar);
            Arrays.sort(oddChar);
            new String(evenChar);
            rs.add(new String(evenChar) + new String(oddChar));
        }
        return rs.size();
    }
}
