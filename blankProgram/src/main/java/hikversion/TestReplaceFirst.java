package hikversion;

/**
 * @author:jinyandong
 * @description:测试删除字符串左侧0
 * @Date:2023/8/23
 */
public class TestReplaceFirst {
    public static void main(String[] args) {
        /*String stayTimeSub = "000030";
        System.out.println(stayTimeSub.replaceFirst("^0*",""));

        System.out.println(stayTimeSub.replace("\n",""));*/
        String urlPre = "http://10.19.141.155:8277/iotsc-center";
        urlPre = urlPre.replace("iotsc-center", "iotsc");
        String url = urlPre + "/development/open/v1/asset/deviceTemplate/deviceType/match";
        System.out.println(url);
    }
}
