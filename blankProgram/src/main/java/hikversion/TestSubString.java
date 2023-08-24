package hikversion;

import org.apache.commons.lang3.StringUtils;

/**
 * @author:jinyandong
 * @description:测试字符串截取
 * @Date:2023/1/14
 */
public class TestSubString {
    public static void main(String[] args) {
        /*String org = "common.deviceOrg.area.yuehai.org1";
        String substring = org.substring(0, org.lastIndexOf("."));
        System.out.println(substring);

        String orgL = "common.deviceOrg.area.yuehai.";
        String[] split = StringUtils.split(orgL,".");
        System.out.println(split.length);

        String orgLS = "common.deviceOrg.area.yuehai.";
        String[] split1 = orgLS.split("\\.");
        System.out.println(split1.length);

        String[] split2 = org.split("\\.");
        System.out.println(split2.length);*/

        /*String temp = "0000003000000000\\C000000\\Fs3232\\T255000000000\\K000000000000\\WHello World";
        System.out.println(temp.substring(0, 3));
        System.out.println(temp.substring(3, 8));
        System.out.println(temp.substring(8, 10));
        System.out.println(temp.substring(10, 12));
        System.out.println(temp.substring(12, 14));*/

        /*String s = "/opt/opsmgr/web/components/dac.1/resource/drivers/drv_screen_netleddevice_dianming_net_1.0.0001/bin/vag/lib/JavaHikPluginFrame-2.0-SNAPSHOT.jar";
        String substring = s.substring(0, s.indexOf("lib/"));
        System.out.println(substring);
        System.out.println(substring+"libso/");*/


        System.out.println(init()+"libDrvNetLib.so");
    }

    public static String init() {
        // /opt/opsmgr/web/components/dac.1/resource/drivers/drv_screen_netleddevice_dianming_net_1.0.0001/bin/vag/lib/JavaHikPluginFrame-2.0-SNAPSHOT.jar
        String path = "/opt/opsmgr/web/components/dac.1/resource/drivers/drv_screen_netleddevice_dianming_net_1.0.0001/bin/vag/lib/JavaHikPluginFrame-2.0-SNAPSHOT.jar";
        String subPath = path.substring(0, path.indexOf("lib/"));
        return subPath + "libso/";
    }
}
