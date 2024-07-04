package hikversion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/**
 * @author:jinyandong
 * @description:测试Socket超时参数设置
 * @Date:2023/11/13
 */
public class TestSocketOutTime {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            /*socket = new Socket("172.17.199.246", 5009);
            socket.setSoTimeout(1000);*/
            socket = new Socket();
            /*SocketAddress address = new InetSocketAddress("172.17.199.246", 5009);
            socket.connect(address, 1000);*/
            SocketAddress address = new InetSocketAddress("10.15.66.29", 60000);
            socket.connect(address, 1000);
            //socket.setSoTimeout(1000);
            System.out.println("expend" + (System.currentTimeMillis() - start));
            // 2、发送数据到服务端
            outputStream = socket.getOutputStream();
            /*int num = 2048;
            byte[] bytes = ByteBuffer.allocate(4).putInt(num).array();
            StringBuilder hex = new StringBuilder();
            for (byte b : bytes) {
                hex.append(String.format("%02X", b));
            }
            String s = hex.toString();
            byte[] rs = s.getBytes();*/
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            InputStream inputStream = socket.getInputStream();
            while(inputStream.read()!=-1) {
                System.out.println("this is data");
            }
            System.out.println("expend 2222" + (System.currentTimeMillis() - start));
        } catch (IOException e) {
            System.out.println("expend error" + (System.currentTimeMillis() - start));
            System.out.println(e);
        } finally {
            // 6、短连接关闭连接
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        System.out.println("expend end" + (System.currentTimeMillis() - start));
    }

}
