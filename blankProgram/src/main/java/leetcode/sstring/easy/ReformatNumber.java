package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1694.重新格式化电话号码
 * @Date:2024/8/15
 */
public class ReformatNumber {
    public String reformatNumber(String number) {
        String temp = number.replaceAll("-", "");
        String result = temp.replaceAll("\\s", "");
        StringBuffer sb = new StringBuffer();
        while (result.length() > 0) {
            int len = result.length();
            if (len >= 3) {
                if (len == 4) {
                    sb.append(result.substring(0, 2)).append("-");
                    result = result.substring(2);
                } else {
                    sb.append(result.substring(0, 3)).append("-");
                    result = result.substring(3);
                }
            } else {
                sb.append(result.substring(0, 2)).append("-");
                result = result.substring(2);
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
