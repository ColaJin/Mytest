package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2138.将字符串拆分为若干长度为k的组
 * @Date:2024/8/23
 */
public class DivideString {
    public static void main(String[] args) {
        String[] strings = divideString("abcdefghij", 3, 'x');
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static String[] divideString(String s, int k, char fill) {
        int len = s.length();
        String[] res;
        if (len % k == 0) {
            res = new String[len / k];
        } else {
            res = new String[len / k + 1];
        }

        int index = 0;
        int i = 0;

        for (; i < len; ) {
            if (i + k > len){
                break;
            }
            res[index] = s.substring(i, i + k);
            i += k;
            index++;
        }
        if (i <= len - 1) {
            // 需要append fill
            StringBuffer sb = new StringBuffer();
            sb.append(s.substring(i));
            while (sb.length() < k) {
                sb.append(fill);
            }
            res[index] = sb.toString();
        }
        return res;
    }
}
