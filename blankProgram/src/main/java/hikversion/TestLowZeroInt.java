package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试负值转换
 * @Date:2023/10/27
 */
public class TestLowZeroInt {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*int i = -99;
        String s = String.valueOf(i);*/
        /*JSONObject temp = new JSONObject();
        temp.put("start",-99);
        String start = temp.getString("start");
        System.out.println(start);

        JSONObject param = new JSONObject();
        List<String> status = new ArrayList<>();
        status.add("01");
        status.add("01");
        status.add("01");
        status.add("01");
        status.add("11");
        status.add("11");
        status.add("10");
        param.put("highwayStatusBit",status);
        JSONArray highwayStatusBitArr = param.getJSONArray("highwayStatusBit");
        StringBuffer sb = new StringBuffer();
        int size = highwayStatusBitArr.size();
        if (size % 4 !=0){
            int needAdd = 4 - size %4;
            for (int i = 0; i < needAdd; i++) {
                highwayStatusBitArr.add("10");
            }
        }
        for (int i = 0; i < highwayStatusBitArr.size(); i++) {
            sb.append(highwayStatusBitArr.get(i));
        }
        System.out.println(JSONObject.toJSONString(highwayStatusBitArr));

        System.out.println(param.get("highwayStatusBit").toString());
        System.out.println(sb.toString());*/

        /*byte[] bytes = {0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x31, 0x31, 0x31, 0x31, 0x31, 0x30};
        String temp = new String(bytes);
        System.out.println(temp);
        char[] chars = temp.toCharArray();
        int length = temp.length();
        List<String> status = new ArrayList<>();
        String rsTemp = "";
        for (int i = 0; i < length; i++) {
            rsTemp += chars[i];
            if (i % 2 != 0) {
                status.add(rsTemp);
                rsTemp = "";
            }

        }
        System.out.println(JSONObject.toJSONString(status));*/

        //byte[] bytes = {(byte) 0xB3,(byte)0xA9,(byte)0xCD,(byte)0xA8};
        /*byte[] bytes = {(byte) 0x43,(byte)0x44,(byte)0x45};
        String temp = new String(bytes,"GBK");
        System.out.println(temp);*/
        //byte[] bytes = {(byte) 0xd7,(byte)0xa2,(byte)0xd2,(byte)0xe2,(byte)0xb0,(byte)0xb2,(byte)0xc8,(byte)0xab};
        byte[] bytes = {(byte) 0xb1,(byte)0xa3,(byte)0xb3,(byte)0xd6,(byte)0xb3,(byte)0xb5,(byte)0xbe,(byte)0xe0};
        String temp = new String(bytes,"GBK");
        System.out.println(temp);

        String filePath = "play.lst";
        byte[] pathByte = filePath.getBytes("GBK");
        String data = new String(pathByte, StandardCharsets.US_ASCII);
        System.out.println(data);
        for (byte b : pathByte) {

            String tmp = Integer.toHexString(0xFF & b);
            System.out.println(tmp);
        }

    }
}
