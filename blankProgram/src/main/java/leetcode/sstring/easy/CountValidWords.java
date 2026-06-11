package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2047.句子中的有效单词数
 * @Date:2024/8/23
 */
public class CountValidWords {
    public static void main(String[] args) {
        System.out.println(countValidWords(" o6 t"));
    }
    public static int countValidWords(String sentence) {
        String[] split = sentence.split("\\s+");
        int res = 0;
        for (String s : split) {
            if (s.equals("")){
                continue;
            }
            boolean word = true;
            boolean special = false;
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (Character.isDigit(temp)) {
                    word = false;
                    break;
                } else {
                    if (temp == '-') {
                        if (special) {
                            word = false;
                            break;
                        }
                        special = true;
                        // 连字符左右要是字母
                        if (i == 0 || i == s.length() - 1) {
                            word = false;
                            break;
                        }else {
                            if (!Character.isLetter(s.charAt(i - 1)) || !Character.isLetter(s.charAt(i + 1))){
                                word = false;
                                break;
                            }
                        }
                    }else {
                        if (i != s.length() - 1 && (temp== '!' || temp == '.' || temp == ',')){
                            word = false;
                            break;
                        }
                    }
                }
            }
            if (word) {
                res++;
            }
        }
        return res;
    }
}
