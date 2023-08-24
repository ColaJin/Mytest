package hikversion;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author:jinyandong
 * @description:测试json为空的设置
 * @Date:2023/7/24
 */
public class TestJson {
    public static void main(String[] args) {
        /*String s = "{    \"data\":[        {            \"lastTime\":1676444977959,            \"btState\":0,            \"flag\":2,            \"supportHeartRate\":true,            \"packageNumber_24G\":0,            \"disapperAreaFlag\":1,            \"mapUUID\":\"hik_2\",            \"activeFiled1\":0,            \"channel\":0,            \"userIdentity\":2,            \"disState\":0,            \"type\":1,            \"customId\":\"10\",            \"activeFiled2\":0,            \"tagType\":2,            \"lastOriginalY\":-0.09,            \"id\":\"YXA10100012001000041f355e9f0-e596-4acb-884e-5fc5128c42f2\",            \"mapName\":\"ys-hu-20180705\",            \"lastOriginalX\":-0.34,            \"moveFlag\":1,            \"activeCount\":214,            \"filedStrength_24G\":0,            \"mapKey\":\"hik_2\",            \"active\":false,            \"sendCount\":0,            \"diffAreaCount\":0,            \"voltage\":5,            \"areaCount\":0,            \"areaId\":\"2002\",            \"heartRate\":80,            \"originalY\":0.215,            \"activeCode2\":0,            \"activeCode1\":101,            \"name\":\"944af60a308f\",            \"x\":321,            \"originalX\":0.321,            \"serverIp\":\"10.20.84.111\",  \"icCode\":\"123444\",            \"stationX\":20.651,            \"stationY\":5.279,            \"stationZ\":0.45000,            \"stationSn\":\"xxxxxxx\",          \"tagUUID\":\"10\",            \"y\":215,            \"mapId\":33,            \"previousAreaId\":0        }    ],    \"type\":1}";
        JSONObject data = JSONObject.parseObject( s);
        JSONObject BraceletCollection = new JSONObject();
        BraceletCollection.put("longitudeType",data.get("longitudeType"));
        System.out.println(BraceletCollection.toString());*/
        JSONObject result = new JSONObject();
        ItemInfo itemInfo = new ItemInfo();
        //itemInfo.setWidth("66");

        // System.out.println(JSONObject.toJSONString(itemInfo, SerializerFeature.WriteMapNullValue));
        System.out.println(JSONObject.toJSONString(itemInfo));
    }

    /*private static JSONObject dealItem(ItemInfo itemInfo) {
        JSONObject result = new JSONObject();
        result.put("number", itemInfo.getNumber());
        result.put("stayTime", itemInfo.getStayTime());
        result.put("type", itemInfo.getType());
        result.put("stayType", itemInfo.getStayType());
        result.put("screenType", itemInfo.ge);
        result.put("speed", speed);
        result.put("start", start);
        result.put("end", end);
        result.put("name", name);
        result.put("fileType", fileType);
        result.put("red", red);
        result.put("green", green);
        result.put("blue", blue);
        result.put("amber", amber);
        result.put("bgRed", bgRed);
        result.put("bgGreen", bgGreen);
        result.put("bgBlue", bgBlue);
        result.put("bgAmber", bgAmber);
        result.put("space", space);
        result.put("font", font);
        result.put("width", width);
        result.put("high", high);
        result.put("warp", warp);
        result.put("times", times);
        result.put("locationX", locationX);
        result.put("locationY", locationY);
        result.put("locationZ", locationZ);
        result.put("content", content);
    }*/
}
