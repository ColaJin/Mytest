package hikversion;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/**
 * @author:jinyandong
 * @description:测试http服务模拟
 * @Date:2026/5/22
 */
public class HttpServerTest {
    public static void main(String[] args) throws IOException {
        // 创建HTTP服务器，监听8014端口
        HttpServer server = HttpServer.create(new InetSocketAddress("10.15.82.27", 8014), 0);

        // 创建线程池
        server.setExecutor(Executors.newFixedThreadPool(10));

        // 注册处理程序
        server.createContext("/api/logicagent/operate", new LogicAgentHandler());
        server.createContext("/health", new HealthHandler());

        // 启动服务器
        server.start();
        System.out.println("LogicAgent HTTP Server started on http://10.10.82.18:8014");
    }

    static class LogicAgentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            BufferedReader reader = null;
            OutputStream outputStream = null;

            try {
                // 记录请求信息
                System.out.println("Received request: " + exchange.getRequestMethod() + " " + exchange.getRequestURI());

                // 读取请求体（如果有）- 兼容Java 8的写法
                if (exchange.getRequestMethod().equalsIgnoreCase("POST") ||
                        exchange.getRequestMethod().equalsIgnoreCase("PUT")) {

                    reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8));
                    StringBuilder requestBody = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        requestBody.append(line);
                    }

                    if (requestBody.length() > 0) {
                        System.out.println("Request body: " + requestBody.toString());
                    }
                }

                // 构建响应
                String response = "{\"code\":\"0\",\"msg\":\"success\",\"data\":{\"operation\":\"logicagent_operate\",\"status\":\"completed\"}}";

                // 设置响应头
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
                exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type, Authorization");

                // 发送响应
                byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(200, responseBytes.length);

                outputStream = exchange.getResponseBody();
                outputStream.write(responseBytes);

                System.out.println("Sent response: " + response);

            } catch (Exception e) {
                e.printStackTrace();
                String errorResponse = "{\"code\":\"-1\",\"msg\":\"Internal server error\"}";
                byte[] errorBytes = errorResponse.getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(500, errorBytes.length);
                outputStream = exchange.getResponseBody();
                outputStream.write(errorBytes);
            } finally {
                // 确保资源被关闭
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class HealthHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            OutputStream outputStream = null;
            try {
                String response = "{\"status\":\"healthy\",\"service\":\"LogicAgent Server\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");

                byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(200, responseBytes.length);

                outputStream = exchange.getResponseBody();
                outputStream.write(responseBytes);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
