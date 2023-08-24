package hikversion;

import java.nio.charset.StandardCharsets;

/**
 * @author:jinyandong
 * @description:16进制和ascii
 * @Date:2023/7/14
 */
public class StringToHex {
    public String convertStringToHex(String str){

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }

        return hex.toString();
    }

    public String convertHexToString(String hex){

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    private static String hexToAscii(String hexStr) {
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }

    //504F533838383834  POS88884
    public static void main(String[] args) {

        /*StringToHex strToHex = new StringToHex();
        System.out.println("\n-----ASCII码转换为16进制 -----");
        String str = "30";
        System.out.println("字符串: " + str);
        String hex = strToHex.convertStringToHex(str);
        System.out.println("转换为16进制 : " + hex);

        System.out.println("\n***** 16进制转换为ASCII *****");
        System.out.println("Hex : " + 0X30);
        System.out.println("ASCII : " + strToHex.convertHexToString(hex));*/
        byte[] bytes = {0x46,0x46};
        String he = new String(bytes, StandardCharsets.US_ASCII);
        System.out.println(he);
    }
}
