package hikversion.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class SocketServer extends WebSocketServer {

    /**
     * key websocket连接 ；value 设备编号
     */
    Map<WebSocket,String> connectMap = new ConcurrentHashMap<WebSocket,String>();
    /**
     * 用于判断连接后的第一次消息接口，第一次接收的是设备编号
     */
    String FIRST_CONNECT = "first_connect";

    public SocketServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public SocketServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!"); // This method sends a message to the new client
        //broadcast("new connection: " + handshake.getResourceDescriptor()); // This method sends a message to all clients connected
        if(connectMap.containsKey(conn)){
            System.out.println("cccccon");
        }else{
            System.out.println("first cccccon");
            connectMap.put(conn,FIRST_CONNECT);
        }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        //broadcast(conn + " has left the room!");
        System.out.println("cccccon");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("message:"+message);
        String connectValue = connectMap.get(conn);
        if(StringUtils.equals(FIRST_CONNECT,connectValue)){
            //连接后的第一个消息，设备编号
            System.out.println("message device:"+message);
            connectMap.put(conn,message);
        }else {
            System.out.println("other message");
        }

        // broadcast(message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            // some errors like port binding failed may not be assignable to a specific
            // websocket
        }

    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }
}
