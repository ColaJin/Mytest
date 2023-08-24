package hikversion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@ServerEndpoint(value="/websocket")
@Component
public class MyWebSocket {
	
	 //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    //与某个控制卡客户端的连接会话，需要通过它来给控制卡客户端发送数据
    private Session session;

    private static final Map<String,Long> map=new HashMap<String, Long>(){
	{
    	put("a",(long) 0);
    	put("b",(long) 0);
    }};

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线控制卡数为" + getOnlineCount());
        try {
        	GetInfo g=new GetInfo();
			  g.set__type("GetCardInfo");
			  g.setId("first");
			  String jsondata=JSON.toJSONString(g);
            sendMessage(jsondata);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线控制卡数为" + getOnlineCount());
    }

    /**
     * 收到控制卡消息后调用的方法
     *
     * @param message 控制卡发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自控制卡的消息:" + message);
        long endTime =  System.currentTimeMillis();
        long a = map.get("a");
        long b = map.get("b");
        if (a==0&&b==0) {
			a=endTime;
			b=endTime;
		} else {
			a=b;
			b=endTime;
		}
        map.put("a", a);
		map.put("b", b);
        long cTime = b-a;
        System.out.println("控制卡给服务端发消息的间隔-----"+cTime/1000);
        //群发消息
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message) throws IOException {
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

}
