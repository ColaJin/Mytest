package leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class isPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a 0lan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        //将空字符串定义为有效的回文串。trim()是去掉首尾空格
        if (s.replace(" ", "") == null || s.replace(" ", "") == "") {
            return true;
        }
        //将所有字符去掉空格后转成大写，然后判断是否是回文
        s = s.replace(" ", "");
        //去除所有标点符号
        s = s.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        //转大写很重要
        s = s.toUpperCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    //使用Character.isLetterOrDigit(char c)筛选字符
    // 之后拼接成StringBuffer然后再使用.reverse()方法
    // 之后使用equal方法比较结果是否相同


    //不需要改变字符串然后直接判断
    // 如果不是字符或者不是数字时，left++，right--
    // 然后再次判断left是否小于right
    // 字符转换成大写进行比较，不相等就返回false
    // 使left++，right--

}
