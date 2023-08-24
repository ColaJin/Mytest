package hikversion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:jinyandong
 * @description:测试Socket连接
 * @Date:2023/7/18
 */
public class TestSockectAccept {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);

            // 2、发送数据到服务端
            inputStream = socket.getInputStream();
            int readLength = 1024;
            byte[] valiMsg = null;
            int readed = 0;
            //IO读取
            byte[] bufData = new byte[readLength];
            if ((readed = inputStream.read(bufData)) > 0) {
                valiMsg = new byte[readed];
            }
            System.arraycopy(bufData, 0, valiMsg, 0, readed);
                /*int readlen = 0;
                while ((readlen = inputStream.read(bufData)) != -1) {
                    System.out.println(new String(bufData, 0, readlen));
                }*/
            // inputStream.read(bufData);
            // 数据长度
            byte[] bytesDataReturnC = new byte[readed - 4];
            // 数组截取截取返回的bufData从第1* 8位字节开始截取12*8长度的值到bytesDataReturn
            System.arraycopy(bufData, 1, bytesDataReturnC, 0, readed - 4);

            // 4、校验CRC
            byte[] crcByteReturn = SerialUtil.caluCRC(bytesDataReturnC);
            int i = SerialUtil.CRC_XModem(bytesDataReturnC);
            int crc0 = (readed - 1) - 2;
            int crc1 = (readed - 1) - 1;
            System.out.println(i);
            System.out.println(crc1);
            System.out.println(crc0);
            String s = Integer.toHexString(crcByteReturn[0]) + Integer.toHexString(crcByteReturn[1]);
            String s2 = Integer.toHexString(bufData[crc0]) + Integer.toHexString(bufData[crc1]);
            System.out.println(s);
            System.out.println(s2);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // 6、短连接关闭连接
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * 将十六进制字符数组转换为字节数组
     *
     * @param data 十六进制char[]
     * @return byte[]
     * @throws RuntimeException 如果源十六进制字符数组是一个奇怪的长度，将抛出运行时异常
     */
    public static byte[] decodeHex(char[] data) {

        int len = data.length;

        if ((len & 0x01) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * 将十六进制字符转换成一个整数
     *
     * @param ch    十六进制char
     * @param index 十六进制字符在字符数组中的位置
     * @return 一个整数
     * @throws RuntimeException 当ch不是一个合法的十六进制字符时，抛出运行时异常
     */
    protected static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch
                    + " at index " + index);
        }
        return digit;
    }
}
