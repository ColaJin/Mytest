package hikversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试版本比较选择
 * @Date:2021/8/14
 */
public class TestVersion {

    public static void main(String[] args) {
        DeviceTypeAndDrv deviceTypeAndDrv1 = new DeviceTypeAndDrv();
        deviceTypeAndDrv1.setDrvId("drv_vss_gb_general_1.12.100001");
        // deviceTypeAndDrv1.setDrvVersion("1.8.101");
        // deviceTypeAndDrv1.setDrvId("drv_vss_hiksdk_general_c5_1.0.3");
        deviceTypeAndDrv1.setDrvVersion("1.0.3");

        DeviceTypeAndDrv deviceTypeAndDrv2 = new DeviceTypeAndDrv();
        deviceTypeAndDrv2.setDrvId("drv_vss_onvif_general_c2_1.0.0");
        deviceTypeAndDrv2.setDrvVersion("1.0.0");
        // deviceTypeAndDrv2.setDrvId("drv_int_hiksdk_1.8.101");
        // deviceTypeAndDrv2.setDrvVersion("1.8.101");

        DeviceTypeAndDrv deviceTypeAndDrv3 = new DeviceTypeAndDrv();
        // deviceTypeAndDrv3.setDrvId("drv_vss_hiksdk_general_1.8.101");
        // deviceTypeAndDrv3.setDrvVersion("1.8.101");

        List<DeviceTypeAndDrv> deviceTypeAndDrvs = new ArrayList<>();
        deviceTypeAndDrvs.add(deviceTypeAndDrv1);
        deviceTypeAndDrvs.add(deviceTypeAndDrv2);
        // deviceTypeAndDrvs.add(deviceTypeAndDrv3);

        Collections.sort(deviceTypeAndDrvs, new Comparator<DeviceTypeAndDrv>() {
            @Override
            public int compare(DeviceTypeAndDrv dtad1, DeviceTypeAndDrv dtad2) {
                return compareVersion(dtad1.getDrvVersion(), dtad2.getDrvVersion());
            }
        });

        System.out.println(deviceTypeAndDrvs.get(0).getDrvId());
    }

    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int index = 0;
        //获取最小长度值
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        //循环判断每位的大小
        while (index < minLen && (diff = Integer.parseInt(version1Array[index]) - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {//说明数字全都一样，只是位数不一样
            //如果位数不一致，比较多余位数
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return -1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? -1 : 1;
        }
    }
}
