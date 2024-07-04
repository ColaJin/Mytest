package hikversion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author:jinyandong
 * @description:测试telnet
 * @Date:2024/4/12
 */
public class TestTelnet {
    public static void main(String[] args) {
        Boolean telnet = telnet("10.19.153.82", 29501, 30);
        System.out.println(telnet);
    }

    private static Boolean telnet(String addr, Integer port, int timeout) {
        Socket socket = new Socket();
        boolean isConn = false;
        try {
            socket.connect(new InetSocketAddress(addr,port),timeout);
            isConn = socket.isConnected();
        }catch (Exception e){
            System.out.println("telnet error");
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("telnet error");
            }
        }
        return isConn;

    }
}
