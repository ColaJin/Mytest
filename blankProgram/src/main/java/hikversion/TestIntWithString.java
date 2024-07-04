package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author:jinyandong
 * @description:测试int类型用String类型处理数据
 * @Date:2023/10/9
 */
public class TestIntWithString {

    public static String getTriParam(String param) {
        while (param.length() < 3) {
            StringBuffer sb = new StringBuffer();
            //左补0
            sb.append("0").append(param);
            param = sb.toString();
        }
        return param;
    }


    public static void main(String[] args) {
        /*JSONObject request = JSONObject.parseObject("{\n" +
                "    \"method\":\"PlayList\",\n" +
                "    \"params\":{\n" +
                "        \"indexCode\":\"993a47b85c7349a0b15e1042de2470a6\",\n" +
                "        \"playList\":\"play00.lst\",\n" +
                "        \"actionCount\":1,\n" +
                "        \"itemList\":[\n" +
                "            {\n" +
                "                \"actionNum\":0,\n" +
                "                \"stayTime\":30,\n" +
                "                \"enterType\":\"00\",\n" +
                "                \"outType\":\"00\",\n" +
                "                \"speed\":2,\n" +
                "                \"posPic\":[\n" +
                "                    {\n" +
                "                        \"start\":0,\n" +
                "                        \"end\":0,\n" +
                "                        \"name\":\"nnn\",\n" +
                "                        \"fileType\":\"bmp\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"start\":32,\n" +
                "                        \"end\":0,\n" +
                "                        \"name\":\"nnn\",\n" +
                "                        \"fileType\":\"bmp\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"start\":64,\n" +
                "                \"end\":0,\n" +
                "                \"red\":255,\n" +
                "                \"green\":0,\n" +
                "                \"blue\":0,\n" +
                "                \"amber\":0,\n" +
                "                \"bgRed\":0,\n" +
                "                \"bgGreen\":0,\n" +
                "                \"bgBlue\":0,\n" +
                "                \"bgAmber\":0,\n" +
                "                \"space\":1,\n" +
                "                \"font\":\"n\",\n" +
                "                \"width\":\"16\",\n" +
                "                \"high\":\"16\",\n" +
                "                \"warp\":true,\n" +
                "                \"flashTimes\":3,\n" +
                "                \"flashAreaLeft\":1,\n" +
                "                \"flashAreaRight\":1,\n" +
                "                \"flashAreaUp\":1,\n" +
                "                \"flashAreaDown\":1,\n" +
                "                \"content\":\"Hello World\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}");

        JSONObject params = request.getJSONObject("params");
        // 从请求头中获取indexCode
        String indexCode = params.getString("indexCode");

        StringBuffer itemStrs = new StringBuffer();
        *//*String header = params.getString("header") + "\r\n";
        if(StringUtils.isEmpty(header)){
            result.put("result", "header param is null");
            outputData.put("data", result.toString());
            outputData.put("code", 0);
        }*//*
        // 固定表头
        itemStrs.append("[PLAYLIST]"+ "\r\n");
        String actionCountTemp = params.getString("actionCount");
        Integer actionCountInt = params.getInteger("actionCount");
        String actionCount = "ITEM_NO=" + getTriParam(actionCountTemp) + "\r\n";
        itemStrs.append(actionCount);
        // 遍历动作条数，拼字符串
        String itemList = params.getString("itemList");
        JSONArray itemArray = JSONObject.parseArray(itemList);
        int size = itemArray.size();
        if (actionCountInt != size){
            System.out.println("not equal");
        }
        // 处理每一条动作
        for (Object item : itemArray) {
            size--;
            JSONObject itemI = (JSONObject) item;
            String actionNum = getTriParam(itemI.getString("actionNum"));
            String stayTime = itemI.getString("stayTime");
            String enterType = itemI.getString("enterType");
            if (StringUtils.equals(enterType,"00")){
                enterType = "0";
            }else {
                enterType = enterType.replaceFirst("^0*", "");
            }
            String outType = itemI.getString("outType");
            if (StringUtils.equals(outType,"00")){
                outType = "0";
            }else {
                outType = outType.replaceFirst("^0*", "");
            }
            String speed = itemI.getString("speed");
            String start = getTriParam(itemI.getString("start"));
            String end = getTriParam(itemI.getString("end"));

            *//*String name = itemI.getString("name");
            String fileType = itemI.getString("fileType");*//*
            String red = getTriParam(itemI.getString("red"));
            String green = getTriParam(itemI.getString("green"));
            String blue = getTriParam(itemI.getString("blue"));
            String amber = getTriParam(itemI.getString("amber"));
            String bgRed = getTriParam(itemI.getString("bgRed"));
            String bgGreen = getTriParam(itemI.getString("bgGreen"));
            String bgBlue = getTriParam(itemI.getString("bgBlue"));
            String bgAmber = getTriParam(itemI.getString("bgAmber"));
            String space = itemI.getString("space");
            if (space.length() == 1) {
                space = "0" + speed;//只有一位的前面补个0
            }
            String font = itemI.getString("font");
            String width = itemI.getString("width");
            String high = itemI.getString("high");
            *//*String cLib = params.getString("cLib");
            String aLib = params.getString("aLib");*//*
            Boolean warp = itemI.getBooleanValue("warp");
            String flashTimes = itemI.getString("flashTimes");
            if (flashTimes.length() == 1) {
                flashTimes = "0" + speed;//只有一位的前面补个0
            }
            String flashAreaLeft = getTriParam(itemI.getString("flashAreaLeft"));
            String flashAreaRight = getTriParam(itemI.getString("flashAreaRight"));
            String flashAreaUp = getTriParam(itemI.getString("flashAreaUp"));
            String flashAreaDown = getTriParam(itemI.getString("flashAreaDown"));
            String content = itemI.getString("content");

            StringBuffer itemStr = new StringBuffer();

            String posPicStr =itemI.getString("posPic");
            JSONArray posPic = JSONObject.parseArray(posPicStr);
            if (!CollectionUtils.isEmpty(posPic)) {
                for (Object o : posPic) {
                    JSONObject posPicTemp = (JSONObject) o;
                    String name = posPicTemp.getString("name");
                    String fileType = posPicTemp.getString("fileType");
                    String fileStart = getTriParam(posPicTemp.getString("start"));
                    String fileEnd = getTriParam(posPicTemp.getString("end"));
                    itemStr.append("\\C" + fileStart + fileEnd);
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
                }
            }
            *//*if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(fileType)) {
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
            }*//*

            if (StringUtils.isNotBlank(red) && StringUtils.isNotBlank(green) && StringUtils.isNotBlank(blue) && StringUtils.isNotBlank(amber)) {
                itemStr.append("\\T" + red + green + blue + amber);
            } else {
                itemStr.append("\\T255255000000");
            }

            if (StringUtils.isNotBlank(bgRed) && StringUtils.isNotBlank(bgGreen) && StringUtils.isNotBlank(bgBlue) && StringUtils.isNotBlank(bgAmber)) {
                itemStr.append("\\K" + bgRed + bgGreen + bgBlue + bgAmber);
            } else {
                itemStr.append("\\K000000000000");
            }
            if (StringUtils.isNotBlank(space)) {
                itemStr.append("\\M" + space);
            } else {
                itemStr.append("\\M00");
            }
            if (StringUtils.isNotBlank(font) && StringUtils.isNotBlank(width) && StringUtils.isNotBlank(high)) {
                String temp = "s";
                if (StringUtils.equals(font, "黑体")) {
                    temp = "h";
                } else if (StringUtils.equals(font, "楷体")) {
                    temp = "k";
                } else if (StringUtils.equals(font, "仿宋体")) {
                    temp = "f";
                }
                itemStr.append("\\F" + temp + high + width);
            }
            if (StringUtils.isNotBlank(flashTimes)) {
                itemStr.append("\\N" + flashTimes);
            }

            if (StringUtils.isNotBlank(flashAreaLeft) && StringUtils.isNotBlank(flashAreaRight) && StringUtils.isNotBlank(flashAreaUp) && StringUtils.isNotBlank(flashAreaDown)) {
                itemStr.append("\\R" + flashAreaLeft + flashAreaUp + flashAreaRight + flashAreaDown);
            }

            if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
                if (warp) {
                    itemStr.append("\\A");
                }
                itemStr.append("\\C" + start + end);
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
                    .append(enterType).append(",")
                    .append("0").append(",")
                    .append(outType).append(",")
                    .append(speed).append(",")
                    .append(itemStr.toString());
            if (size > 0) {
                itemStrs.append(itemNo.toString() + "\r\n");
            } else {
                itemStrs.append(itemNo.toString());
            }
        }
        System.out.println(itemStrs);*/
        /*ItemInfo itemInfo = new ItemInfo();
        String temp = "0010003000000001\\C000000\\Fs4848\\M00\\W注意安全";
        itemInfo.setNumber(Integer.valueOf(temp.substring(0, 3)));
        String stayTimeSub = temp.substring(3, 8);
        itemInfo.setStayTime(Integer.valueOf(stayTimeSub.replaceFirst("^0*","")));
        String typeStr = temp.substring(8, 10);
        itemInfo.setEnterType(typeStr);
        //itemInfo.setStayType(temp.substring(10, 12));
        String outTypeStr = temp.substring(12, 14);
        itemInfo.setOutType(outTypeStr);
        String speedStr = temp.substring(14, 16);
        itemInfo.setSpeed(Integer.valueOf(speedStr));
                *//*if (StringUtils.equals(speedStr,"00")){
                    itemInfo.setSpeed(0);
                }else {
                    itemInfo.setSpeed(Integer.valueOf(speedStr.replaceFirst("^0*","")));
                }*//*

        // 截取文本及其样式区域
        String textInfo = temp.substring(16);
        List<Content> contents = new ArrayList<>();
        List<PicInfo> picInfos = new ArrayList<>();
        //String[] textInfoArr = textInfo.split("\\\\");
        String[] textInfoArr = textInfo.split("\\\\C");
        for (String s : textInfoArr) {
            if (StringUtils.equals("",s)){
                continue;
            }
            Integer start = Integer.valueOf(s.substring(0, 3));
            Integer end = Integer.valueOf(s.substring(3,6));
            s= s.substring(7);
            if (s.contains("\\W")){
                Content content = new Content();
                content.setStart(start);
                content.setEnd(end);
                UUID uuid = UUID.randomUUID();
                String str = uuid.toString();
                String onlyReplace = str.replace("-", "");
                if (s.contains("\\\\")){
                    s = s.replace("\\\\",onlyReplace);
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
                    }else if (texType.startsWith("W")) {
                        String text = texType.substring(1);
                        if (text.contains(onlyReplace)){
                            text = text.replace(onlyReplace,"\\");
                        }
                        content.setContent(text);
                    }else if (texType.startsWith("A")) {
                        content.setWarp(true);
                    }else if (s.contains("\\")){

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
        System.out.println(JSONObject.toJSONString(itemInfo));*/

        JSONObject request = JSONObject.parseObject("{\n" +
                "    \"method\":\"PlayList\",\n" +
                "    \"params\":{\n" +
                "        \"indexCode\":\"993a47b85c7349a0b15e1042de2470a6\",\n" +
                "        \"fileName\":\"play00.lst\",\n" +
                "        \"actionCount\":1,\n" +
                "        \"itemList\":[\n" +
                "            {\n" +
                "                \"actionNum\":0,\n" +
                "                \"stayTime\":30,\n" +
                "                \"enterType\":\"00\",\n" +
                "                \"outType\":\"00\",\n" +
                "                \"speed\":1,\n" +
                "                \"contentList\":[\n" +
                "                    {\n" +
                "                        \"amber\":0,\n" +
                "                        \"bgAmber\":0,\n" +
                "                        \"bgBlue\":0,\n" +
                "                        \"bgGreen\":0,\n" +
                "                        \"bgRed\":0,\n" +
                "                        \"blue\":0,\n" +
                "                        \"content\":\"注意安全\",\n" +
                "                        \"end\":0,\n" +
                "                        \"flashAreaDown\":0,\n" +
                "                        \"flashAreaLeft\":0,\n" +
                "                        \"flashAreaRight\":0,\n" +
                "                        \"flashAreaUp\":0,\n" +
                "                        \"flashTimes\":0,\n" +
                "                        \"font\":\"s\",\n" +
                "                        \"green\":0,\n" +
                "                        \"high\":48,\n" +
                "                        \"red\":0,\n" +
                "                        \"space\":0,\n" +
                "                        \"start\":0,\n" +
                "                        \"warp\":false,\n" +
                "                        \"width\":48\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"amber\":0,\n" +
                "                        \"bgAmber\":0,\n" +
                "                        \"bgBlue\":0,\n" +
                "                        \"bgGreen\":0,\n" +
                "                        \"bgRed\":0,\n" +
                "                        \"blue\":0,\n" +
                "                        \"content\":\"保持车距\",\n" +
                "                        \"end\":48,\n" +
                "                        \"flashAreaDown\":0,\n" +
                "                        \"flashAreaLeft\":0,\n" +
                "                        \"flashAreaRight\":0,\n" +
                "                        \"flashAreaUp\":0,\n" +
                "                        \"flashTimes\":0,\n" +
                "                        \"font\":\"s\",\n" +
                "                        \"green\":255,\n" +
                "                        \"high\":48,\n" +
                "                        \"red\":255,\n" +
                "                        \"space\":0,\n" +
                "                        \"start\":0,\n" +
                "                        \"warp\":false,\n" +
                "                        \"width\":48\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"number\":1,\n" +
                "                \"picInfos\":[\n" +
                "\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}");

        JSONObject params = request.getJSONObject("params");

        // 从请求头中获取indexCode
        String indexCode = params.getString("indexCode");

        StringBuffer itemStrs = new StringBuffer();
        /*String header = params.getString("header") + "\r\n";
        if(StringUtils.isEmpty(header)){
            result.put("result", "header param is null");
            outputData.put("data", result.toString());
            outputData.put("code", 0);
        }*/
        // 固定表头
        itemStrs.append("[PLAYLIST]"+ "\r\n");
        String actionCountTemp = params.getString("actionCount");
        Integer actionCountInt = params.getInteger("actionCount");
        String actionCount = "ITEM_NO=" + getTriParam(actionCountTemp) + "\r\n";
        itemStrs.append(actionCount);
        // 遍历动作条数，拼字符串
        String itemList = params.getString("itemList");
        if(StringUtils.isEmpty(itemList)){
        }
        JSONArray itemArray = JSONObject.parseArray(itemList);
        if(itemArray == null){
            System.out.println("nul;l");
        }
        String fileName = params.getString("fileName");
        if(StringUtils.isEmpty(fileName)){
            System.out.println("nulllllll");
        }
        int size = itemArray.size();
        if (actionCountInt != size){
            System.out.println("not ");
        }
        // 处理每一条动作
        for (Object item : itemArray) {
            size--;
            JSONObject itemI = (JSONObject) item;
            String actionNum = getTriParam(itemI.getString("actionNum"));
            String stayTime = itemI.getString("stayTime");
            String enterType = itemI.getString("enterType");
            if (StringUtils.equals(enterType,"00")){
                enterType = "0";
            }else {
                enterType = enterType.replaceFirst("^0*", "");
            }
            String outType = itemI.getString("outType");
            if (StringUtils.equals(outType,"00")){
                outType = "0";
            }else {
                outType = outType.replaceFirst("^0*", "");
            }
            String speed = itemI.getString("speed");

            StringBuffer itemStr = new StringBuffer();

            String contentListStr =itemI.getString("contentList");
            JSONArray contentListArr = JSONObject.parseArray(contentListStr);
            for (Object o : contentListArr) {
                JSONObject temp = (JSONObject) o;
                String start = getTriParam(temp.getString("start"));
                String end = getTriParam(temp.getString("end"));

                String red = getTriParam(temp.getString("red"));
                String green = getTriParam(temp.getString("green"));
                String blue = getTriParam(temp.getString("blue"));
                String amber = getTriParam(temp.getString("amber"));
                String bgRed = getTriParam(temp.getString("bgRed"));
                String bgGreen = getTriParam(temp.getString("bgGreen"));
                String bgBlue = getTriParam(temp.getString("bgBlue"));
                String bgAmber = getTriParam(temp.getString("bgAmber"));
                String space = temp.getString("space");
                if (space.length() == 1) {
                    space = "0" + speed;//只有一位的前面补个0
                }
                String font = temp.getString("font");
                String width = temp.getString("width");
                String high = temp.getString("high");
                Boolean warp = temp.getBooleanValue("warp");
                String flashTimes = temp.getString("flashTimes");
                if (flashTimes.length() == 1) {
                    flashTimes = "0" + speed;//只有一位的前面补个0
                }
                String flashAreaLeft = getTriParam(temp.getString("flashAreaLeft"));
                String flashAreaRight = getTriParam(temp.getString("flashAreaRight"));
                String flashAreaUp = getTriParam(temp.getString("flashAreaUp"));
                String flashAreaDown = getTriParam(temp.getString("flashAreaDown"));
                String content = temp.getString("content");
                if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
                    itemStr.append("\\C" + start + end);
                }
                if (StringUtils.isNotBlank(red) && StringUtils.isNotBlank(green) && StringUtils.isNotBlank(blue) && StringUtils.isNotBlank(amber)) {
                    itemStr.append("\\T" + red + green + blue + amber);
                } else {
                    itemStr.append("\\T255255000000");
                }

                if (StringUtils.isNotBlank(bgRed) && StringUtils.isNotBlank(bgGreen) && StringUtils.isNotBlank(bgBlue) && StringUtils.isNotBlank(bgAmber)) {
                    itemStr.append("\\K" + bgRed + bgGreen + bgBlue + bgAmber);
                } else {
                    itemStr.append("\\K000000000000");
                }
                if (StringUtils.isNotBlank(space)) {
                    itemStr.append("\\M" + space);
                } else {
                    itemStr.append("\\M00");
                }
                if (StringUtils.isNotBlank(font) && StringUtils.isNotBlank(width) && StringUtils.isNotBlank(high)) {
                    itemStr.append("\\F" + font + high + width);
                }
                if (StringUtils.isNotBlank(flashTimes)) {
                    itemStr.append("\\N" + flashTimes);
                }

                if (StringUtils.isNotBlank(flashAreaLeft) && StringUtils.isNotBlank(flashAreaRight) && StringUtils.isNotBlank(flashAreaUp) && StringUtils.isNotBlank(flashAreaDown)) {
                    itemStr.append("\\R" + flashAreaLeft + flashAreaUp + flashAreaRight + flashAreaDown);
                }


                if (warp) {
                    itemStr.append("\\A");
                }
                if (StringUtils.isNotBlank(content)) {
                    if (content.contains("\\")) {
                        content.replace("\\", "\\\\");
                    }
                    itemStr.append("\\W" + content);
                }
            }



            String posPicStr =itemI.getString("posPic");
            JSONArray posPic = JSONObject.parseArray(posPicStr);
            if (!CollectionUtils.isEmpty(posPic)) {
                for (Object o : posPic) {
                    JSONObject posPicTemp = (JSONObject) o;
                    String name = posPicTemp.getString("name");
                    String fileType = posPicTemp.getString("fileType");
                    String fileStart = getTriParam(posPicTemp.getString("start"));
                    String fileEnd = getTriParam(posPicTemp.getString("end"));
                    itemStr.append("\\C" + fileStart + fileEnd);
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
                }
            }
            /*if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(fileType)) {
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
            }*/

            StringBuffer itemNo = new StringBuffer();
            itemNo.append("ITEM").append(actionNum).append("=")
                    .append(stayTime).append(",")
                    .append(enterType).append(",")
                    .append("0").append(",")
                    .append(outType).append(",")
                    .append(speed).append(",")
                    .append(itemStr.toString());
            if (size > 0) {
                itemStrs.append(itemNo.toString() + "\r\n");
            } else {
                itemStrs.append(itemNo.toString());
            }
        }

        System.out.println(itemStrs);
    }

}
