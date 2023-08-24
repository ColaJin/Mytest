package hikversion;

import java.io.UnsupportedEncodingException;

/**
 * @author:jinyandong
 * @description:测试byte数组转换成string
 * @Date:2023/8/9
 */
public class TestByteToString {
    public static void main(String[] args) {
        /*byte[] bytes = new byte[27];
        bytes[0] = (byte)0xd3;
        bytes[1] = (byte)0xf6;
        bytes[2] = (byte)0xca;
        bytes[3] = (byte)0xc2;
        bytes[4] = (byte)0xb9;
        bytes[5] = (byte)0xca;
        bytes[6] = (byte)0x20;
        bytes[7] = (byte)0xb3;
        bytes[8] = (byte)0xb5;
        bytes[9] = (byte)0xbf;
        bytes[10] = (byte)0xbf;
        bytes[11] = (byte)0xb1;
        bytes[12] = (byte)0xdf;
        bytes[13] = (byte)0x20;
        bytes[14] = (byte)0xc8;
        bytes[15] = (byte)0xcb;
        bytes[16] = (byte)0xb3;
        bytes[17] = (byte)0xb7;
        bytes[18] = (byte)0xc0;
        bytes[19] = (byte)0xeb;
        bytes[20] = (byte)0x20;
        bytes[21] = (byte)0xbc;
        bytes[22] = (byte)0xb4;
        bytes[23] = (byte)0xb1;
        bytes[24] = (byte)0xa8;
        bytes[25] = (byte)0xbe;
        bytes[26] = (byte)0xaf;

        try {
            String temp = new String(bytes,"GBK");
            System.out.println(temp);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }*/
        byte[] bytes = new byte[15];
        /*bytes[0] = (byte)0x47;
        bytes[1] = (byte)0x8b;
        bytes[2] = (byte)0x45;
        bytes[3] = (byte)0x20;
        bytes[4] = (byte)0x66;
        bytes[5] = (byte)0x60;
        bytes[6] = (byte)0x3f;
        bytes[7] = (byte)0x20;
        bytes[8] = (byte)0xba;
        bytes[9] = (byte)0xa4;
        bytes[10] = (byte)0x3f;
        bytes[11] = (byte)0x20;
        bytes[12] = (byte)0x73;
        bytes[13] = (byte)0xa5;
        bytes[14] = (byte)0x66;*/
        bytes[0] = (byte)0x47;
        bytes[1] = (byte)0x8b;
        bytes[2] = (byte)0x45;
        bytes[3] = (byte)0x20;
        bytes[4] = (byte)0x66;
        bytes[5] = (byte)0x60;
        bytes[6] = (byte)0xb9;
        bytes[7] = (byte)0x20;
        bytes[8] = (byte)0xba;
        bytes[9] = (byte)0xa4;
        bytes[10] = (byte)0xbb;
        bytes[11] = (byte)0x20;
        bytes[12] = (byte)0x73;
        bytes[13] = (byte)0xa5;
        bytes[14] = (byte)0x66;

        try {
            String temp = new String(bytes,"GBK");
            System.out.println(temp);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
