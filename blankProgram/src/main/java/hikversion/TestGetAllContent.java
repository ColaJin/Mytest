package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author:jinyandong
 * @description:测试返回结果处理
 * @Date:2023/11/28
 */
public class TestGetAllContent {
    public static void main(String[] args) {
        /*String temp = "[PLAYLIST]\n" +
                "ITEM_NO=001\n" +
                "ITEM000=3,0,0,0,0,\\C000034\\T255255000000\\K000000000000\\M00\\Fs3232\\N00\\R000000000000\\W限速\\C016066\\T255255000000\\K000000000000\\M00\\Fs3232\\N00\\R000000000000\\W80";*/
        String temp = "[PLAYLIST]\r\n" +
                "ITEM_NO=025\r\n" +
                "ITEM000=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM001=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\r\n" +
                "ITEM002=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM003=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM004=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM005=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM006=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM007=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM008=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM009=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM010=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM011=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\r\n" +
                "ITEM012=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM013=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM014=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM015=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM016=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM017=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM018=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM019=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM020=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM021=70,0,0,0,0,\\C000000\\Fs3232\\T255255000000\\K255000255000\\M00\\W犯我中华\\C000032\\W虽远必诛\r\n" +
                "ITEM022=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM023=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!\r\n" +
                "ITEM024=30,0,0,0,0,\\C000017\\B000\\C032000\\Fs3232\\T255000000000\\K000255000000\\WHello \\C032032\\Fs3232\\T255000000000\\K000255000000\\WWorld!";
        List<ItemInfo> itemInfoList = dealPlaylistFile(temp);
        System.out.println(JSONObject.toJSONString(itemInfoList));
        boolean jsonString = isJsonString(itemInfoList.toString());
        //System.out.println(jsonString);

        /*for (ItemInfo itemInfo : itemInfoList) {
            System.out.println(JSONObject.toJSONString(itemInfo));
        }*/
    }

    public static boolean isJsonString(String str){
        String jsonPattern = "^(\\{|\\[)(\".*?\"\\s*:\\s*(\".*?\"|\\[\\s*\\]|\\{.*?\\}|\\d+)(,\\s*\".*?\"\\s*:\\s*(\".*?\"|\\[\\s*\\]|\\{.*?\\}|\\d+))*\\s*)?(\\}|\\])$";
        return Pattern.matches(jsonPattern,str);
    }

    public static List<ItemInfo> dealPlaylistFile(String temp) {
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
                            text = text.replace("\r\n","");
                            text = text.replace("\n","");
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
        return itemInfoList;
    }

}
