package hikversion;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.MessageFormat;

/**
 * @author:jinyandong
 * @description:测试IndexOF
 * @Date:2023/5/16
 */
public class TestIndexOf {
    public static void main(String[] args) {
        /*String componentId = "postgresql11linux64";
        if (StringUtils.isNotBlank(componentId) && 0 <= componentId.indexOf("postgresql")) {
            System.out.println("contains");
        }else {
            System.out.println("no");
        }*/

        String path = "/opt/hikvision/web/components/dac.1/resource/drivers/drv_sportshealth_wristband_activemq_reg_1.0.0001/bin/javadrive/lib/JavaHikPluginFrame-1.0-SNAPSHOT.jar";
        int lastIndex = path.lastIndexOf(File.separator);
        System.out.println(lastIndex);
        System.out.println("/usr/lib64/libDrvNetLib.so");
    }
}
