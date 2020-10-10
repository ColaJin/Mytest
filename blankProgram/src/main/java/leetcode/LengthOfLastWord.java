package leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "           ";
        int rs = lengthOfLastWord(s);
        System.out.println(rs);
    }


    public static int lengthOfLastWord(String s) {
        int blank = s.lastIndexOf(" ");
        int length = s.length();
        String rs = "";
        int count = 0;
        boolean can = false;
        if (blank == length - 1) {
            //当以空格结尾的数据，需要判断从不是空格的字符开始计算字符的个数，计算停止情况1：数组到头；情况2：遇到空格
            for (int i = blank - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    //当遇到字符时需要设置再遇到空格跳出循环计数停止返回结果
                    can = true;
                    count++;
                }else {
                    if (can){
                        break;
                    }
                }
            }
            return count;
        } else {
            rs = s.substring(blank + 1, s.length());
            return rs.length();
        }

    }
}
