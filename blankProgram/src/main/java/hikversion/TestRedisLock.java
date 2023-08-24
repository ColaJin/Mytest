package hikversion;

import hikversion.controller.AddDevice;

import java.io.IOException;

/**
 * @author:jinyandong
 * @description:测试分布式锁
 * @Date:2022/8/16
 */
public class TestRedisLock {


    public static void main(String[] args) throws IOException {
         AddDevice addDevice =new AddDevice();
         // addDevice.teatADD();
         addDevice.testSchedule();
        // addDevice.teatUpdate();
        // addDevice.teatADDActive();
    }

}
