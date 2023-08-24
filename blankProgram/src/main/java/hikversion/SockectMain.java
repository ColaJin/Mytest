package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.ByteBuffer;

/**
 * @author:jinyandong
 * @description:Sockect发送main
 * @Date:2022/2/23
 */
public class SockectMain {
    private static String uri = "ws://10.19.187.155:6019";
    private static Session session;
    private void start() {
        WebSocketContainer container = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
        } catch (Exception ex) {
            System.out.println("error" + ex);
        }
        try {
            URI r = URI.create(uri);
            session = container.connectToServer(MyWebSockect.class, r);
        } catch (DeploymentException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JSONObject wsMessage = new JSONObject();

        JSONObject pack = new JSONObject();

        JSONObject devUpdateState = new JSONObject();
        devUpdateState.put("devRid","db51b1e1-9278-4e15-bff2-0564c5817d68");
        devUpdateState.put("status",2);
        devUpdateState.put("code","0x0190005c");

        JSONArray devUpdateStates = new JSONArray();

        devUpdateStates.add(devUpdateState);

        pack.put("devUpdateState",devUpdateStates);

        wsMessage.put("command","NOTIFY_DEVICE_UPDATE_STATUS");
        wsMessage.put("pack",pack);


        SockectMain client = new SockectMain();
        client.start();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            do {
                input = br.readLine();
                if (!input.equals("exit"))
                    client.session.getBasicRemote().sendText("javaclient"+input);
            } while (!input.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            client.session.getAsyncRemote().sendBinary(ByteBuffer.wrap(wsMessage.toString().getBytes("utf8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
