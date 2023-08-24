package hikversion.controller;

/**
 * @author:jinyandong
 * @description:测试字符串转int
 * @Date:2023/8/7
 */
public class TestStringToInt {
    public static void main(String[] args) {
        String s = "011";
        String width = "16";
        String str1 = new String();
        int i1 = s.charAt(2) - '0';
        int i2 = s.charAt(1) - '0';
        int i3 = s.charAt(0) - '0';
        int i = i1 * 100 + i2 * 10 + i3;

        int i4 = width.charAt(1) - '0';
        int i5 = width.charAt(0) - '0';
        int iall = i4 * 10 + i5;
        int rs = i+iall;
        System.out.println(String.valueOf(rs));
    }
}
