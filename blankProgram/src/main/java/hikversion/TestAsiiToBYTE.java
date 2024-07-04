package hikversion;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * @author:jinyandong
 * @description:测试ascii转二进制
 * @Date:2023/10/25
 */
public class TestAsiiToBYTE {
    public static String convertAsciiToBinary(char character) {
        String binaryString = Integer.toBinaryString(character);
        return String.format("%8s", binaryString).replace(' ', '0');
    }

    public static void main(String[] args) {
        /*char character = 'A';
        String binaryString = convertAsciiToBinary(character);*/
        byte[] bytesDataReturn = new byte[4];
        bytesDataReturn[0] = 0x30;
        bytesDataReturn[1] = 0x31;
        bytesDataReturn[2] = 0x43;
        bytesDataReturn[3] = 0x32;
        String data = new String(bytesDataReturn, StandardCharsets.US_ASCII);
        System.out.println(data);
        String sss = data.toString();//转化完成的十六进制字符串
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sss.length(); i++) {//将16进制字符串每个字符便利出来
            String aa = sss.substring(i, i + 1);
//转化为二进制字符串
            String dfd = Long.toString(Long.parseLong(aa, 16), 2);
            for (int x = 0; x < 4 - dfd.length(); x++) {//如果二进制字符串缺少0则补0,EB90转二进制为1110 1011 1001 0000
                result.append("0");
            }
            result.append(dfd);
        }
//转化为二进制字符串
        String twoStr = result.toString().substring(0, result.length() - 1);
        System.out.println(twoStr);


        String failInfoStr = "0000001000000100";
        String abnormalTemp = failInfoStr.substring(6, 7);
        if (StringUtils.equals(abnormalTemp,"1")){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static String toHex4(byte value) {
        return String.format("%x", value);
    }

    private static void getBits(StringBuilder sb, byte b) {
        for (int i = 0; i < 8; i++) {
            sb.append((b & 128) == 0 ? 0 : 1);
            b <<= 1;
        }
        sb.append(' ');
    }

    public static String toBinary(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            getBits(sb, b);
        }
        return sb.toString().trim();
    }

    public static String stringToBinary(String str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            result.append(String.format("%4s", Integer.toBinaryString(ch)).replaceAll(" ", "0"));
        }
        return result.toString();
    }
}
