package hikversion;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试/regDevice接口
 * @Date:2022/10/17
 */
public class TestRegDevice {

    public static void main(String[] args) {
        // regDevice(1);

        // 开十个线程
        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                regDevice(i);
            }
        }, "my thread1 name").start();

        new Thread( ()->{
            for (int i = 100; i < 200; i++) {
                regDevice(i);
            }
        },"my thread2 name").start();

        new Thread( ()->{
            for (int i = 200; i < 300; i++) {
                regDevice(i);
            }
        },"my thread3 name").start();

        new Thread( ()->{
            for (int i = 300; i < 400; i++) {
                regDevice(i);
            }
        },"my thread4 name").start();

        new Thread( ()->{
            for (int i = 400; i < 500; i++) {
                regDevice(i);
            }
        },"my thread5 name").start();

        new Thread( ()->{
            for (int i = 500; i < 600; i++) {
                regDevice(i);
            }
        },"my thread6 name").start();

        new Thread( ()->{
            for (int i = 600; i < 700; i++) {
                regDevice(i);
            }
        },"my thread7 name").start();

        new Thread( ()->{
            for (int i = 700; i < 800; i++) {
                regDevice(i);
            }
        },"my thread8 name").start();

        new Thread( ()->{
            for (int i = 800; i < 900; i++) {
                regDevice(i);
            }
        },"my thread9 name").start();

        new Thread( ()->{
            for (int i = 900; i < 1000; i++) {
                regDevice(i);
            }
        },"my thread10 name").start();

        new Thread(() -> {
            for (int i = 1000; i < 1100; i++) {
                regDevice(i);
            }
        }, "my thread11 name").start();

        new Thread( ()->{
            for (int i = 1100; i < 1200; i++) {
                regDevice(i);
            }
        },"my thread12 name").start();

        new Thread( ()->{
            for (int i = 1200; i < 1300; i++) {
                regDevice(i);
            }
        },"my thread13 name").start();

        new Thread( ()->{
            for (int i = 1300; i < 1400; i++) {
                regDevice(i);
            }
        },"my thread14 name").start();

        new Thread( ()->{
            for (int i = 1400; i < 1500; i++) {
                regDevice(i);
            }
        },"my thread15 name").start();

        new Thread( ()->{
            for (int i = 1500; i < 1600; i++) {
                regDevice(i);
            }
        },"my thread16 name").start();

        new Thread( ()->{
            for (int i = 1600; i < 1700; i++) {
                regDevice(i);
            }
        },"my thread17 name").start();

        new Thread( ()->{
            for (int i = 1700; i < 1800; i++) {
                regDevice(i);
            }
        },"my thread18 name").start();

        new Thread( ()->{
            for (int i = 1800; i < 1900; i++) {
                regDevice(i);
            }
        },"my thread19 name").start();

        new Thread( ()->{
            for (int i = 1900; i < 2000; i++) {
                regDevice(i);
            }
        },"my thread20 name").start();

        new Thread(() -> {
            for (int i = 2000; i < 2100; i++) {
                regDevice(i);
            }
        }, "my thread21 name").start();

        new Thread( ()->{
            for (int i = 2000; i < 2200; i++) {
                regDevice(i);
            }
        },"my thread22 name").start();

        new Thread( ()->{
            for (int i = 2200; i < 2300; i++) {
                regDevice(i);
            }
        },"my thread23 name").start();

        new Thread( ()->{
            for (int i = 2300; i < 2400; i++) {
                regDevice(i);
            }
        },"my thread24 name").start();

        new Thread( ()->{
            for (int i = 2400; i < 2500; i++) {
                regDevice(i);
            }
        },"my thread25 name").start();

        new Thread( ()->{
            for (int i = 2500; i < 2600; i++) {
                regDevice(i);
            }
        },"my thread26 name").start();

        new Thread( ()->{
            for (int i = 2600; i < 2700; i++) {
                regDevice(i);
            }
        },"my thread27 name").start();

        new Thread( ()->{
            for (int i = 2700; i < 2800; i++) {
                regDevice(i);
            }
        },"my thread28 name").start();

        new Thread( ()->{
            for (int i = 2800; i < 2900; i++) {
                regDevice(i);
            }
        },"my thread29 name").start();

        new Thread( ()->{
            for (int i = 2900; i < 3000; i++) {
                regDevice(i);
            }
        },"my thread30 name").start();

    }

    private static void regDevice(int i) {
        System.out.println("regDevice...");
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> res = null;
        try {
            res = new HashMap<>();
            res.put("addr", "10.19.214.186");
            res.put("port", "8080");
            res.put("deviceIndexCode", "test" + (10000 + i));
            res.put("treatyType", "gb_reg");
            res.put("devName", "test" + (10000 + i));
            res.put("devType", "NP-FCT100");
            result.add(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //发送消息给dms
        Map<String, Object> params = new HashMap<>();
        params.put("driverID", "drv_uitd_gb26875_general_1.7.200");
        params.put("isFull", false);
        params.put("regDevice", result);
        String re = HttpClient4.doPost("http://10.19.132.47:8082/dac/dms/v1/regDevice?serviceIndexCode=6AF38CD1-5B6D-98C5-B774-3DE70C4DFD67", params);
        System.out.println(re);
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
