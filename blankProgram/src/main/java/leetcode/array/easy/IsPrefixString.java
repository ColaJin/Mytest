package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1961. 检查字符串是否为数组前缀
 * @Date:2023/12/20
 */
public class IsPrefixString {
    public static void main(String[] args) {
        //String[] words = new String[]{"i","love","leetcode","apples"};
        String[] words = new String[]{"c","cc"};
        String s = "ccccccccc";
        System.out.println(isPrefixString(s, words));
    }
    public static boolean isPrefixString(String s, String[] words) {
        for (String word : words) {
            if(s.equals("")){
                return true;
            }
            if (s.startsWith(word)) {
                s = s.substring(word.length());
            } else {
                return false;
            }
        }
        // 保证s已经为空
        return s.equals("");
    }
}
