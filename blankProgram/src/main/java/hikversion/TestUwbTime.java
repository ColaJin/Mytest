package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:jinyandong
 * @description:测试处理数据耗时
 * @Date:2023/10/23
 */
public class TestUwbTime {
    public static ConcurrentHashMap<String, DevInfo> indexCodeDetailMap = new ConcurrentHashMap<>(20000);
    public static void main(String[] args) {
        DevInfo devInfo = new DevInfo();
        devInfo.setDevName("test111");
        devInfo.setDevType("DS-PWA32-UWB");
        devInfo.setDeviceIndexCode("000000007063");
        devInfo.setTreatyType("activemq_reg");
        indexCodeDetailMap.put("900a604661db4137b84efcf579235142",devInfo);

        String dataStr = "{    \"data\":[        {            \"lastTime\":1676444977959,            \"btState\":0,            \"flag\":2,            \"supportHeartRate\":true,            \"packageNumber_24G\":0,            \"disapperAreaFlag\":1,            \"mapUUID\":\"hik_2\",            \"activeFiled1\":0,            \"channel\":0,            \"userIdentity\":2,            \"disState\":0,            \"type\":1,            \"customId\":\"10\",            \"activeFiled2\":0,            \"tagType\":2,            \"lastOriginalY\":-0.09,            \"id\":\"000000007063\",            \"mapName\":\"ys-hu-20180705\",            \"lastOriginalX\":-0.34,            \"moveFlag\":1,            \"activeCount\":214,            \"filedStrength_24G\":0,            \"mapKey\":\"hik_2\",            \"active\":false,            \"sendCount\":0,            \"diffAreaCount\":0,            \"voltage\":5,            \"areaCount\":0,            \"areaId\":\"2002\",            \"heartRate\":80,            \"originalY\":0.215,            \"activeCode2\":0,            \"activeCode1\":101,            \"name\":\"944af60a308f\",            \"x\":321,            \"originalX\":0.321,            \"serverIp\":\"10.20.84.111\",  \"icCode\":\"123444\",            \"stationX\":20.651,            \"stationY\":5.279,            \"stationZ\":0.45000,            \"stationSn\":\"xxxxxxx\",          \"tagUUID\":\"10\",            \"y\":215,            \"mapId\":33,            \"previousAreaId\":0        }    ],    \"type\":1}";
        JSONObject jsonObject = JSONObject.parseObject(dataStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        JSONObject data = new JSONObject();
        for (Object o : jsonArray) {
            data = (JSONObject) o;
        }
        List<UWBEventReport> alarms = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UWBEventReport uwbEventReport = new UWBEventReport();
            uwbEventReport.setDeviceId("900a604661db4137b84efcf579235142");
            uwbEventReport.setImei("900a604661db4137b84efcf579235142");
            uwbEventReport.setEventType(1);
            uwbEventReport.setEventContent(data);
            alarms.add(uwbEventReport);
        }
        reportData_Batch_Dac(alarms,null);
    }

    /**
     * 发送数据
     *
     * @param notifyCbf
     */
    private static void reportData_Batch_Dac(List<UWBEventReport> alarms, NotifyCbf notifyCbf) {
        long start = System.currentTimeMillis();
        List<DataModel> dataModels = new ArrayList<>();
        /*for (UWBEventReport alarm : alarms) {
            // 1. 将告警信息alarm解析，并转储到json中
            // 设备唯一标识
            String deviceId = alarm.getDeviceId();
            JSONObject eventContent = alarm.getEventContent();

            JSONObject jsonHeader = new JSONObject();

            JSONObject data = new JSONObject();
            data.put("dataType", "rfid");
            data.put("recvTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("sendTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("dateTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("ipAddress", "127.0.0.1");
            data.put("ipv6Address", "127.0.0.1");
            data.put("port", "9222");
            data.put("eventType", "braceletCollection");
            data.put("eventDescription", "bracelet Collection");

            JSONArray positions = new JSONArray();

            JSONObject BraceletCollection = new JSONObject();
            BraceletCollection.put("alarmTime", eventContent.get("lastTime"));
            BraceletCollection.put("electricEnergy", eventContent.get("voltage"));
            BraceletCollection.put("serverIp", eventContent.get("serverIp"));
            if (null != eventContent.get("icCode")) {
                BraceletCollection.put("icCode", eventContent.get("icCode"));
            }
            BraceletCollection.put("precisionType", eventContent.get("type"));
            BraceletCollection.put("moveStatus", eventContent.get("moveFlag"));
            BraceletCollection.put("heartRate", eventContent.get("heartRate"));
            BraceletCollection.put("btState", eventContent.get("btState"));
            BraceletCollection.put("tagType", eventContent.get("tagType"));
            BraceletCollection.put("disState", eventContent.get("disState"));

            JSONObject RegionCoordinate = new JSONObject();
            RegionCoordinate.put("positionX", eventContent.get("originalX"));
            RegionCoordinate.put("positionY", eventContent.get("originalY"));
            RegionCoordinate.put("positionZ", eventContent.get("originalZ"));
            BraceletCollection.put("RegionCoordinate", RegionCoordinate);

            JSONObject Related = new JSONObject();
            Related.put("id", deviceId);
            Related.put("type", eventContent.get("type"));
            Related.put("name", eventContent.get("name"));
            Related.put("regionId", eventContent.get("areaId"));
            BraceletCollection.put("Related", Related);

            JSONObject Map = new JSONObject();
            Map.put("id", eventContent.get("mapId"));
            Map.put("name", eventContent.get("mapName"));
            BraceletCollection.put("Map", Map);


            JSONObject StationInfo = new JSONObject();
            StationInfo.put("stationSn", eventContent.get("stationSn"));
            StationInfo.put("x", eventContent.get("stationX"));
            StationInfo.put("y", eventContent.get("stationY"));
            StationInfo.put("z", eventContent.get("stationZ"));
            BraceletCollection.put("StationInfo", StationInfo);

            JSONObject GPSInfo = new JSONObject();

            if (null != eventContent.get("longitudeType")) {
                GPSInfo.put("longitudeType", eventContent.get("longitudeType"));
            }

            if (null != eventContent.get("longitude")) {
                GPSInfo.put("longitude", eventContent.get("longitude"));
            }

            if (null != eventContent.get("latitudeType")) {
                GPSInfo.put("latitudeType", eventContent.get("latitudeType"));
            }

            if (null != eventContent.get("latitude")) {
                GPSInfo.put("latitude", eventContent.get("latitude"));
            }

            if (null != eventContent.get("height")) {
                GPSInfo.put("height", eventContent.get("height"));
            }
            BraceletCollection.put("GPSInfo", GPSInfo);
            positions.add(BraceletCollection);
            data.put("BraceletCollection", positions);

            if (alarm.getEventType() == 1) {
                jsonHeader.put("eventType", 303105);
            }
            jsonHeader.put("status", 0);
            jsonHeader.put("timeout", 0);
            jsonHeader.put("srcIndex", indexCodeDetailMap.get(deviceId).getIndexCode());
            jsonHeader.put("srcName", indexCodeDetailMap.get(deviceId).getDevName());
            jsonHeader.put("srcParentIndex", indexCodeDetailMap.get(deviceId).getIndexCode());
            jsonHeader.put("srcType", "Wristband");
            jsonHeader.put("happenTime", ComTool.getCurrentTime());

            DataModel dataModel = new DataModel();
            dataModel.setbOtap(false);
            dataModel.setEventType(303105);
            dataModel.setHappenTime(ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ssXXX"));
            dataModel.setSrcIndex(indexCodeDetailMap.get(deviceId).getIndexCode());
            dataModel.setSrcName(indexCodeDetailMap.get(deviceId).getDevName());
            dataModel.setSrcParentIndex(indexCodeDetailMap.get(deviceId).getIndexCode());
            dataModel.setStatus(0);
            dataModel.setTimeout(0);
            dataModel.setSrcType("Wristband");
            JSONObject dataJson = new JSONObject();
            dataJson.put("data",data);
            dataModel.setData(dataJson);
            dataModels.add(dataModel);

        }*/
        /*alarms.parallelStream().forEach( alarm->{
            String deviceId = alarm.getDeviceId();
            JSONObject eventContent = alarm.getEventContent();

            JSONObject jsonHeader = new JSONObject();

            JSONObject data = new JSONObject();
            data.put("dataType", "rfid");
            data.put("recvTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("sendTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("dateTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("ipAddress", "127.0.0.1");
            data.put("ipv6Address", "127.0.0.1");
            data.put("port", "9222");
            data.put("eventType", "braceletCollection");
            data.put("eventDescription", "bracelet Collection");

            JSONArray positions = new JSONArray();

            JSONObject BraceletCollection = new JSONObject();
            BraceletCollection.put("alarmTime", eventContent.get("lastTime"));
            BraceletCollection.put("electricEnergy", eventContent.get("voltage"));
            BraceletCollection.put("serverIp", eventContent.get("serverIp"));
            if (null != eventContent.get("icCode")) {
                BraceletCollection.put("icCode", eventContent.get("icCode"));
            }
            BraceletCollection.put("precisionType", eventContent.get("type"));
            BraceletCollection.put("moveStatus", eventContent.get("moveFlag"));
            BraceletCollection.put("heartRate", eventContent.get("heartRate"));
            BraceletCollection.put("btState", eventContent.get("btState"));
            BraceletCollection.put("tagType", eventContent.get("tagType"));
            BraceletCollection.put("disState", eventContent.get("disState"));

            JSONObject RegionCoordinate = new JSONObject();
            RegionCoordinate.put("positionX", eventContent.get("originalX"));
            RegionCoordinate.put("positionY", eventContent.get("originalY"));
            RegionCoordinate.put("positionZ", eventContent.get("originalZ"));
            BraceletCollection.put("RegionCoordinate", RegionCoordinate);

            JSONObject Related = new JSONObject();
            Related.put("id", deviceId);
            Related.put("type", eventContent.get("type"));
            Related.put("name", eventContent.get("name"));
            Related.put("regionId", eventContent.get("areaId"));
            BraceletCollection.put("Related", Related);

            JSONObject Map = new JSONObject();
            Map.put("id", eventContent.get("mapId"));
            Map.put("name", eventContent.get("mapName"));
            BraceletCollection.put("Map", Map);


            JSONObject StationInfo = new JSONObject();
            StationInfo.put("stationSn", eventContent.get("stationSn"));
            StationInfo.put("x", eventContent.get("stationX"));
            StationInfo.put("y", eventContent.get("stationY"));
            StationInfo.put("z", eventContent.get("stationZ"));
            BraceletCollection.put("StationInfo", StationInfo);

            JSONObject GPSInfo = new JSONObject();

            if (null != eventContent.get("longitudeType")) {
                GPSInfo.put("longitudeType", eventContent.get("longitudeType"));
            }

            if (null != eventContent.get("longitude")) {
                GPSInfo.put("longitude", eventContent.get("longitude"));
            }

            if (null != eventContent.get("latitudeType")) {
                GPSInfo.put("latitudeType", eventContent.get("latitudeType"));
            }

            if (null != eventContent.get("latitude")) {
                GPSInfo.put("latitude", eventContent.get("latitude"));
            }

            if (null != eventContent.get("height")) {
                GPSInfo.put("height", eventContent.get("height"));
            }
            BraceletCollection.put("GPSInfo", GPSInfo);
            positions.add(BraceletCollection);
            data.put("BraceletCollection", positions);

            if (alarm.getEventType() == 1) {
                jsonHeader.put("eventType", 303105);
            }
            jsonHeader.put("status", 0);
            jsonHeader.put("timeout", 0);
            jsonHeader.put("srcIndex", indexCodeDetailMap.get(deviceId).getIndexCode());
            jsonHeader.put("srcName", indexCodeDetailMap.get(deviceId).getDevName());
            jsonHeader.put("srcParentIndex", indexCodeDetailMap.get(deviceId).getIndexCode());
            jsonHeader.put("srcType", "Wristband");
            jsonHeader.put("happenTime", ComTool.getCurrentTime());

            DataModel dataModel = new DataModel();
            dataModel.setbOtap(false);
            dataModel.setEventType(303105);
            dataModel.setHappenTime(ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ssXXX"));
            dataModel.setSrcIndex(indexCodeDetailMap.get(deviceId).getIndexCode());
            dataModel.setSrcName(indexCodeDetailMap.get(deviceId).getDevName());
            dataModel.setSrcParentIndex(indexCodeDetailMap.get(deviceId).getIndexCode());
            dataModel.setStatus(0);
            dataModel.setTimeout(0);
            dataModel.setSrcType("Wristband");
            JSONObject dataJson = new JSONObject();
            dataJson.put("data",data);
            dataModel.setData(dataJson);
            dataModels.add(dataModel);
        });*/

        /*TestCallable testCallable = new TestCallable();
        testCallable.getAllRes(alarms);*/

        /*TestCallable testCallable = new TestCallable();
        Map<String, List<DataModel>> allEvents = testCallable.getAllEvents(alarms);*/

        for (UWBEventReport alarm : alarms) {
            String deviceId = alarm.getDeviceId();
            JSONObject eventContent = alarm.getEventContent();

            JSONObject jsonHeader = new JSONObject();

            JSONObject data = new JSONObject();
            data.put("dataType", "rfid");
            data.put("recvTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("sendTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("dateTime", ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
            data.put("ipAddress", "127.0.0.1");
            data.put("ipv6Address", "127.0.0.1");
            data.put("port", "9222");
            data.put("eventType", "braceletCollection");
            data.put("eventDescription", "bracelet Collection");

            JSONArray positions = new JSONArray();

            JSONObject BraceletCollection = new JSONObject();
            BraceletCollection.put("alarmTime", eventContent.get("lastTime"));
            BraceletCollection.put("electricEnergy", eventContent.get("voltage"));
            BraceletCollection.put("serverIp", eventContent.get("serverIp"));
            if (null != eventContent.get("icCode")) {
                BraceletCollection.put("icCode", eventContent.get("icCode"));
            }
            BraceletCollection.put("precisionType", eventContent.get("type"));
            BraceletCollection.put("moveStatus", eventContent.get("moveFlag"));
            BraceletCollection.put("heartRate", eventContent.get("heartRate"));
            BraceletCollection.put("btState", eventContent.get("btState"));
            BraceletCollection.put("tagType", eventContent.get("tagType"));
            BraceletCollection.put("disState", eventContent.get("disState"));

            JSONObject RegionCoordinate = new JSONObject();
            RegionCoordinate.put("positionX", eventContent.get("originalX"));
            RegionCoordinate.put("positionY", eventContent.get("originalY"));
            RegionCoordinate.put("positionZ", eventContent.get("originalZ"));
            BraceletCollection.put("RegionCoordinate", RegionCoordinate);

            JSONObject Related = new JSONObject();
            Related.put("id", deviceId);
            Related.put("type", eventContent.get("type"));
            Related.put("name", eventContent.get("name"));
            Related.put("regionId", eventContent.get("areaId"));
            BraceletCollection.put("Related", Related);

            JSONObject Map = new JSONObject();
            Map.put("id", eventContent.get("mapId"));
            Map.put("name", eventContent.get("mapName"));
            BraceletCollection.put("Map", Map);


            JSONObject StationInfo = new JSONObject();
            StationInfo.put("stationSn", eventContent.get("stationSn"));
            StationInfo.put("x", eventContent.get("stationX"));
            StationInfo.put("y", eventContent.get("stationY"));
            StationInfo.put("z", eventContent.get("stationZ"));
            BraceletCollection.put("StationInfo", StationInfo);

            JSONObject GPSInfo = new JSONObject();

            if (null != eventContent.get("longitudeType")) {
                GPSInfo.put("longitudeType", eventContent.get("longitudeType"));
            }

            if (null != eventContent.get("longitude")) {
                GPSInfo.put("longitude", eventContent.get("longitude"));
            }

            if (null != eventContent.get("latitudeType")) {
                GPSInfo.put("latitudeType", eventContent.get("latitudeType"));
            }

            if (null != eventContent.get("latitude")) {
                GPSInfo.put("latitude", eventContent.get("latitude"));
            }

            if (null != eventContent.get("height")) {
                GPSInfo.put("height", eventContent.get("height"));
            }
            BraceletCollection.put("GPSInfo", GPSInfo);
            positions.add(BraceletCollection);
            data.put("BraceletCollection", positions);

            if (alarm.getEventType() == 1) {
                jsonHeader.put("eventType", 303105);
            }
            jsonHeader.put("status", 0);
            jsonHeader.put("timeout", 0);
            jsonHeader.put("srcIndex", indexCodeDetailMap.get(deviceId).getIndexCode());
            jsonHeader.put("srcName", indexCodeDetailMap.get(deviceId).getDevName());
            jsonHeader.put("srcParentIndex", indexCodeDetailMap.get(deviceId).getIndexCode());
            jsonHeader.put("srcType", "Wristband");
            //jsonHeader.put("happenTime", ComTool.getCurrentTime());

            DataModel dataModel = new DataModel();
            dataModel.setbOtap(false);
            dataModel.setEventType(303105);
            //dataModel.setHappenTime(ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ssXXX"));
            dataModel.setSrcIndex(indexCodeDetailMap.get(deviceId).getIndexCode());
            dataModel.setSrcName(indexCodeDetailMap.get(deviceId).getDevName());
            dataModel.setSrcParentIndex(indexCodeDetailMap.get(deviceId).getIndexCode());
            dataModel.setStatus(0);
            dataModel.setTimeout(0);
            dataModel.setSrcType("Wristband");
            JSONObject dataJson = new JSONObject();
            dataJson.put("data",data);
            dataModel.setData(dataJson);
            dataModels.add(dataModel);
        }

        System.out.println("spend time"+(System.currentTimeMillis() - start));
        //System.out.println(JSONObject.toJSONString(allEvents));
//        System.out.println(JSONObject.toJSONString(dataModels));
        // 6. 回调上报至上层进行处理
        if (notifyCbf != null) {
            notifyCbf.NotifyCallBack_Batch(dataModels);
        }
    }


}
