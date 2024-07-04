package hikversion;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author:jinyandong
 * @description:测试Socket连接
 * @Date:2023/7/18
 */
public class TestSockectAccept1 {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);

            // 2、发送数据到服务端
            inputStream = socket.getInputStream();

            byte[] data = dealReturnData(inputStream, "method", 7);

            int fileInfoLen = data.length - 12 - 1 - 8;
            System.out.println(fileInfoLen);

            // 4、校验CRC
            /*byte[] crcByteReturn = SerialUtil.caluCRC(bytesDataReturnC);
            int i = SerialUtil.CRC_XModem(bytesDataReturnC);
            int crc0 = (readed - 1) - 2;
            int crc1 = (readed - 1) - 1;
            System.out.println(i);
            System.out.println(crc1);
            System.out.println(crc0);
            String s = Integer.toHexString(crcByteReturn[0]) + Integer.toHexString(crcByteReturn[1]);
            String s2 = Integer.toHexString(bufData[crc0]) + Integer.toHexString(bufData[crc1]);
            System.out.println(s);
            System.out.println(s2);*/

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

    public static byte[] dealReturnData(InputStream inputStream, String method, int startPos) throws IOException {
        int readLength = 4096;
        byte[] valiMsg = null;
        int readed = 0;
        //IO读取
        byte[] bufData = new byte[readLength];
        if ((readed = inputStream.read(bufData)) > 0) {
            valiMsg = new byte[readed];
        }
        System.arraycopy(bufData, 0, valiMsg, 0, readed);

        // 遍历valiMsg然后处理转义数据
        byte[] transData = new byte[readed];
        int i = 0;
        boolean isCrc = false;
        for (byte b : valiMsg) {
            if (b == (byte)0x1b) {
                isCrc = true;
                continue;
            }else {
                if (isCrc) {
                    if (b == (byte) 0xe8) {
                        transData[i] = (byte) 0x03;
                    } else if (b == (byte) 0xe7) {
                        transData[i] = (byte) 0x02;
                    } else if (b == (byte) 0x00) {
                        transData[i] = (byte) 0x1B;
                    }
                    isCrc = false;
                }else {
                    transData[i] = b;
                }
            }
            i++;
        }

        byte[] rsTransData = new byte[i];
        System.arraycopy(transData, 0, rsTransData, 0, i);

        byte[] bytesDataReturnC = new byte[i - 4];
        // 数组截取截取返回的bufData从第1* 8位字节开始截取12*8长度的值到bytesDataReturn
        System.arraycopy(rsTransData, 1, bytesDataReturnC, 0, i - 4);
        // 4、校验CRC
        byte[] crcByteReturn = SerialUtil.caluCRC(bytesDataReturnC);
        if ((crcByteReturn[0] != rsTransData[i - 1 - 2]) || (crcByteReturn[1] != rsTransData[i - 1 - 1])) {
            String s = Integer.toHexString(crcByteReturn[0]) + Integer.toHexString(crcByteReturn[1]);
            String s2 = Integer.toHexString(rsTransData[i - 1 - 2]) + Integer.toHexString(rsTransData[i - 1 - 1]);
            String bufDataS = new String(bufData, "GBK");
            // 校验失败
            return new byte[0];
        }
        byte[] bytesDataReturn = new byte[i - 8 - 2];
        // 处理数据
        System.arraycopy(rsTransData, startPos, bytesDataReturn, 0, i - 8 - 2);
        return bytesDataReturn;
    }
}
