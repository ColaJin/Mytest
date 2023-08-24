package hikversion.controller;

/**
 * @author:jinyandong
 * @description:测试分割
 * @Date:2023/5/9
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = "http://10.15.65.110:45772";
        System.out.println(str.split("//")[1]);
    }
}
