package hikversion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.Base64;

/**
 * @author:jinyandong
 * @description:测试读取bmp文件后发送
 * @Date:2023/11/13
 */
public class TestBmpSend {
    public static void main(String args[]) throws Exception {
        // 文件本地路径
        File file = new File("D:/b.bmp");
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "bmp", os);
        byte[] bytes = os.toByteArray();

        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);
            // 2、发送数据到服务端
            outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            System.out.println(Base64.getEncoder().encodeToString(bytes));
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // 3、短连接关闭连接
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }


}
