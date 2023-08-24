package hikversion;

import hikversion.controller.DeviceBean;

import java.util.*;

/**
 * @author:jinyandong
 * @description:测试contains功能
 * @Date:2022/12/8
 */
public class TestContain {
    public static void main(String[] args) {
        /*Set<String> errorRow = new HashSet<String>();
        errorRow.add("11");
        Map<Long, DeviceBean> deviceReqDtoMap = new HashMap<>();
        deviceReqDtoMap.put(1L,new DeviceBean());
        Iterator<Map.Entry<Long, DeviceBean>> entryIterator = deviceReqDtoMap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<Long, DeviceBean> deviceReqDtoEntry = entryIterator.next();
            Long row = deviceReqDtoEntry.getKey();
            if (errorRow.contains(String.valueOf(row))){
                System.out.println("this is error");
            }
        }*/
        /*Set<String> errorRow = new HashSet<String>();
        errorRow.add("12345678910--11");
        Map<String, DeviceBean> deviceReqDtoMap = new HashMap<>();
        deviceReqDtoMap.put("12345678910--1",new DeviceBean());
        Iterator<Map.Entry<String, DeviceBean>> entryIterator = deviceReqDtoMap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, DeviceBean> deviceReqDtoEntry = entryIterator.next();
            String row = deviceReqDtoEntry.getKey();
            if (errorRow.contains(row)){
                System.out.println("this is error");
            }
        }*/
        /*List<String> errorRow = new ArrayList<>();
        errorRow.add("12345678910--11");
        Map<String, DeviceBean> deviceReqDtoMap = new HashMap<>();
        deviceReqDtoMap.put("12345678910--1",new DeviceBean());
        Iterator<Map.Entry<String, DeviceBean>> entryIterator = deviceReqDtoMap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, DeviceBean> deviceReqDtoEntry = entryIterator.next();
            String row = deviceReqDtoEntry.getKey();
            if (errorRow.contains(row)){
                System.out.println("this is error");
            }
        }*/
        List<String> errorRow = new ArrayList<>();
        errorRow.add("12345678910--1");
        Map<String, DeviceBean> deviceReqDtoMap = new HashMap<>();
        deviceReqDtoMap.put("12345678910--11",new DeviceBean());
        if(deviceReqDtoMap.containsKey(errorRow.get(0))){
            System.out.println("this is error");
        }
    }
}
