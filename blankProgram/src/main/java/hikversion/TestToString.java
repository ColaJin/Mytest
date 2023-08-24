package hikversion;

import entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试List<Map>转换成toString
 * @Date:2021/7/26
 */
public class TestToString {
    public static void main(String[] args) {
        List<Map<String, Object>> devices = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("设备1", new User("jyd", 1));
        devices.add(map);
        System.out.println(devices.toString());

        System.out.println(StringUtils.contains("drv_ias_isapi_net_1.4.100", "drv_ias_isapi_net"));
    }
}
