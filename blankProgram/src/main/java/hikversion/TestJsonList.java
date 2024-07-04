package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:
 * @Date:2023/9/19
 */
public class TestJsonList {
    public static void main(String[] args) {
        List<Box> boxInfo = new ArrayList<>();
        Box box = new Box();
        box.setNo("1");
        box.setTemp("24.17");
        box.setJKS("0000");
        box.setOpenStatus("开，关");
        box.setVolt1("5.16");
        box.setVolt2("5.16");
        box.setLight("01");
        box.setPhotoSense1("01");
        box.setPhotoSense1("01");
        boxInfo.add(box);
        String jsonArray = JSONArray.toJSONString(boxInfo);
        JSONObject boxInfoJson = new JSONObject();
        boxInfoJson.put("boxInfo",jsonArray);
        System.out.println(boxInfoJson.toString());

        String posStr = "0";
        while (posStr.length() < 8) {
            StringBuffer sb = new StringBuffer();
            //左补0
            sb.append("0").append(posStr);
            posStr = sb.toString();

        }
        System.out.println(posStr);
        byte[] fileOffset = new byte[8];
        char[] posStrChars = posStr.toCharArray();
        for (int k = 0; k < posStrChars.length; k++) {
            fileOffset[k] = (byte) posStrChars[k];
        }

    }
}
