package hikversion;

import hikversion.controller.SocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

/**
 * @author:jinyandong
 * @description:测试连接Socket服务端
 * @Date:2023/8/21
 */
public class TestSocketServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8887; // 843 flash policy port
        SocketServer s = null;
        try {
            s = new SocketServer(port);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        s.start();
        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            s.broadcast(in);
            if (in.equals("exit")) {
                s.stop(1000);
                break;
            }
        }
    }
}
