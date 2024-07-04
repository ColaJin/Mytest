package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author:jinyandong
 * @description:测试base64处理数据
 * @Date:2023/10/24
 */
public class TestBase64Send2048 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String fileContent = "[PLAYLIST]\n" +
                "ITEM_NO=050\n" +
                "ITEM000=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM001=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\n" +
                "ITEM002=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM003=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM004=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM005=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM006=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM007=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM008=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM009=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM010=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM011=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\n" +
                "ITEM012=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM013=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM014=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM015=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM016=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM017=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM018=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM019=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM020=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM021=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\n" +
                "ITEM022=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM023=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM024=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM025=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM026=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM027=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM028=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM029=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM030=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM031=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\n" +
                "ITEM032=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM033=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM034=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM035=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM036=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM037=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM038=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM039=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM040=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM041=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\n" +
                "ITEM042=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM043=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM044=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM045=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM046=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM047=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM048=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\n" +
                "ITEM049=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!";

        List<String> sendString = new ArrayList<>();
        String filePath = "play00.lst";
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);
            outputStream = socket.getOutputStream();
            int fileLen = fileContent.getBytes().length;
            byte[] pathByte = filePath.getBytes("GBK");
            int pathLen = pathByte.length;

            byte instruct0 = 0x37;
            byte instruct1 = 0x31;

            List<Byte> muliPack = new ArrayList<>();
            if (fileLen > 2048) {
                // 分包发送
                // 根据长度分割动作信息
                int pack = fileLen / 2048;
                int res = fileLen % 2048;
                if (res > 0) {
                    // 需要pack包，否则需要pack + 1包
                    pack++;
                }
                InputStream inputStream = null;
                inputStream = socket.getInputStream();
                for (int j = 0; j < pack; j++) {
                    int pos = 2048 * j;
                    int packLen = 0;
                    if (j == pack - 1) {
                        // 最后一包
                        packLen = res;
                    } else {
                        packLen = 2048;
                    }
                    byte[] data = new byte[6 + pathLen + 1 + 8 + packLen];
                    data[0] = InstructionInfo.des0;
                    data[1] = InstructionInfo.des1;
                    data[2] = InstructionInfo.src0;
                    data[3] = InstructionInfo.src1;
                    data[4] = instruct0;
                    data[5] = instruct1;
                    System.arraycopy(pathByte, 0, data, 6, pathLen);
                    data[6 + pathLen] = 0x2B;
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
                    System.arraycopy(fileOffset, 0, data, 6 + pathLen + 1, 8);

                    System.arraycopy(fileContent.getBytes(), j * 2048, data, 6 + pathLen + 1 + 8, packLen);
                    byte[] crcByte = SerialUtil.caluCRC(data);
                    int crcByteLen = crcByte.length;
                    byte[] bytes = new byte[7 + pathLen + 1 + 8 + packLen + crcByteLen + 1];
                    bytes[0] = InstructionInfo.header;
                    int dataLen = data.length;
                    // logger.info(HikLog.toLog("methodFileSend write bytes data1"));
                    System.arraycopy(data, 0, bytes, 1, dataLen);
                    // logger.info(HikLog.toLog("methodFileSend write bytes data2"));
                    System.arraycopy(crcByte, 0, bytes, 1 + dataLen, crcByteLen);
                    // logger.info(HikLog.toLog("methodFileSend write bytes data3"));
                    bytes[1 + dataLen + crcByteLen] = InstructionInfo.tail;
                    // logger.info(HikLog.toLog("methodFileSend write bytes data4"));
                    // 转义字节
                    byte[] transBytes = getTransBytes(bytes);
                    // logger.info(HikLog.toLog("methodFileSend write bytes data5"));
                    outputStream.write(transBytes);
                    inputStream = socket.getInputStream();
                    String tempStr = new String(transBytes, "GBK");
                    sendString.add(Base64.getEncoder().encodeToString(tempStr.getBytes("GBK")));
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } else {
                // 整包发送
                // 指令长+不定长文件路径名长+文件下发选项+文件偏移位置+文件长
                byte[] data = new byte[6 + pathLen + 1 + 8 + fileLen];
                data[0] = InstructionInfo.des0;
                data[1] = InstructionInfo.des1;
                data[2] = InstructionInfo.src0;
                data[3] = InstructionInfo.src1;
                data[4] = instruct0;
                data[5] = instruct1;
                System.arraycopy(pathByte, 0, data, 6, pathLen);
                data[6 + pathLen] = 0x2B;
                data[6 + pathLen + 1] = 0x30;
                data[6 + pathLen + 2] = 0x30;
                data[6 + pathLen + 3] = 0x30;
                data[6 + pathLen + 4] = 0x30;
                data[6 + pathLen + 5] = 0x30;
                data[6 + pathLen + 6] = 0x30;
                data[6 + pathLen + 7] = 0x30;
                data[6 + pathLen + 8] = 0x30;
                System.arraycopy(fileContent, 0, data, 6 + pathLen + 9, fileLen);
                byte[] crcByte = SerialUtil.caluCRC(data);
                // 19=指令长+头尾+文件偏移地址;10=播放列表长
                byte[] bytes = new byte[7 + pathLen + 1 + 8 + fileLen + 3];
                bytes[0] = InstructionInfo.header;
                System.arraycopy(data, 0, bytes, 1, data.length);
                bytes[1 + data.length] = crcByte[0];
                bytes[1 + data.length + 1] = crcByte[1];
                bytes[1 + data.length + 2] = InstructionInfo.tail;
                // 转义字节
                byte[] transBytes = getTransBytes(bytes);
                outputStream.write(transBytes);
            }


            if (!CollectionUtils.isEmpty(muliPack)) {
                // 遍历判断是否每包都成功
                String rs = "";
                for (Byte aByte : muliPack) {
                    String tmp = Integer.toHexString(0xFF & aByte);
                    if (StringUtils.equals("30", tmp)) {
                        rs = "初次打开文件时失败";
                        break;
                    }
                    if (StringUtils.equals("32", tmp)) {
                        rs = "偏移地址出错";
                        break;
                    }
                    if (StringUtils.equals("33", tmp)) {
                        rs = "移动文件到指定目录下失败";
                        break;
                    }
                }
                if (StringUtils.isEmpty(rs)) {
                    // 成功
                    System.out.println("成功");
                } else {
                    System.out.println("失败");
                }
            } else {
                System.out.println("应该不是else");
            }

            for (String s : sendString) {
                System.out.println(s);
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
