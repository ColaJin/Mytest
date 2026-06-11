package hikversion;

/**
 * @author:jinyandong
 * @description:测试请求tcp
 * @Date:2026/6/3
 */
import java.io.*;
import java.net.Socket;

public class TcpMockTester {

    public static void main(String[] args) {
        testTcpMock("127.0.0.1", 55056, "{\"indexCode\":\"1\"}");
    }

    public static void testTcpMock(String host, int port, String request) {
        try (Socket socket = new Socket(host, port);
             OutputStream output = socket.getOutputStream();
             InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            // 发送请求
            System.out.println("发送请求: " + request);
            output.write(request.getBytes());
            output.flush();

            // 接收响应
            StringBuilder response = new StringBuilder();
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                response.append(buffer, 0, bytesRead);
                if (reader.ready()) {
                    break;
                }
            }

            System.out.println("收到响应: " + response.toString());

            // 验证响应
            if (response.toString().contains("status")) {
                System.out.println("✅ 响应验证成功");
            } else {
                System.out.println("❌ 响应验证失败");
            }

        } catch (Exception e) {
            System.out.println("测试失败: " + e.getMessage());
        }
    }
}

