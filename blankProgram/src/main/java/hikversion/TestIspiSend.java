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
public class TestIspiSend {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String content = "[PLAYLIST]\r\n" +
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
        /*String content = "[PLAYLIST]\r\n" +
                "ITEM_NO=001\r\n" +
                "ITEM000=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!";*/
        String filePath = "play00.lst";
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);
            outputStream = socket.getOutputStream();
            int fileLen = content.getBytes("GBK").length;
            byte[] pathByte = filePath.getBytes("GBK");
            int pathLen = pathByte.length;

            byte instruct0 = 0x37;
            byte instruct1 = 0x31;

            // 整包发送
            // 指令长+不定长文件路径名长+文件下发选项+文件偏移位置+文件长
            byte[] dataTemp = new byte[6 + pathLen + 1 + 8 + fileLen];
            dataTemp[0] = InstructionInfo.des0;
            dataTemp[1] = InstructionInfo.des1;
            dataTemp[2] = InstructionInfo.src0;
            dataTemp[3] = InstructionInfo.src1;
            dataTemp[4] = instruct0;
            dataTemp[5] = instruct1;
            dataTemp[6] = 0x2B;
            dataTemp[7] = 0x30;
            dataTemp[8] = 0x30;
            dataTemp[9] = 0x30;
            dataTemp[10] = 0x30;
            dataTemp[11] = 0x30;
            dataTemp[12] = 0x30;
            dataTemp[13] = 0x30;
            dataTemp[14] = 0x30;
            System.arraycopy(pathByte, 0, dataTemp, 15, pathLen);
            System.arraycopy(content.getBytes("GBK"), 0, dataTemp, 15 + pathLen, fileLen);

            /*String tempStr = new String(data, "GBK");
            String encodeRs = Base64.getEncoder().encodeToString(tempStr.getBytes("GBK"));*/
            String byteData = Base64.getEncoder().encodeToString(dataTemp);
            byte[] fileContent = Base64.getDecoder().decode(byteData);
            int itemAllLen = fileContent.length;
            int itemLen = itemAllLen - 25;
            byte[] itemTemp = new byte[itemLen];
            System.arraycopy(fileContent,25,itemTemp,0,itemLen);

            // 处理播放列表
            byte[] playListBytes = new byte[10];
            System.arraycopy(fileContent,15,playListBytes,0,10);
            if (itemLen > 2048) {
                // 分包发送
                // 根据长度分割动作信息
                int pack = itemLen / 2048;
                int res = itemLen % 2048;
                if (res > 0) {
                    // 需要pack包，否则需要pack +1包
                    pack++;
                }
                for (int j = 0; j < pack; j++) {
                    int pos = 2048 * j;
                    int packLen = 0;
                    byte[] data = null;
                    if (j == pack - 1) {
                        // 最后一包
                        data = new byte[res + 15 + 10];
                        packLen = res;
                    } else {
                        packLen = 2048;
                        data = new byte[2048 + 15 + 10];
                    }
                    data[0] = InstructionInfo.des0;
                    data[1] = InstructionInfo.des1;
                    data[2] = InstructionInfo.src0;
                    data[3] = InstructionInfo.src1;
                    data[4] = instruct0;
                    data[5] = instruct1;
                    data[6] = 0x2B;
                    // 处理文件偏移位置
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
                    System.arraycopy(playListBytes, 0, data, 15, 10);

                    if (j == pack - 1) {
                        // 最后一包
                        System.arraycopy(itemTemp, j * 2048, data, 25, res);
                    } else {
                        System.arraycopy(itemTemp, j * 2048, data, 25, 2048);
                    }
                    byte[] crcByte = SerialUtil.caluCRC(data);
                    byte[] bytes = new byte[packLen + 19 + 10];
                    bytes[0] = InstructionInfo.header;
                    System.arraycopy(data, 0, bytes, 1, data.length);
                    bytes[26 + packLen] = crcByte[0];
                    bytes[26 + packLen + 1] = crcByte[1];
                    bytes[26 + packLen + 2] = InstructionInfo.tail;
                    // 转义字节
                    byte[] transBytes = getTransBytes(bytes);
                    outputStream.write(transBytes);
                }
                System.out.println("success 2048");
            } else {
                // 整包发送
                // 头+报文+校验位+尾
                byte[] crcByte = SerialUtil.caluCRC(fileContent);
                // 19=指令长+头尾+文件偏移地址;10=播放列表长
                byte[] bytes = new byte[itemAllLen + 1 + 3];
                bytes[0] = InstructionInfo.header;
                System.arraycopy(fileContent, 0, bytes, 1, itemAllLen);
                bytes[1 + itemAllLen] = crcByte[0];
                bytes[1 + itemAllLen + 1] = crcByte[1];
                bytes[1 + itemAllLen + 2] = InstructionInfo.tail;
                // 转义字节
                byte[] transBytes = getTransBytes(bytes);
                outputStream.write(transBytes);
                System.out.println("success");
            }

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
