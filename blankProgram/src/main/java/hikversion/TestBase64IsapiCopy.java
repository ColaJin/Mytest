package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @author:jinyandong
 * @description:测试base64处理数据
 * @Date:2023/10/24
 */
public class TestBase64IsapiCopy {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String str = "我要测试Base64";
        // byte[] decode = Base64.getDecoder().decode(str);

        byte[] encode = Base64.getEncoder().encode(str.getBytes());
        String temp = new String(encode);
        System.out.println(temp);
        byte[] decode = Base64.getDecoder().decode(temp);
        System.out.println(new String(decode));*/
        /*String orgin = "安全高于一切 责任重于泰山";
        String fileDetail = Base64.getEncoder().encodeToString(orgin.getBytes("GBK"));*/
        // String str = "W3BsYXlsaXN0XQppdGVtX25vPTMKaXRlbTA9MzAwLDEsMSxcQzAwMDAwMFxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMMm9uqPT0MfpXEMwMDAwMzJcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDDM7MHJtdjE/gppdGVtMT0zMDAsMSwxLFxDMDAwMDAwXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0/bT0MqpuaRcQzAwMDAzMlxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMNei0uKx3MjDCml0ZW0yPTMwMCwxLDEsXEMwMDAwMDBcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDDAptT6wM65zFxDMDAwMDMyXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0c+9+9LFyPYK";
        String fileInfo = "MDAwMTcxKzAwMDAwMDAwcGxheTAwLmxzdFtQTEFZTElTVF0KSVRFTV9OTz0wMDEKSVRFTTAwMD0zMCwwLDAsMCwwLFxDMDE3MDE3XEIwMDFcQzA1MDAwOFxGczQ4NDhcVDI1NTI1NTAwMDAwMFxXMgo=";
        //String sss = new String(str.getBytes(),"GBK");
        byte[] fileContent = Base64.getDecoder().decode(fileInfo);

        int itemAllLen = fileContent.length;
        int itemLen = itemAllLen - 25;
        byte[] itemTemp = new byte[itemLen];
        System.arraycopy(fileContent,25,itemTemp,0,itemLen);

        // 处理播放列表
        byte[] playListBytes = new byte[10];
        System.arraycopy(fileContent,16,playListBytes,0,10);
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);
            outputStream = socket.getOutputStream();
            if (itemLen > 2048) {

            } else {
                // 整包发送
                // 头+报文+校验位+尾
                byte[] crcByte = SerialUtil.caluCRC(fileContent);
                // 19=指令长+头尾+文件偏移地址;10=播放列表长
                byte[] bytes = new byte[itemLen + 1 + 3];
                bytes[0] = InstructionInfo.header;
                System.arraycopy(fileContent, 0, bytes, 1, itemLen);
                bytes[1 + itemLen] = crcByte[0];
                bytes[1 + itemLen + 1] = crcByte[1];
                bytes[1 + itemLen + 2] = InstructionInfo.tail;
                // 转义字节
                byte[] transBytes = getTransBytes(bytes);
                outputStream.write(transBytes);
            }
        }catch (IOException e) {
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
