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
public class TestBase64Sansi {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String fileInfo = "W3BsYXlsaXN0XQppdGVtX25vPTIKaXRlbTA9MzAwLDEsMSxcQzAwMDAwMFxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMLGjs9aztb7gXEMwMDAwMzJcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDC998n3vN3KuwppdGVtMT0zMDAsMSwxLFxDMDAwMDAwXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0c+9+9W808NcQzAwMDAzMlxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMNOmvLGztbXACg==";
        //String sss = new String(str.getBytes(),"GBK");
        byte[] decode = Base64.getDecoder().decode(fileInfo);
        String temp = new String(decode, "GBK");
        System.out.println(temp);

        // 测试处理字节流转换成播放列表实体类
        int item_no = temp.indexOf("item0");
        String itemInfoStr = temp.substring(item_no);

        String[] itemStr = itemInfoStr.split("item*");
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

            String outWordTypeStr = stayTimeStr.substring(stayTimeIndex + 1);
            int outWordTypeIndex = outWordTypeStr.indexOf(",");

            String speedStr = outWordTypeStr.substring(outWordTypeIndex + 1);
            int speedIndex = speedStr.indexOf(",");
            // 处理停留时间
            String speedSub = outWordTypeStr.substring(0, speedIndex);
            itemInfo.setSpeed(Integer.valueOf(speedSub));

            String textInfo = speedStr.substring(speedIndex + 1);

            List<Content> contents = new ArrayList<>();
            List<PicInfo> picInfos = new ArrayList<>();
            String[] textInfoArr = textInfo.split("\\\\C");
            for (String s : textInfoArr) {
                if (StringUtils.equals("", s)) {
                    continue;
                }
                Integer start = Integer.valueOf(s.substring(0, 3));
                Integer end = Integer.valueOf(s.substring(3, 6));
                s = s.substring(6);
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
                        if (StringUtils.equals("", texType)) {
                            continue;
                        }
                        if (texType.startsWith("c")) {
                            if (texType.startsWith("ct")) {
                                System.out.println("isct");
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
                            if (texType.startsWith("bt")) {
                                System.out.println("isbt");
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
                        } else if (texType.startsWith("S")) {
                            content.setSpace(Integer.valueOf(texType.substring(1, 3)));
                            String contentInfo = getContentInfo(texType, 13);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("f")) {
                            String fontTemp = texType.substring(1, 2);
                            content.setFont(fontTemp);
                            content.setHigh(Integer.valueOf(texType.substring(2, 4)));
                            content.setWidth(Integer.valueOf(texType.substring(4, 6)));
                            String contentInfo = getContentInfo(texType, 13);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else if (texType.startsWith("n")) {
                            content.setWarp(true);
                            String contentInfo = getContentInfo(texType, 13);
                            if (!StringUtils.isEmpty(contentInfo)) {
                                content.setContent(contentInfo);
                            }
                        } else {
                            String text = texType.substring(1);
                            if (text.contains(onlyReplace)) {
                                text = text.replace(onlyReplace, "\\");
                            }
                            content.setContent(text);
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
                        }
                    }
                    picInfos.add(picInfo);
                }
            }
            itemInfo.setContentList(contents);
            itemInfo.setPicList(picInfos);
            itemInfoList.add(itemInfo);
        }

        System.out.println(JSONObject.toJSONString(itemInfoList));
    }

    private static String getContentInfo(String texType, int len) {
        String tempContent = "";
        texType = texType.replace("\n","");
        int typeLen = texType.length();
        if (typeLen > len) {
            // 此时的content接在该样式后
            tempContent = texType.substring(len);
        }
        return tempContent;
    }
}
