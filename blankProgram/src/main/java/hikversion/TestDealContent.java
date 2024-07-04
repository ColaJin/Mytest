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
public class TestDealContent {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String temp = "0000003000000000\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛";
        System.out.println(temp);

        ItemInfo itemInfo = new ItemInfo();
        String no = temp.substring(0, 3);
        itemInfo.setNumber(Integer.valueOf(no));
        String stayTimeSub = temp.substring(3, 8);
        itemInfo.setStayTime(Integer.valueOf(stayTimeSub.replaceFirst("^0*", "")));
        String typeStr = temp.substring(8, 10);
        itemInfo.setEnterType(typeStr);
        //itemInfo.setStayType(temp.substring(10, 12));
        String outTypeStr = temp.substring(12, 14);
        itemInfo.setOutType(outTypeStr);
        String speedStr = temp.substring(14, 16);
        itemInfo.setSpeed(Integer.valueOf(speedStr));
        if (temp.length() < 17){
            System.out.println("error length");
        }
        // 截取文本及其样式区域
        String textInfo = temp.substring(16);
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
            if (s.contains("W")) {
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

        System.out.println(JSONObject.toJSONString(itemInfo));
    }
}
