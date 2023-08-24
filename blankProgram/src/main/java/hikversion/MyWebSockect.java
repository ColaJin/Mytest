package hikversion;

import org.springframework.web.context.support.WebApplicationObjectSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.websocket.*;
import java.net.URI;

/**
 * @author:jinyandong
 * @description:WebSockect客户端
 * @Date:2022/2/23
 */
@ClientEndpoint()
public class MyWebSockect {
    @OnOpen
    public void onOpen(Session session) {}
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client onMessage: " + message);
    }
    @OnClose
    public void onClose() {}
}
