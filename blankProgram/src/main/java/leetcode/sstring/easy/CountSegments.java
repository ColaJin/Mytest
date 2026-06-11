package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:434.字符串中的单词数
 * @Date:2024/8/13
 */
public class CountSegments {
    public static void main(String[] args) {
        String temp = ", , , ,        a, eaefa";
        System.out.println(countSegments(temp));
    }
    public static int countSegments(String s) {
        if(s != null && s.equals("")){
            return 0;
        }
        String[] temp = s.split("\\s+");
        return temp.length;
    }
}
