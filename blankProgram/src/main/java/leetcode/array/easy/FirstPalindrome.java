package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2108. 找出数组中的第一个回文字符串
 * @Date:2023/12/26
 */
public class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        String rs = "";
        for (String word : words) {
            StringBuffer sb = new StringBuffer(word);
            //使用StringBuffer的reverse()方法
            String reverse = sb.reverse().toString();
            if (reverse.equals(word)){
                return word;
            }
        }
        return rs;
    }
}
