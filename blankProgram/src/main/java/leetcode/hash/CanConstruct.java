package leetcode.hash;

import java.util.Arrays;

/**
 * @author
 * @description:383. 赎金信
 * @Date:2021/7/15
 */
public class CanConstruct {
    public boolean canConstructLack(String ransomNote, String magazine) {
        // 情况少了位置互换的字符串，可以先排序
        char[] rCh = ransomNote.toCharArray();
        char[] mCh = magazine.toCharArray();
        Arrays.sort(rCh);
        Arrays.sort(mCh);
        /*String rRs = String.valueOf(rCh);
        String mRs = new String(mCh);*/

        return String.valueOf(mCh).contains(String.valueOf(rCh));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 遍历magzine存储到数组中及其数量，遍历ransomNote，没找到返回false，数量少返回false
        int[] temp = new int[26];
        for (char ch : magazine.toCharArray()) {
            temp[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (temp[ch - 'a'] == 0) {
                return false;
            } else {
                temp[ch - 'a']--;
            }
        }

        return true;
    }
}
