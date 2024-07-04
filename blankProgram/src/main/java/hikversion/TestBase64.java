package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * @author:jinyandong
 * @description:测试base64处理数据
 * @Date:2023/10/24
 */
public class TestBase64 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String str = "我要测试Base64";
        // byte[] decode = Base64.getDecoder().decode(str);

        byte[] encode = Base64.getEncoder().encode(str.getBytes());
        String temp = new String(encode);
        System.out.println(temp);
        byte[] decode = Base64.getDecoder().decode(temp);
        System.out.println(new String(decode));*/
        /*String orgin = "安全高于一切 责任重于泰山";
        String fileDetail = Base64.getEncoder().encodeToString(orgin.getBytes("GBK"));*/
        // String str = "W3BsYXlsaXN0XQppdGVtX25vPTMKaXRlbTA9MzAwLDEsMSxcQzAwMDAwMFxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMMm9uqPT0MfpXEMwMDAwMzJcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDDM7MHJtdjE/gppdGVtMT0zMDAsMSwxLFxDMDAwMDAwXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0/bT0MqpuaRcQzAwMDAzMlxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMNei0uKx3MjDCml0ZW0yPTMwMCwxLDEsXEMwMDAwMDBcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDDAptT6wM65zFxDMDAwMDMyXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0c+9+9LFyPYK";
        String fileInfo = "dmVyc2lvbj0wNy4yNy4wMC4wMDk0Cg==";
        //String sss = new String(str.getBytes(),"GBK");
        byte[] decode = Base64.getDecoder().decode(fileInfo);
        String temp = new String(decode, "GBK");
        System.out.println(temp);

        /*// 测试处理字节流转换成播放列表实体类
        int item_no = temp.indexOf("ITEM000");
        String itemInfoStr = temp.substring(item_no);

        String[] itemStr = itemInfoStr.split("ITEM*");
        List<ItemInfo> itemInfoList = new ArrayList<>();
        for (String itemTemp : itemStr) {
            ItemInfo itemInfo = new ItemInfo();
            // 每个是一条动作
            if (StringUtils.isEmpty(itemTemp)) {
                continue;
            }
            String stayTimeStr = itemTemp.substring(itemTemp.indexOf("=") + 1);
            int stayTimeIndex = stayTimeStr.indexOf(",");
            // 处理停留时间
            String stayTimeSub = stayTimeStr.substring(0, stayTimeIndex);
            itemInfo.setStayTime(Integer.valueOf(stayTimeSub.replaceFirst("^0*", "")));

            String enterTypeStr = stayTimeStr.substring(stayTimeIndex + 1);
            int enterTypeIndex = enterTypeStr.indexOf(",");
            // 处理入屏
            String enterTypeSub = enterTypeStr.substring(0, enterTypeIndex);
            itemInfo.setEnterType(enterTypeSub);


            String stayTypeStr = enterTypeStr.substring(enterTypeIndex + 1);
            int stayTypeIndex = stayTypeStr.indexOf(",");


            String outTypeStr = stayTypeStr.substring(stayTypeIndex + 1);
            int outTypeIndex = outTypeStr.indexOf(",");
            // 处理出屏
            String outTypeSub = outTypeStr.substring(0, outTypeIndex);
            itemInfo.setOutType(outTypeSub);


            String speedStr = outTypeStr.substring(outTypeIndex + 1);
            int speedIndex = speedStr.indexOf(",");
            // 处理停留时间
            String speedSub = outTypeStr.substring(0, speedIndex);
            itemInfo.setSpeed(Integer.valueOf(speedSub));

            String textInfo = speedStr.substring(speedIndex+1);

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
                if (s.contains("\\W")) {
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
                        if (texType.startsWith("T")) {
                            content.setRed(Integer.valueOf(texType.substring(1, 4)));
                            content.setGreen(Integer.valueOf(texType.substring(4, 7)));
                            content.setBlue(Integer.valueOf(texType.substring(7, 10)));
                            content.setAmber(Integer.valueOf(texType.substring(10, 13)));
                        } else if (texType.startsWith("K")) {
                            content.setBgRed(Integer.valueOf(texType.substring(1, 4)));
                            content.setBgGreen(Integer.valueOf(texType.substring(4, 7)));
                            content.setBgBlue(Integer.valueOf(texType.substring(7, 10)));
                            content.setBgAmber(Integer.valueOf(texType.substring(10, 13)));
                        } else if (texType.startsWith("M")) {
                            content.setSpace(Integer.valueOf(texType.substring(1, 3)));
                        } else if (texType.startsWith("F")) {
                            String fontTemp = texType.substring(1, 2);
                            content.setFont(fontTemp);
                            content.setHigh(Integer.valueOf(texType.substring(2, 4)));
                            content.setWidth(Integer.valueOf(texType.substring(4, 6)));
                        } else if (texType.startsWith("N")) {
                            content.setFlashTimes(Integer.valueOf(texType.substring(1, 3)));
                        } else if (texType.startsWith("R")) {
                            content.setFlashAreaLeft(Integer.valueOf(texType.substring(1, 4)));
                            content.setFlashAreaDown(Integer.valueOf(texType.substring(4, 7)));
                            content.setFlashAreaRight(Integer.valueOf(texType.substring(7, 10)));
                            content.setFlashAreaDown(Integer.valueOf(texType.substring(7, 10)));
                        } else if (texType.startsWith("W")) {
                            String text = texType.substring(1);
                            if (text.contains(onlyReplace)) {
                                text = text.replace(onlyReplace, "\\");
                            }
                            content.setContent(text);
                        } else if (texType.startsWith("A")) {
                            content.setWarp(true);
                        } else if (s.contains("\\")) {

                        }
                    }
                    contents.add(content);
                } else {
                    // 图片
                    PicInfo picInfo = new PicInfo();
                    String[] picTypeArr = s.split("\\\\");
                    picInfo.setStart(start);
                    picInfo.setEnd(end);
                    for (String picType : picTypeArr) {
                        if (picType.startsWith("B")) {
                            picInfo.setFileType("bmp");
                            picInfo.setName(picType.substring(1, 4));
                        } else if (picType.startsWith("P")) {
                            picInfo.setFileType("png");
                            picInfo.setName(picType.substring(1, 4));
                        } else if (picType.startsWith("J")) {
                            picInfo.setFileType("jpg");
                            picInfo.setName(picType.substring(1, 4));
                        } else if (picType.startsWith("G")) {
                            picInfo.setFileType("gif");
                            picInfo.setName(picType.substring(1, 4));
                        }
                    }
                    picInfos.add(picInfo);
                }
            }
            itemInfo.setContentList(contents);
            itemInfo.setPicList(picInfos);
            itemInfoList.add(itemInfo);
        }

        System.out.println(JSONObject.toJSONString(itemInfoList));*/
    }
}
