package hikversion;


import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试透传编码
 * @Date:2023/11/22
 */
public class TestIspi {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String fileContent = "[PLAYLIST]\r\n" +
                "ITEM_NO=025\r\n" +
                "ITEM000=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM001=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\r\n" +
                "ITEM002=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM003=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM004=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM005=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM006=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM007=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM008=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM009=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM010=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM011=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\r\n" +
                "ITEM012=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM013=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM014=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM015=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM016=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM017=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM018=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM019=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM020=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM021=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\r\n" +
                "ITEM022=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM023=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM024=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!";

        /*String fileContent = "[PLAYLIST]\r\n" +
                "ITEM_NO=001\r\n" +
                "ITEM000=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!";*/

        String filePath = "play00.lst";
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);
            outputStream = socket.getOutputStream();
            int fileLen = fileContent.getBytes("GBK").length;
            byte[] pathByte = filePath.getBytes("GBK");
            int pathLen = pathByte.length;

            byte instruct0 = 0x37;
            byte instruct1 = 0x31;

            // 整包发送
            // 指令长+不定长文件路径名长+文件下发选项+文件偏移位置+文件长
            byte[] data = new byte[6 + pathLen + 1 + 8 + fileLen];
            data[0] = InstructionInfo.des0;
            data[1] = InstructionInfo.des1;
            data[2] = InstructionInfo.src0;
            data[3] = InstructionInfo.src1;
            data[4] = instruct0;
            data[5] = instruct1;
            data[6] = 0x2B;
            data[7] = 0x30;
            data[8] = 0x30;
            data[9] = 0x30;
            data[10] = 0x30;
            data[11] = 0x30;
            data[12] = 0x30;
            data[13] = 0x30;
            data[14] = 0x30;
            System.arraycopy(pathByte, 0, data, 15, pathLen);
            System.arraycopy(fileContent.getBytes("GBK"), 0, data, 15 + pathLen, fileLen);

            /*String tempStr = new String(data, "GBK");
            String encodeRs = Base64.getEncoder().encodeToString(tempStr.getBytes("GBK"));*/
            String encodeRs = Base64.getEncoder().encodeToString(data);
            System.out.println(encodeRs);

            System.out.println(encodeRs.length());

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

    public static byte[] getTransBytes(byte[] bytes) {
        // 按照顺序处理
        List<Byte> list = new LinkedList<>();
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                // 首尾不转义
                list.add(bytes[i]);
            } else if (bytes[i] == (byte) 0x02) {
                list.add((byte) 0x1B);
                list.add((byte) 0xE7);
            } else if (bytes[i] == (byte) 0x03) {
                list.add((byte) 0x1B);
                list.add((byte) 0xE8);
            } else if (bytes[i] == (byte) 0x1B) {
                list.add((byte) 0x1B);
                list.add((byte) 0x00);
            } else {
                list.add(bytes[i]);
            }
        }
        int sendLen = list.size();
        byte[] byteRs = new byte[sendLen];
        for (int i = 0; i < sendLen; i++) {
            byteRs[i] = list.get(i);
        }
        return byteRs;
    }
}
