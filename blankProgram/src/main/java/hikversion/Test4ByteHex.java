package hikversion;

import java.nio.ByteBuffer;

/**
 * @author:jinyandong
 * @description:测试4字节16进制
 * @Date:2023/11/2
 */
public class Test4ByteHex {
    public static void main(String[] args) {
        int num = 2048;
        byte[] bytes = ByteBuffer.allocate(4).putInt(num).array();
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        String s = hex.toString();
        byte[] rs = s.getBytes();
        System.out.println(s);
    }
}
