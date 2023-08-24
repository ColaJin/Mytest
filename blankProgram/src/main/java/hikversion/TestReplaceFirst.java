package hikversion;

/**
 * @author:jinyandong
 * @description:测试删除字符串左侧0
 * @Date:2023/8/23
 */
public class TestReplaceFirst {
    public static void main(String[] args) {
        String stayTimeSub = "000030";
        System.out.println(stayTimeSub.replaceFirst("^0*",""));
    }
}
