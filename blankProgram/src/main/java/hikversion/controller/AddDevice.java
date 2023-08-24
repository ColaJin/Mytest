package hikversion.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:添加设备
 * @Date:2022/8/17
 */
public class AddDevice {

    public void testSchedule() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    teatADDActive();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "testAdd1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    teatUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "testUpdate2");
        t.start();
        t2.start();
    }

    public void teatUpdate() {
        DeviceSubmitContent content = new DeviceSubmitContent();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> maps = new HashMap<>();
        maps.put("indexCode","3186a904c54c4dc587361c6745c94f02");
        maps.put("deviceIndexCode","F08431");
        maps.put("belongIndexCode","1daa6190-2893-44c3-b78d-6d101704cc9d");
        list.add(maps);
        content.setDevices(list);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Token", "SElLIEpJV1UrR2xYc0N1NjRqdHQ6TG82aGh3M3J4VjhZZmVwWjhGc0RQSGs2Y0VyaG5aWHpEYVNIVE1rdkI3QT06MTY2MDc5MDQ4OTc0Mw==");
        // SElLIFIwOCtpc2lnV0JUQlVsRWI6UEdhT01JcS9QQldWRkZmdmM1QzBvRXFuOVpCRVNPd1RrZXplVkFlRmE4az06MTY2MDcyODMyNTA2Mw==
        HttpEntity<Object> entity = new HttpEntity<>(content, headers);
        ResultData resultData = null;
        ResponseEntity<ResultData> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try {

            responseEntity = restTemplate.exchange("http://127.0.0.1:8080/dac/dms/v1/device/update?serviceIndexCode=iotdevls", HttpMethod.POST, entity, ResultData.class, new HashMap<String, String>());
            resultData = responseEntity.getBody();
            System.out.println(JSONObject.toJSONString(resultData));
        }catch (HttpStatusCodeException e) {
            System.out.println("HttpStatusCodeException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }


    }

    public void teatADDActive() {
        DevicePostContent content = new DevicePostContent();
        List<DeviceBean> devices = new ArrayList<>();
        List<ChannelBean> channels = new ArrayList<>();
        DeviceBean device2 = new DeviceBean();
        device2.setDeviceIndexCode("F08431");
        device2.setTreatyType("isup5_reg");
        device2.setAddrType(0);
        device2.setManufacturer("hikvision");
        device2.setName("TEST7");
        device2.setDeviceTypeCode("encodeDevice");
        device2.setAddrType(200);
        device2.setDeviceCategory("vss");
        devices.add(device2);
        content.setDevices(devices);
        content.setChannels(channels);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Token", "SElLIEpJV1UrR2xYc0N1NjRqdHQ6TG82aGh3M3J4VjhZZmVwWjhGc0RQSGs2Y0VyaG5aWHpEYVNIVE1rdkI3QT06MTY2MDc5MDQ4OTc0Mw==");
        // SElLIFIwOCtpc2lnV0JUQlVsRWI6UEdhT01JcS9QQldWRkZmdmM1QzBvRXFuOVpCRVNPd1RrZXplVkFlRmE4az06MTY2MDcyODMyNTA2Mw==
        HttpEntity<Object> entity = new HttpEntity<>(content, headers);
        ResultData resultData = null;
        ResponseEntity<ResultData> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try {

            responseEntity = restTemplate.exchange("http://127.0.0.1:8080/dac/dms/v1/device?serviceIndexCode=iotdevls", HttpMethod.POST, entity, ResultData.class, new HashMap<String, String>());
            resultData = responseEntity.getBody();
            System.out.println(JSONObject.toJSONString(resultData));
        }catch (HttpStatusCodeException e) {
            System.out.println("HttpStatusCodeException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }


    }

    public void teatADD() {
        DevicePostContent content = new DevicePostContent();
        List<DeviceBean> devices = new ArrayList<>();
        List<ChannelBean> channels = new ArrayList<>();
        DeviceBean device2 = new DeviceBean();
        device2.setDeviceKey("drv_vss_hiksdk_general_1.13.100");
        device2.setTreatyType("dhsdk_net");
        device2.setAddrType(0);
        device2.setManufacturer("hikvision");
        device2.setName("10.19.151.117_15562");
        device2.setNetZoneId(0);
        device2.setOnlineStatus(-1l);
        device2.setPort(15559);
        device2.setTreatyType("hiksdk_net");
        device2.setIndexCode("9849b38b3a27097279440399ce3b8381");
        device2.setDeviceId(22L);
        device2.setAddr("10.19.151.117");
        device2.setDeviceCategory("vss");
        device2.setDeviceType("IPCamera");
        device2.setPort(80);
        devices.add(device2);
        content.setDevices(devices);
        content.setChannels(channels);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Token", "SElLIEpJV1UrR2xYc0N1NjRqdHQ6TG82aGh3M3J4VjhZZmVwWjhGc0RQSGs2Y0VyaG5aWHpEYVNIVE1rdkI3QT06MTY2MDc5MDQ4OTc0Mw==");
        // SElLIFIwOCtpc2lnV0JUQlVsRWI6UEdhT01JcS9QQldWRkZmdmM1QzBvRXFuOVpCRVNPd1RrZXplVkFlRmE4az06MTY2MDcyODMyNTA2Mw==
        HttpEntity<Object> entity = new HttpEntity<>(content, headers);
        ResultData resultData = null;
        ResponseEntity<ResultData> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try {

            responseEntity = restTemplate.exchange("http://127.0.0.1:8080/dac/dms/v1/device?serviceIndexCode=iotdevls", HttpMethod.POST, entity, ResultData.class, new HashMap<String, String>());
            resultData = responseEntity.getBody();
            System.out.println(JSONObject.toJSONString(resultData));
        }catch (HttpStatusCodeException e) {
            System.out.println("HttpStatusCodeException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }


    }

}
