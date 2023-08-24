package hikversion;

import hikversion.controller.DeviceBean;
import hikversion.controller.DevicePostContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试/regDevice接口
 * @Date:2022/10/17
 */
public class TestAddDevice {

    public static void main(String[] args) {

addDevice(1);

    }

    private static void addDevice(int i) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (; i < 10000; i++) {
            try {
                Map<String, Object> res = null;
                res = new HashMap<>();
                res.put("deviceIndexCode", "test" + (10000 + i));
                res.put("treatyType", "gb26875_reg");
                res.put("devName", "test" + (10000 + i));
                res.put("deviceCategory", "fireprotection");
                res.put("deviceTypeCode", "fireDevice");
                result.add(res);

                //发送消息给dms
                Map<String, Object> params = new HashMap<>();
                params.put("devices", res);
                String re = HttpClientAdd.doPost("http://10.19.132.47:8082/dac/dms/v1/device?serviceIndexCode=3220665e-f513-4e17-9981-812c42df549c", params);
                System.out.println(re);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private static List<Map<String, Object>> parseBody(List<Map<String, Object>> dataList) {
        /**
         * addr                    string          是              设备的IP地址
         * port                    int             是              设备端口
         * deviceIndexCode         string          否              主动设备的设备编号，被动设备发现不携带该字段--IP或mac地址是唯一的，可以用来做设备编号
         * treatyType              string          否              主动设备的接入协议，被动设备发现不携带该字段
         * devName                 string          是              设备名称
         * devType                 string          是              设备型号（eHome设备是通过设备序列号截取，某些设备会有误差）
         */

        /**
         *                 detailMap.put("mac",StringUtils.bytesToHexString(mac));
         *                 detailMap.put("deviceAddr",(int)deviceAddr[0]);
         *                 detailMap.put("hardVersion",StringUtils.getVersionInt(hardVersion));
         *                 detailMap.put("softVersion",StringUtils.getVersionInt(softVersion));
         *                 detailMap.put("deviceType",StringUtils.byteArrayToString(deviceType));
         *                 detailMap.put("ip",ipv4Str);
         *                 detailMap.put("online", 1);
         */
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> res = null;
        for (Map<String, Object> data : dataList) {
            try {
                res = new HashMap<>();
                res.put("addr", "127.0.0.1");
                res.put("port", "9735");
                res.put("deviceIndexCode", data.get("imei"));
                res.put("treatyType", "huaitong_reg");
                res.put("devName", data.get("imei"));
                res.put("devType", "max120G4");
                result.add(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
