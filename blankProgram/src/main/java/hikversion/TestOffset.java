package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:jinyandong
 * @description:测试Socket连接
 * @Date:2023/7/18
 */
public class TestOffset {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);

            // 2、发送数据到服务端
            // 15=指令长+文件偏移地址;10=播放列表长
            byte[] data = new byte[15];
            int pos = 2048;
            data[0] = InstructionInfo.des0;
            data[1] = InstructionInfo.des1;
            data[2] = InstructionInfo.src0;
            data[3] = InstructionInfo.src1;
            data[4] = 0x37;
            data[5] = 0x31;
            data[6] = 0x2B;
            /*data[7] = (byte) (pos & 0xff);
            data[8] = (byte) (pos >> 8 & 0xff);
            data[9] = (byte) (pos >> 16 & 0xff);
            data[10] = (byte) (pos >> 24 & 0xff);
            data[11] = (byte) (pos >> 32 & 0xff);
            data[12] = (byte) (pos >> 40 & 0xff);
            data[13] = (byte) (pos >> 48 & 0xff);
            data[14] = (byte) (pos >> 56 & 0xff);*/
            /*data[7] = (byte) (pos >> 56 & 0xff);
            data[8] = (byte) (pos >> 48 & 0xff);
            data[9] = (byte) (pos >> 40 & 0xff);
            data[10] = (byte) (pos >> 32 & 0xff);
            data[11] = (byte) (pos >> 24 & 0xff);
            data[12] = (byte) (pos >> 16 & 0xff);
            data[13] = (byte) (pos >> 8 & 0xff);
            data[14] = (byte) (pos & 0xff);*/
            String posStr = String.valueOf(pos);
            while (posStr.length() < 8) {
                StringBuffer sb = new StringBuffer();
                //左补0
                sb.append("0").append(posStr);
                posStr = sb.toString();

            }
            byte[] fileOffset = new byte[8];
            char[] posStrChars = posStr.toCharArray();
            for (int k = 0; k < posStrChars.length; k++) {
                fileOffset[k] = (byte) posStrChars[k];
            }
            System.arraycopy(fileOffset, 0, data, 7, 8);
            outputStream = socket.getOutputStream();
            outputStream.write(data);
        } catch (IOException e) {
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
    }
}
