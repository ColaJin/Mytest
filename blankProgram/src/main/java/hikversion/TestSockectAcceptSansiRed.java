package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author:jinyandong
 * @description:测试Socket连接
 * @Date:2023/7/18
 */
public class TestSockectAcceptSansiRed {

    public static String getContentInfo(String texType, int len) {
        String tempContent = "";
        int typeLen = texType.length();
        if (typeLen > len) {
            // 此时的content接在该样式后
            tempContent = texType.substring(len);
        }
        return tempContent;
    }

    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        try {
            // 1、初始化客户端
            socket = new Socket("10.15.66.29", 60000);

            // 2、发送数据到服务端
            inputStream = socket.getInputStream();

            byte[] bytesDataReturn = dealReturnData(inputStream, "methodPlayListContent", 3);

            ItemInfo itemInfo = new ItemInfo();
            String temp = new String(bytesDataReturn, "GBK");
            String no = temp.substring(0, 3);
                /*if (StringUtils.equals(no, "000")) {
                    logger.info(HikLog.toLog("methodPlayListContent is clearing screen"));
                    itemInfo.setNumber(0);
                    outputData.put("data", JSONObject.toJSONString(itemInfo));
                    outputData.put("code", 0);
                    return iRet;
                }*/
            itemInfo.setNumber(Integer.valueOf(no));
            String stayTimeSub = temp.substring(3, 8);
            itemInfo.setStayTime(Integer.valueOf(stayTimeSub.replaceFirst("^0*", "")));
            String typeStr = temp.substring(8, 10);
            // itemInfo.setOutWordType(typeStr);
            System.out.println("setOutWordType" + typeStr);
            String speedStr = temp.substring(10, 15);
            itemInfo.setSpeed(Integer.valueOf(speedStr));

            // 截取文本及其样式区域
            String textInfo = temp.substring(15);
            List<Content> contents = new ArrayList<>();
            List<PicInfo> picInfos = new ArrayList<>();
            String[] textInfoArr = textInfo.split("\\\\C");
            for (String s : textInfoArr) {
                if (StringUtils.equals("", s)) {
                    continue;
                }
                Integer start = Integer.valueOf(s.substring(0, 3));
                Integer end = Integer.valueOf(s.substring(3, 6));
                s = s.substring(7);
                if (!s.contains("\\B")) {
                    Content content = new Content();
                    content.setStart(start);
                    content.setEnd(end);
                    UUID uuid = UUID.randomUUID();
                    String str = uuid.toString();
                    String onlyReplace = str.replace("-", "");
                    if (s.contains("\\\\")) {
                        s = s.replace("\\\\", onlyReplace);
                    }
                    String[] textTypeArr = s.split("\\\\");
                    for (String texType : textTypeArr) {
                        if (texType.startsWith("c")) {
                            if (texType.contains("t")) {
                                //content.setFontTransparent(true);
                                System.out.println("setFontTransparent");
                            } else {
                                content.setRed(Integer.valueOf(texType.substring(1, 4)));
                                content.setGreen(Integer.valueOf(texType.substring(4, 7)));
                                content.setBlue(Integer.valueOf(texType.substring(7, 10)));
                                content.setAmber(Integer.valueOf(texType.substring(10, 13)));
                            }
                            String contentInfo = getContentInfo(texType, 13);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("b")) {
                            if (texType.contains("t")) {
                                // content.setBgTransparent(true);
                                System.out.println("setBgTransparent");
                            } else {
                                content.setBgRed(Integer.valueOf(texType.substring(1, 4)));
                                content.setBgGreen(Integer.valueOf(texType.substring(4, 7)));
                                content.setBgBlue(Integer.valueOf(texType.substring(7, 10)));
                                content.setBgAmber(Integer.valueOf(texType.substring(10, 13)));
                            }
                            String contentInfo = getContentInfo(texType, 13);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("s")) {
                            if (texType.contains("t")) {
                                // content.setShadowTransparent(true);
                                System.out.println("setShadowTransparent");
                            } else {
                                System.out.println("setShadowRed" + Integer.valueOf(texType.substring(1, 4)));
                                System.out.println("setShadowGreen" + Integer.valueOf(texType.substring(4, 7)));
                                System.out.println("setShadowBlue" + Integer.valueOf(texType.substring(7, 10)));
                                System.out.println("setShadowAmber" + Integer.valueOf(texType.substring(10, 13)));
                            }
                            String contentInfo = getContentInfo(texType, 13);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("S")) {
                            content.setSpace(Integer.valueOf(texType.substring(1, 3)));
                            String contentInfo = getContentInfo(texType, 3);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("f")) {
                            String fontTemp = texType.substring(1, 2);
                            content.setFont(fontTemp);
                            content.setHigh(Integer.valueOf(texType.substring(2, 4)));
                            content.setWidth(Integer.valueOf(texType.substring(4, 6)));
                            String contentInfo = getContentInfo(texType, 6);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("N")) {
                            content.setFlashTimes(Integer.valueOf(texType.substring(1, 3)));
                            String contentInfo = getContentInfo(texType, 3);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("r")) {
                            content.setFlashAreaLeft(Integer.valueOf(texType.substring(1, 4)));
                            content.setFlashAreaDown(Integer.valueOf(texType.substring(4, 7)));
                            content.setFlashAreaRight(Integer.valueOf(texType.substring(7, 10)));
                            content.setFlashAreaDown(Integer.valueOf(texType.substring(7, 10)));
                            String contentInfo = getContentInfo(texType, 10);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("n")) {
                            content.setWarp(true);
                            String contentInfo = getContentInfo(texType, 1);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        }
                    }
                    contents.add(content);
                } else {
                    // 图片
                    PicInfo picInfo = new PicInfo();
                    String[] picTypeArr = s.split("\\\\");
                    picInfo.setStart(start);
                    picInfo.setEnd(end);
                    /*for (String picType : picTypeArr) {
                        if (picType.startsWith("B")) {
                            picInfo.setFileType("bmp");
                            picInfo.setName(picType.substring(1, 4));
                        }
                        if (picType.startsWith("y")) {
                            picInfo.setYellowOrg(true);
                        }
                    }*/
                    picInfos.add(picInfo);
                }
            }
            itemInfo.setContentList(contents);
            itemInfo.setPicList(picInfos);

            System.out.println(JSONObject.toJSONString(itemInfo));
            // 5、读取字节信息
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
        int readLength = 1024;
        byte[] valiMsg = null;
        int readed = 0;
        //IO读取
        byte[] bufData = new byte[readLength];
        if ((readed = inputStream.read(bufData)) > 0) {
            valiMsg = new byte[readed];
        }
        System.arraycopy(bufData, 0, valiMsg, 0, readed);
        System.out.println("readed" + readed);

        // 遍历valiMsg然后处理转义数据
        byte[] transData = new byte[readed];
        int i = 0;
        boolean isCrc = false;
        for (byte b : valiMsg) {
            if (b == (byte) 0x1b) {
                isCrc = true;
                continue;
            } else {
                if (isCrc) {
                    if (b == (byte) 0xe8) {
                        transData[i] = (byte) 0x03;
                    } else if (b == (byte) 0xe7) {
                        transData[i] = (byte) 0x02;
                    } else if (b == (byte) 0x00) {
                        transData[i] = (byte) 0x1B;
                    }
                    isCrc = false;
                } else {
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
        System.out.println(new String(bytesDataReturnC));
        // 4、校验CRC
        byte[] crcByteReturn = SerialUtil.caluCRC(bytesDataReturnC);
        if ((crcByteReturn[0] != rsTransData[i - 1 - 2]) || (crcByteReturn[1] != rsTransData[i - 1 - 1])) {
            String s = Integer.toHexString(crcByteReturn[0]) + Integer.toHexString(crcByteReturn[1]);
            String s2 = Integer.toHexString(rsTransData[i - 1 - 2]) + Integer.toHexString(rsTransData[i - 1 - 1]);
            String bufDataS = new String(bufData, "GBK");
            System.out.println("crc error");
            // 校验失败
            return new byte[0];
        }
        byte[] bytesDataReturn = new byte[i - 4 - 2];
        // 处理数据
        System.arraycopy(rsTransData, startPos, bytesDataReturn, 0, i - 4 - 2);
        return bytesDataReturn;
    }
}
