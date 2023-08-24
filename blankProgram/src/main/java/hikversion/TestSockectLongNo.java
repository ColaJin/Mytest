package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:jinyandong
 * @description:测试Socket连接
 * @Date:2023/7/18
 */
public class TestSockectLongNo {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);

            // 2、发送数据到服务端
            String requestStr = "{\n" +
                    "    \"method\":\"Playlist\",\n" +
                    "    \"params\":{\n" +
                    "        \"indexCode\":\"993a47b85c7349a0b15e1042de2470a6\",\n" +
                    "        \"playList\":\"play00.lst\",\n" +
                    "        \"header\":\"[PLAYLIST]\",\n" +
                    "        \"actionCount\":\"001\",\n" +
                    "        \"itemList\":[\n" +
                    "            {\n" +
                    "                \"actionNum\":\"000\",\n" +
                    "                \"stayTime\":\"30\",\n" +
                    "                \"type\":\"立显\",\n" +
                    "                \"screenType\":\"立显\",\n" +
                    "                \"speed\":\"00\",\n" +
                    "                \"start\":\"000\",\n" +
                    "                \"end\":\"000\",\n" +
                    "                \"name\":\"\",\n" +
                    "                \"fileType\":\"\",\n" +
                    "                \"red\":\"000\",\n" +
                    "                \"green\":\"255\",\n" +
                    "                \"blue\":\"000\",\n" +
                    "                \"amber\":\"000\",\n" +
                    "                \"bgRed\":\"000\",\n" +
                    "                \"bgGreen\":\"000\",\n" +
                    "                \"bgBlue\":\"000\",\n" +
                    "                \"bgAmber\":\"000\",\n" +
                    "                \"space\":\"\",\n" +
                    "                \"font\":\"s\",\n" +
                    "                \"width\":\"32\",\n" +
                    "                \"high\":\"32\",\n" +
                    "                \"warp\":false,\n" +
                    "                \"times\":\"\",\n" +
                    "                \"locationX\":\"\",\n" +
                    "                \"locationY\":\"\",\n" +
                    "                \"locationZ\":\"\",\n" +
                    "                \"content\":\"遇事故 车靠边 人撤离 即报警\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
            JSONObject request = JSONObject.parseObject(requestStr);
            JSONObject params = request.getJSONObject("params");
            outputStream = socket.getOutputStream();

            StringBuffer itemStrs = new StringBuffer();
            String header = params.getString("header") + "\r\n";
            itemStrs.append(header);
            String actionCount = "ITEM_NO=" + params.getString("actionCount") + "\r\n";
            itemStrs.append(actionCount);
            // 遍历动作条数，拼字符串
            String itemList = params.getString("itemList");
            JSONArray itemArray = JSONObject.parseArray(itemList);
            int size = itemArray.size();
            // List<String> itemStrs = new ArrayList<>();
            for (Object item : itemArray) {
                size--;
                JSONObject itemI = (JSONObject) item;
                String actionNum = itemI.getString("actionNum");
                String stayTime = itemI.getString("stayTime");
                String type = itemI.getString("type");

                String screenType = itemI.getString("screenType");
                String speed = itemI.getString("speed");
                String start = itemI.getString("start");
                String end = itemI.getString("end");
                String name = itemI.getString("name");
                String fileType = itemI.getString("fileType");
                String red = itemI.getString("red");
                String green = itemI.getString("green");
                String blue = itemI.getString("blue");
                String amber = itemI.getString("amber");
                String bgRed = itemI.getString("bgRed");
                String bgGreen = itemI.getString("bgGreen");
                String bgBlue = itemI.getString("bgBlue");
                String bgAmber = itemI.getString("bgAmber");
                String space = itemI.getString("space");
                String font = itemI.getString("font");
                String width = itemI.getString("width");
                String high = itemI.getString("high");
            /*String cLib = params.getString("cLib");
            String aLib = params.getString("aLib");*/
                Boolean warp = itemI.getBooleanValue("warp");
                String times = itemI.getString("times");
                String locationX = itemI.getString("locationX");
                String locationY = itemI.getString("locationY");
                String locationZ = itemI.getString("locationZ");
                String content = itemI.getString("content");

                StringBuffer itemStr = new StringBuffer();

                if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
                    if (warp) {
                        // yyy+hh
                    } else {
                        itemStr.append("\\C" + start + end);
                    }
                } else {
                    itemStr.append("\\C000000");
                }
                if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(fileType)) {
                    if (StringUtils.equals(fileType, "bmp")) {
                        itemStr.append("\\B" + name);
                    }
                    if (StringUtils.equals(fileType, "png")) {
                        itemStr.append("\\P" + name);
                    }
                    if (StringUtils.equals(fileType, "jpg")) {
                        itemStr.append("\\J" + name);
                    }
                    if (StringUtils.equals(fileType, "gif")) {
                        itemStr.append("\\G" + name);
                    }
                }
                if (StringUtils.isNotBlank(font) && StringUtils.isNotBlank(width) && StringUtils.isNotBlank(high)) {
                    itemStr.append("\\F" + font + high + width);
                }

                if (StringUtils.isNotBlank(red) && StringUtils.isNotBlank(green) && StringUtils.isNotBlank(blue) && StringUtils.isNotBlank(amber)) {
                    itemStr.append("\\T" + red + green + blue + amber);
                } /*else {
                    itemStr.append("\\T255255000000");
                }*/

                if (StringUtils.isNotBlank(bgRed) && StringUtils.isNotBlank(bgGreen) && StringUtils.isNotBlank(bgBlue) && StringUtils.isNotBlank(bgAmber)) {
                    itemStr.append("\\K" + bgRed + bgGreen + bgBlue + bgAmber);
                } /*else {
                    itemStr.append("\\K000000000000");
                }*/
                if (StringUtils.isNotBlank(space)) {
                    itemStr.append("\\M" + space);
                } /*else {
                    itemStr.append("\\M00");
                }*/

                if (StringUtils.isNotBlank(times)) {
                    itemStr.append("\\N" + times);
                }

                if (StringUtils.isNotBlank(locationX) && StringUtils.isNotBlank(locationY) && StringUtils.isNotBlank(locationZ)) {
                    itemStr.append("\\R" + locationX + locationY + locationZ);
                }

                if (StringUtils.isNotBlank(content)) {
                    if (content.contains("\\")) {
                        content.replace("\\", "\\\\");
                    }
                    itemStr.append("\\W" + content);
                }

                StringBuffer itemNo = new StringBuffer();
                itemNo.append("ITEM").append(actionNum).append("=")
                        .append(stayTime).append(",")
                        .append("0").append(",")
                        .append("0").append(",")
                        .append("0").append(",")
                        .append("0").append(",")
                        .append(itemStr.toString());
                if (size > 0) {
                    itemStrs.append(itemNo.toString() + "\r\n");
                } else {
                    itemStrs.append(itemNo.toString());
                }
            }
            byte instruct0 = 0x37;
            byte instruct1 = 0x31;
            // 15=指令长+文件偏移地址;10=播放列表长
            byte[] data = new byte[116 + 15 + 10];
            int pos = 0;
            data[0] = InstructionInfo.des0;
            data[1] = InstructionInfo.des1;
            data[2] = InstructionInfo.src0;
            data[3] = InstructionInfo.src1;
            data[4] = instruct0;
            data[5] = instruct1;
            data[6] = 0x2B;
            data[7] = 0x30;
            data[8] = 0x30;
            data[9] = 0x30;
            data[10] = 0x30;
            data[11] = 0x30;
            data[12] = 0x30;
            data[13] = 0x30;
            data[14] = 0x30;
            String playList = params.getString("playList");
            byte[] playListBytes = new byte[10];
            char[] playListChars = playList.toCharArray();
            for (int j = 0; j < playListChars.length; j++) {
                playListBytes[j] = (byte) playListChars[j];
            }
            System.arraycopy(playListBytes, 0, data, 15, 10);
            // 处理字符
            byte[] temp = itemStrs.toString().getBytes("GBK");
            int itemLen = temp.length;
            System.arraycopy(temp, 0, data, 25, itemLen);
            byte[] crcByte = SerialUtil.caluCRC(data);
            byte[] bytes = new byte[116+19+10];
            bytes[0] = InstructionInfo.header;
            System.arraycopy(data, 0, bytes, 1, data.length);
            bytes[26 + temp.length] = crcByte[0];
            bytes[26 + temp.length + 1] = crcByte[1];
            bytes[26 + temp.length + 2] = InstructionInfo.tail;
            outputStream.write(bytes);
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
