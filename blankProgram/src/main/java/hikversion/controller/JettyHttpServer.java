package hikversion.controller;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyHttpServer {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            // 设置HTTP配置
            HttpConfiguration httpConfig = new HttpConfiguration();
            httpConfig.setIdleTimeout(30000); // 设置连接空闲超时时间（毫秒）
            httpConfig.setBlockingTimeout(5000); // 设置处理请求的超时时间（毫秒）
            // 创建HTTP连接工厂
            HttpConnectionFactory httpFactory = new HttpConnectionFactory(httpConfig);
            // 创建连接器，绑定到特定的端口
            ServerConnector connector = new ServerConnector(server, httpFactory);
            connector.setPort(8003);
            server.setConnectors(new ServerConnector[]{connector});

            ServletContextHandler context = new ServletContextHandler();
            context.setContextPath("/");
            server.setHandler(context);
            context.addServlet(new ServletHolder(new JettyHttpServletHandler("8003")), "/hik/test");
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println("eeee");
        }

    }

}
