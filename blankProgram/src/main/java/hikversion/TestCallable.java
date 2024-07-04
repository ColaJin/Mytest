package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author:jinyandong
 * @description:测试多线程处理数据
 * @Date:2023/10/23
 */
public class TestCallable {
    public Map<String, List<DataModel>> getAllRes(List<UWBEventReport> alarms) {
        Map<String, Callable<List<DataModel>>> tasks = new HashMap<>();
        for (UWBEventReport alarm : alarms) {
            Callable<List<DataModel>> task = new Callable<List<DataModel>>() {
                @Override
                public List<DataModel> call() throws Exception {
                    return getEvents(alarms);
                }
            };
            tasks.put(alarm.getDeviceId(), task);
        }
        Map<String, List<DataModel>> resMap = ExcoutorTimeOutUtil.excoutorTimeout(tasks, 5L, 20);
        return resMap;
    }

    public Map<String, List<DataModel>> getAllEvents(List<UWBEventReport> alarms) {
        Map<String, Callable<List<DataModel>>> tasks = new HashMap<>();
        List<DataModel> dataModels = new ArrayList<>();
        for (UWBEventReport alarm : alarms) {
            Callable<List<DataModel>> task = new Callable<List<DataModel>>() {
                @Override
                public List<DataModel> call() throws Exception {
                    return getSingleEvents(alarm,dataModels);
                }
            };
            tasks.put(alarm.getDeviceId(), task);
        }
        Map<String, List<DataModel>> resMap = ExcoutorTimeOutUtil.excoutorTimeout(tasks, 5L, 20);
        return resMap;
    }

    private List<DataModel> getEvents(List<UWBEventReport> alarms){
        List<DataModel> dataModels = new ArrayList<>();
        for (UWBEventReport alarm : alarms) {
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
            jsonHeader.put("srcIndex", "900a604661db4137b84efcf579235142");
            jsonHeader.put("srcName", "900a604661db4137b84efcf579235142");
            jsonHeader.put("srcParentIndex", "900a604661db4137b84efcf579235142");
            jsonHeader.put("srcType", "Wristband");
            jsonHeader.put("happenTime", ComTool.getCurrentTime());

            DataModel dataModel = new DataModel();
            dataModel.setbOtap(false);
            dataModel.setEventType(303105);
            dataModel.setHappenTime(ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ssXXX"));
            dataModel.setSrcIndex("900a604661db4137b84efcf579235142");
            dataModel.setSrcName("900a604661db4137b84efcf579235142");
            dataModel.setSrcParentIndex("900a604661db4137b84efcf579235142");
            dataModel.setStatus(0);
            dataModel.setTimeout(0);
            dataModel.setSrcType("Wristband");
            JSONObject dataJson = new JSONObject();
            dataJson.put("data",data);
            dataModel.setData(dataJson);
            dataModels.add(dataModel);

        }
        return dataModels;
    }
    private List<DataModel> getSingleEvents(UWBEventReport alarm,List<DataModel> dataModels){
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
            jsonHeader.put("srcIndex", "900a604661db4137b84efcf579235142");
            jsonHeader.put("srcName", "900a604661db4137b84efcf579235142");
            jsonHeader.put("srcParentIndex", "900a604661db4137b84efcf579235142");
            jsonHeader.put("srcType", "Wristband");
            jsonHeader.put("happenTime", ComTool.getCurrentTime());

            DataModel dataModel = new DataModel();
            dataModel.setbOtap(false);
            dataModel.setEventType(303105);
            dataModel.setHappenTime(ComTool.getCurrentTime("yyyy-MM-dd'T'HH:mm:ssXXX"));
            dataModel.setSrcIndex("900a604661db4137b84efcf579235142");
            dataModel.setSrcName("900a604661db4137b84efcf579235142");
            dataModel.setSrcParentIndex("900a604661db4137b84efcf579235142");
            dataModel.setStatus(0);
            dataModel.setTimeout(0);
            dataModel.setSrcType("Wristband");
            JSONObject dataJson = new JSONObject();
            dataJson.put("data",data);
            dataModel.setData(dataJson);
        dataModels.add(dataModel);

        return dataModels;
    }
}
