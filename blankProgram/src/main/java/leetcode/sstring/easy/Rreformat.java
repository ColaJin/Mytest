package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1417. 重新格式化字符串
 * @Date:2024/8/14
 */
public class Rreformat {
    public String reformat(String s) {
        int len = s.length();
        int i = 0;
        int j = 1;
        int Ccount = 0;
        int Ocount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                Ccount++;
            } else {
                Ocount++;
            }
        }
        if (Math.abs(Ccount - Ocount) > 1) {
            return "";
        }
        boolean flag = Ocount > Ccount;
        char[] arr = s.toCharArray();
        for (; i < len; i += 2) {
            if (Character.isLetter(arr[i]) == flag) {
                while (Character.isLetter(arr[j]) == flag) {
                    j += 2;
                }
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }

        }
        return new String(arr);
    }
}
