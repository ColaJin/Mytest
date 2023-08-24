package hikversion;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:jinyandong
 * @description:测试Socket连接
 * @Date:2023/7/18
 */
public class TestSockect {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);

            // 2、发送数据到服务端
            outputStream = socket.getOutputStream();

            /*byte instruct0 = 0x30;
            byte instruct1 = 0x31;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1};*/

            /*byte instruct0 = 0x36;
            byte instruct1 = 0x39;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1, (byte)0x31};*/

            /*byte instruct0 = 0x31;
            byte instruct1 = 0x31;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1, (byte)0x31};*/

            /*byte instruct0 = 0x32;
            byte instruct1 = 0x31;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1};*/

            /*byte instruct0 = 0x32;
            byte instruct1 = 0x33;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1, (byte)0x46, (byte)0x46, (byte)0x46, (byte)0x46, (byte)0x46, (byte)0x46};*/

            /*String name = "play00.lst";
            //byte[] nameBytes = decodeHex(name.toCharArray());
            byte[] nameBytes = new byte[10];
            char [] chars = name.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                nameBytes[j] = (byte) chars[j];
            }
            byte instruct0 = 0x34;
            byte instruct1 = 0x37;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
            // 数组截取截取返回的bytesData从第1* 8位字节开始截取12*8长度的值到bytesDataReturn
            System.arraycopy(nameBytes, 0, bytesData, 6, nameBytes.length);
            byte[] crcByte = SerialUtil.caluCRC(bytesData);
            byte[] bytes = {InstructionInfo.header, InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
            System.arraycopy(nameBytes, 0, bytes, 7, nameBytes.length);
            byte[] after = {crcByte[0],crcByte[1],InstructionInfo.tail};
            System.arraycopy(after, 0, bytes, 17, 3);*/

            byte instruct0 = 0x34;
            byte instruct1 = 0x39;

            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1};
            byte[] crcByte = SerialUtil.caluCRC(bytesData);
            byte[] bytes = {InstructionInfo.header, InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1, crcByte[0], crcByte[1], InstructionInfo.tail};

            /*String name = "play00.lst";
            String name0 = name.substring(0, 1);
            String name1 = name.substring(1, 2);
            String name2 = name.substring(2, 3);
            String name3 = name.substring(3, 4);
            String name4 = name.substring(4, 5);
            String name5 = name.substring(5, 6);
            String name6 = name.substring(6, 7);
            String name7 = name.substring(7, 8);
            String name8 = name.substring(8, 9);
            String name9 = name.substring(9, 10);
            byte nameByte0 = (byte) Integer.parseInt(name0, 16);
            byte nameByte1 = (byte) Integer.parseInt(name1, 16);
            byte nameByte2 = (byte) Integer.parseInt(name2, 16);
            byte nameByte3 = (byte) Integer.parseInt(name3, 16);
            byte nameByte4 = (byte) Integer.parseInt(name4, 16);
            byte nameByte5 = (byte) Integer.parseInt(name5, 16);
            byte nameByte6 = (byte) Integer.parseInt(name6, 16);
            byte nameByte7 = (byte) Integer.parseInt(name7, 16);
            byte nameByte8 = (byte) Integer.parseInt(name8, 16);
            byte nameByte9 = (byte) Integer.parseInt(name9, 16);
            byte instruct0 = 0x34;
            byte instruct1 = 0x37;
            byte[] bytesData = {InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1, nameByte0, nameByte1, nameByte2, nameByte3, nameByte4, nameByte5, nameByte6, nameByte7, nameByte8, nameByte9};
            byte[] crcByte = SerialUtil.caluCRC(bytesData);
            byte[] bytes = {InstructionInfo.header, InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1, nameByte0, nameByte1, nameByte2, nameByte3, nameByte4, nameByte5, nameByte6, nameByte7, nameByte8, nameByte9, crcByte[0], crcByte[1], InstructionInfo.tail};*/

            /*byte[] crcByte = SerialUtil.caluCRC(bytesData);

            String crcStr0 = Integer.toHexString(Byte.toUnsignedInt(crcByte[0])).toUpperCase();
            System.out.println(crcStr0);
            String crcStr1 = Integer.toHexString(Byte.toUnsignedInt(crcByte[1])).toUpperCase();

            byte[] bytes = {InstructionInfo.header, InstructionInfo.des0, InstructionInfo.des1, InstructionInfo.src0, InstructionInfo.src1, instruct0, instruct1,crcByte[0] , crcByte[1], InstructionInfo.tail};*/

            String s = "\r\n";
            byte[] data = new byte[2];
            char[] temp = s.toCharArray();
            for (int k = 0; k < s.length(); k++) {
                data[k] = (byte) temp[k];
            }

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
