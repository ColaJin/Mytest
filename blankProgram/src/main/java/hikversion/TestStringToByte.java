package hikversion;

import java.nio.ByteBuffer;

/**
 * @author:jinyandong
 * @description:测试字符串转换Byte
 * @Date:2023/8/15
 */
public class TestStringToByte {
    public static void main(String[] args) {
        String light = "FF";
        // String 转换成ascii;
        String light0 = light.substring(0, 1);
        String light1 = light.substring(1, 2);
        byte lightByte0 = (byte) Integer.parseInt(light0, 16);
        byte lightByte1 = (byte) Integer.parseInt(light1, 16);
        char[] chars = light.toCharArray();
        byte lightByte2 = (byte) chars[0];
        byte lightByte3 = (byte) chars[1];
        byte[] bytes = light.getBytes();

        System.out.println(Integer.toBinaryString(lightByte0));
        System.out.println(Integer.toBinaryString(lightByte1));
        System.out.println(Integer.toBinaryString(lightByte3));
        System.out.println(Integer.toBinaryString(lightByte2));
        System.out.println(Integer.toBinaryString(bytes[0]));
        System.out.println(Integer.toBinaryString(bytes[1]));
        System.out.println(light1);

        // 1.先转为In类型
        int parseInt = Integer.parseInt("F", 16);
        System.out.printf("%15d",parseInt); //备注：printf可以使用使用格式控制串“%md”输出域宽为m的十进制整数
        // 2.强转为byte
        byte b = (byte) (parseInt & 0xFF);

        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(parseInt);
        byte b1 = buffer.get(0);
        System.out.println(parseInt);
        System.out.println(b);
    }
}
