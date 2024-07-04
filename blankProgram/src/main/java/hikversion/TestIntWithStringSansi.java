package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * @author:jinyandong
 * @description:测试int类型用String类型处理数据
 * @Date:2023/10/9
 */
public class TestIntWithStringSansi {

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
                "                \"outWordType\":\"00\",\n" +
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
                "                        \"isFontTransparent\":false,\n" +
                "                        \"isBgTransparent\":false,\n" +
                "                        \"isShadowTransparent\":false,\n" +
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
                "                        \"isFontTransparent\":false,\n" +
                "                        \"isBgTransparent\":false,\n" +
                "                        \"isShadowTransparent\":false,\n" +
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
        String filePath = "play.lst";
        if(StringUtils.isEmpty(filePath)){
            System.out.println("fileName param is null");
        }
        // 固定表头
        itemStrs.append("[playlist]"+ "\r\n");
        // 遍历动作条数，拼字符串
        String itemList = params.getString("itemList");
        if(StringUtils.isEmpty(itemList)){
            System.out.println("itemList is null");
        }

        JSONArray itemArray = JSONObject.parseArray(itemList);
        if(itemArray == null){
            System.out.println("itemArray is null");
        }

        int size = itemArray.size();
        String actionCount = "item_no=" + size + "\r\n";
        itemStrs.append(actionCount);
        // 处理每一条动作
        for (Object item : itemArray) {
            size--;
            JSONObject itemI = (JSONObject) item;
            Integer actionNumInt = itemI.getInteger("actionNum");
            String stayTime = itemI.getString("stayTime");
            String outWordType = itemI.getString("outWordType");
            if (StringUtils.equals(outWordType,"00")){
                outWordType = "0";
            }else {
                outWordType = outWordType.replaceFirst("^0*", "");
            }
            String speed = itemI.getString("speed");

            StringBuffer itemStr = new StringBuffer();

            String contentListStr = itemI.getString("contentList");
            JSONArray contentListArr = JSONObject.parseArray(contentListStr);
            for (Object o : contentListArr) {
                JSONObject temp = (JSONObject) o;
                String start = getTriParam(temp.getString("start"));
                String end = getTriParam(temp.getString("end"));

                if ((StringUtils.isNotBlank(start) && start.startsWith("-")) || (StringUtils.isNotBlank(end) && end.startsWith("-"))){
                    System.out.println("文字start或者end坐标范围为0-999");
                }

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
                String content = temp.getString("content");
                if (StringUtils.isNotBlank(start) && StringUtils.isNotBlank(end)) {
                    itemStr.append("\\C" + start + end);
                }
                if (temp.getBoolean("isFontTransparent")){
                    itemStr.append("\\ct");
                }else {
                    if (StringUtils.isNotBlank(red) && StringUtils.isNotBlank(green) && StringUtils.isNotBlank(blue) && StringUtils.isNotBlank(amber)) {
                        itemStr.append("\\T" + red + green + blue + amber);
                    } else {
                        itemStr.append("\\T255255000000");
                    }
                }
                if (temp.getBoolean("isBgTransparent")){
                    itemStr.append("\\bt");
                }else {
                    if (StringUtils.isNotBlank(bgRed) && StringUtils.isNotBlank(bgGreen) && StringUtils.isNotBlank(bgBlue) && StringUtils.isNotBlank(bgAmber)) {
                        itemStr.append("\\b" + bgRed + bgGreen + bgBlue + bgAmber);
                    } else {
                        itemStr.append("\\bt");
                    }
                }
                if (StringUtils.isNotBlank(space)) {
                    itemStr.append("\\S" + space);
                } else {
                    itemStr.append("\\S00");
                }
                if (StringUtils.isNotBlank(font) && StringUtils.isNotBlank(width) && StringUtils.isNotBlank(high)) {
                    itemStr.append("\\f" + font + high + width);
                }

                if (warp) {
                    itemStr.append("\\n");
                }
                if (StringUtils.isNotBlank(content)) {
                    if (content.contains("\\")) {
                        content.replace("\\", "\\\\");
                    }
                    itemStr.append(content);
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
                    if ((StringUtils.isNotBlank(fileStart) && fileStart.startsWith("-")) || (StringUtils.isNotBlank(fileEnd) && fileEnd.startsWith("-"))){
                        System.out.println("图片start或者end坐标范围为0-999");
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
                }
            }

            StringBuffer itemNo = new StringBuffer();
            itemNo.append("item").append(actionNumInt).append("=")
                    .append(stayTime).append(",")
                    .append(outWordType).append(",")
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
