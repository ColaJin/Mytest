package hikversion;

import java.net.InetAddress;

/**
 * @author:jinyandong
 * @description:测试ping操作
 * @Date:2023/8/14
 */
public class TestPing {
    public static void main(String[] args) {
        try {
            //System.out.println(ping("12.241.101.184"));
            System.out.println(ping("172.27.116.111"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean ping(String ipAddress) throws Exception {
        int  timeOut =  3000 ;  //超时应该在3钞以上
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
        // 当返回值是true时，说明host是可用的，false则不可。
        return status;
    }
}
