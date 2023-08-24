package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.python.antlr.ast.Str;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试CRC校验码生成
 * @Date:2023/7/14
 */
public class TestCRC {
    public static void main(String[] args) {
        byte[] bytes = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x31});
        byte[] bytes6 = {0x06};
        byte[] bytes5 = SerialUtil.caluCRC(new byte[]{0x30, 0x31, 0x30, 0x30, 0x37, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30});
        byte[] bytes7 = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x31, 0x31, 0x31});
        /*int i1 = Byte.toUnsignedInt(bytes[0]);
        int i2 = Byte.toUnsignedInt(bytes[1]);
        String s = Integer.toHexString(i1).toUpperCase();*/
        int i =  CRC16_XMODEM(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x31});
        byte[] bytes1 = int2byte(i);
        byte[] bytes2 = intToBytes(i);
        /*System.out.println("byte数组打印(十六进制输出)：\t" + bytes2hexDisplayHex(bytes));
        System.out.println("byte数组打印(十六进制输出)：\t" + bytes[0]);
        System.out.println("byte数组打印(十六进制输出)：\t" + bytes[1]);
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(i1).toUpperCase());
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(i2).toUpperCase());
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(bytes[1]));
        System.out.println("byte数组打印(十六进制输出)：\t" + Bite16(bytes));
        System.out.println("byte数组打印(十六进制输出)：\t" + Bite16(bytes5));
        System.out.println("byte1数组打印(十六进制输出)：\t" + bytes2hexDisplayHex(bytes1));
        System.out.println("byte1数组打印(十六进制输出)：\t" + bytes1[0]);
        System.out.println("byte1数组打印(十六进制输出)：\t" + bytes1[1]);
        System.out.println("byte1数组打印(十六进制输出)：\t" + bytes1[2]);
        System.out.println("byte1数组打印(十六进制输出)：\t" + bytes1[3]);
        System.out.println("byte1数组打印(十六进制输出)：\t" + bytes2hexDisplayHex(bytes1));
        System.out.println("byte2数组打印(十六进制输出)：\t" + bytes2hexDisplayHex(bytes2));
        System.out.println("INT CRC：\t" + i);*/

        /*if (bytes5[0] == bytes6[0]){
            System.out.println("equal");
        }

        System.out.println("byte数组打印(十六进制输出)：\t" + Bite16(bytes5));
        System.out.println("byte数组打印(十六进制输出)：\t" + Bite16(bytes7));

        byte[] byte8 = {0x46, 0x46, 0x46, 0x46, 0x46, 0x46,0x30, 0x31};

        System.out.println(new String(byte8, StandardCharsets.US_ASCII));

        String data = "FFFFFF01";
        String substring = data.substring(6,8);
        String substring1 = data.substring(0,2);
        System.out.println(substring);
        System.out.println(substring1);

        System.out.println(Integer.toHexString(0xFF & 0x31));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("light","");
        Map<String, Object> outputData = new HashMap<>();
        outputData.put("data", jsonObject);
        System.out.println(JSONObject.toJSONString(outputData));

        stringToHex("FF");*/
        /*int i1 = Byte.toUnsignedInt(bytes[0]);
        int i2 = Byte.toUnsignedInt(bytes[1]);

        System.out.println("byte数组打印(十六进制输出)：\t" + bytes[0]);
        System.out.println("byte数组打印(十六进制输出)：\t" + i1);
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(bytes[0]));
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(i1));
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(i1).toUpperCase());
        System.out.println("byte数组打印(十六进制输出)：\t" + bytes[1]);
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(bytes[1]));
        System.out.println("byte数组打印(十六进制输出)：\t" + Integer.toHexString(i2).toUpperCase());

        int i6 = CRC16.crc16_ccitt_xmodem(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x31});
        short i3 = CRC16.crc16_ccitt_xmodem_short(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x31});
        byte[] bytes3 = shortToByteArray(i3);


        //short i4 = CRC16.crc16_ccitt_xmodem_short(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x31},0,4);
        System.out.println(Integer.toHexString(i3));
        System.out.println(Integer.toHexString(bytes3[0]));
        System.out.println(Integer.toHexString(bytes3[1]));
        System.out.println(Integer.toHexString(i6).toUpperCase());
        //System.out.println(Integer.toHexString(i4).toUpperCase());

        */

        /*byte[] bytes8 = new byte[2];
        bytes8[0]=(byte)0x1b;
        bytes8[1]=(byte)0xe8;
        byte[] bytes3 = {(byte)0x30,(byte)0x31,(byte)0x30,(byte)0x30,(byte)0x37,(byte)0x34,(byte)0x30,(byte)0x30,(byte)0x32,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x33,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x31,(byte)0x5c,(byte)0x43,(byte)0x30,(byte)0x32,(byte)(byte)0x34,(byte)0x30,(byte)0x31,(byte)0x32,(byte)0x5c,(byte)0x46,(byte)0x73,(byte)0x34,(byte)0x38,(byte)0x34,(byte)0x38,(byte)0x5c,(byte)0x54,(byte)0x32,(byte)0x35,(byte)0x35,(byte)0x32,(byte)0x35,(byte)0x35,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x5c,(byte)0x4d,(byte)0x30,(byte)0x30,(byte)0x5c,(byte)0x4b,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x5c,(byte)0x57,(byte)0x20,(byte)0x45,(byte)0x54,(byte)0x43,(byte)0xa1,(byte)0xb0,(byte)0xcb,(byte)0xbd,(byte)0xb0,(byte)0xec,(byte)0xa1,(byte)0xb1,(byte)0xcc,(byte)0xd7,(byte)0xc2,(byte)0xb7,(byte)0xb6,(byte)0xe0,(byte)(byte)0x20,(byte)0x20,(byte)0xb9,(byte)0xd9,(byte)0xb7,(byte)0xbd,(byte)0xc7,(byte)0xfe,(byte)0xb5,(byte)0xc0,(byte)0xd3,(byte)0xd0,(byte)0xb1,(byte)0xa3,(byte)0xd5,(byte)0xcf};
        byte[] error = SerialUtil.caluCRC(bytes3);

        int i1 = SerialUtil.CRC_XModem(bytes3);
        System.out.println(i1);

        System.out.println(Integer.toHexString(error[0]));
        System.out.println(Integer.toHexString(Byte.toUnsignedInt(error[0])));
        System.out.println(Integer.toHexString(Byte.toUnsignedInt(error[1])));
        System.out.println(Integer.toHexString(error[1]));
        System.out.println(Integer.toHexString(bytes8[0]));
        System.out.println(Integer.toHexString(bytes8[1]));*/

        /*String unicodeStr = "\\u000b";
        String[] strArr = unicodeStr.split("\\\\u");
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < strArr.length; j++) {
            int hexVal = Integer.parseInt(strArr[j], 16);
            sb.append((char) hexVal);
        }
        System.out.println(sb.toString());

        byte[] bytes3 = {(byte)0x5c,(byte)0x57,(byte)0x20,(byte)0x45,(byte)0x54,(byte)0x43,(byte)0xa1,(byte)0xb0,(byte)0xcb,(byte)0xbd,(byte)0xb0,(byte)0xec,(byte)0xa1,(byte)0xb1,(byte)0xcc,(byte)0xd7,(byte)0xc2,(byte)0xb7,(byte)0xb6,(byte)0xe0,(byte)(byte)0x20,(byte)0x20,(byte)0xb9,(byte)0xd9,(byte)0xb7,(byte)0xbd,(byte)0xc7,(byte)0xfe,(byte)0xb5,(byte)0xc0,(byte)0xd3,(byte)0xd0,(byte)0xb1,(byte)0xa3,(byte)0xd5,(byte)0xcf};

        try {
            String str = new String(bytes3,"gb2312");
            String str1 = new String(bytes3,"GBK");
            System.out.println(str);
            System.out.println(str1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }*/

        /*//byte[] bytesBad = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x31});
        byte[] bytesBad = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x36, 0x39, 0x30});
        System.out.println(Integer.toHexString(bytesBad[0]));
        System.out.println(Integer.toHexString(bytesBad[1]));*/

        /*// byte[] bytesVar = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x31, 0x30, 0x30});
        // byte[] bytesVar = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x31, 0x31, 0x30});
        // byte[] bytesVar = SerialUtil.caluCRC(new byte[]{0x30, 0x31, 0x30, 0x30, 0x31, 0x32, 0x30});
        byte[] bytesVar = SerialUtil.caluCRC(new byte[]{0x30, 0x31, 0x30, 0x30, 0x31, 0x32, 0x31});
        System.out.println(Integer.toHexString(bytesVar[0]));
        System.out.println(Integer.toHexString(bytesVar[1]));*/

        /*byte[] bytesLightInfo = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x32, 0x31});
        System.out.println(Integer.toHexString(bytesLightInfo[0]));
        System.out.println(Integer.toHexString(bytesLightInfo[1]));*/

        /*byte[] bytesListNumber = SerialUtil.caluCRC(new byte[]{0x30, 0x30, 0x30, 0x31, 0x34, 0x39});
        System.out.println(Integer.toHexString(bytesListNumber[0]));
        System.out.println(Integer.toHexString(bytesListNumber[1]));*/
        byte[] bytesDataReturn = {(byte)0xfc,(byte)0x29,(byte)0xfc,(byte)0x29,(byte)0xfc,(byte)0x29,(byte)0x2f,(byte)0x2b};
        byte[] bytesDataReturn1 = {(byte)0xfc};
        try {
            String data = new String(bytesDataReturn, "GBK");
            String data1 = new String(bytesDataReturn1, "GBK");
            System.out.println(data);
            System.out.println(data1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

    private static byte [] shortToByteArray(short  s) {
        byte [] shortBuf = new byte [2];
        for(int i=0;i<2;i++) {
            int offset = (shortBuf.length - 1 -i)*8;
            shortBuf[i] = (byte )((s>>>offset)&0xff);
        }
        return shortBuf;
    }

    public static void stringToHex(String str) {
        StringBuffer sb = new StringBuffer();
        char ch[] = str.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }
        String result = sb.toString();
        System.out.println(result);
    }



    public static String Bite16(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;//只有一位的前面补个0
            }
            sb.append(tmp.toUpperCase());
        }
        return sb.toString();
    }
    // byte 转 string (十六进制)
    public static String bytes2hexDisplayHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp;
        sb.append("[");
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;//只有一位的前面补个0
            }
            sb.append(tmp).append(" ");//每个字节用空格断开
        }
        sb.delete(sb.length() - 1, sb.length());//删除最后一个字节后面对于的空格
        sb.append("]");
        return sb.toString();
    }

    public static int CRC16_XMODEM(byte[] buffer) {
        /* StringUtil.getByteArrayByString();*/

        int wCRCin = 0x0000; // initial value 65535
        int wCPoly = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)
        for (byte b : buffer) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((wCRCin >> 15 & 1) == 1);
                wCRCin <<= 1;
                if (c15 ^ bit)
                    wCRCin ^= wCPoly;
            }
        }
        wCRCin &= 0xffff;
        return wCRCin ^= 0x0000;
    }

    public static byte[] int2byte(int res){
        byte[] targets = new byte[4];

        for (int i = 0; i < 4; i++) {
            targets[4 - i - 1] = (byte) ((res >> 8 * i) & 0xff);
        }
        return targets;
    }

    // int转byte
    public static byte[] intToBytes(int i) {
        byte[] result = new byte[4];
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }
}
