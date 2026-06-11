package hikversion;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author:jinyandong
 * @description:测试StringUtils的containsAny
 * @Date:2024/7/9
 */
public class TestStringUtilsContainsAny {
    public static void main(String[] args) {
        String originalComId = "sdmc";
        System.out.println(StringUtils.containsAny(originalComId,"ncg"));

        String[] temp = new String[]{"ncg"};
        System.out.println(StringUtils.containsAny(originalComId,temp));

        String deviceTypeCode = "acsDevice";
        if (!(StringUtils.isNotBlank(deviceTypeCode) && deviceTypeCode.equals("acsDevice"))) {
            System.out.println("不执行");
        }
    }
}
