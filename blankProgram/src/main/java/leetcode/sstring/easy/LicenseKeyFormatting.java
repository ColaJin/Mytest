package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:482.密钥格式化
 * @Date:2024/8/13
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuffer temp = new StringBuffer();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                temp.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    temp.append("-");
                }
            }
        }
        if (temp.length() > 0 && temp.charAt(temp.length() - 1) == '-') {
            temp.deleteCharAt(temp.length() - 1);
        }

        return temp.reverse().toString();
    }
}
