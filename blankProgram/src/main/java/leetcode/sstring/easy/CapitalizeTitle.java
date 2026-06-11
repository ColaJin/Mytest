package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2129.将标题首字母大写
 * @Date:2024/8/23
 */
public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String temp : s) {
            if (temp.length() > 2) {
                sb.append(Character.toUpperCase(temp.charAt(0)));
                sb.append(temp.substring(1).toLowerCase());
            } else {
                sb.append(temp.toLowerCase());
            }
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
