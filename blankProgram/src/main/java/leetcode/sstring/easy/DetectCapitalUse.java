package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:520.检测大写字母
 * @Date:2024/8/13
 */
public class DetectCapitalUse {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ggg"));
    }
    public static boolean detectCapitalUse(String word) {
        boolean isUpper = Character.isUpperCase(word.charAt(0));

        String sb = word.substring(1, word.length());
        String res = sb.toUpperCase();
        String resDown = sb.toLowerCase();
        if (isUpper) {
            if (res.equals(sb)){
                return true;
            }else if(resDown.equals(sb)){
                return true;
            }
        }else {
            if(resDown.equals(sb)){
                return true;
            }
        }
        // 首字母是大写时后面全大写或全小写
        // 后面全小写
        return false;
    }
}
