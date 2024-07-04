package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author:jinyandong
 * @description:测试读取line
 * @Date:2024/1/23
 */
public class TestLine {
    public static void main(String[] args) {
        String line = "[{\"port\":7314,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"webSocketPort\",\"netprotocol\":\"tcp\"},{\"port\":17000,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"tcpSinglePort\",\"netprotocol\":\"tcp\"},{\"port\":7032,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"ehomeAlarmPortTcp\",\"netprotocol\":\"tcp\"},{\"port\":16997,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"otapPlayBackPort\",\"netprotocol\":\"tcp\"},{\"port\":7033,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"eHome5AlarmPort\",\"netprotocol\":\"tcp\"},{\"port\":0,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"tcpPortRange\",\"netprotocol\":\"tcp\"},{\"port\":16999,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"otapStreamPort\",\"netprotocol\":\"tcp\"},{\"port\":16996,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"otapBroadcastPort\",\"netprotocol\":\"tcp\"},{\"port\":5060,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"sipSerPort\",\"netprotocol\":\"udp\"},{\"port\":7443,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"ZYWebSocketPort\",\"netprotocol\":\"tcp\"},{\"port\":7302,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"webPort\",\"netprotocol\":\"http\"},{\"port\":7307,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"clusterPort\",\"netprotocol\":\"tcp\"},{\"port\":8069,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"ehome5HttpPort\",\"netprotocol\":\"http\"},{\"port\":0,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"udpPortRange\",\"netprotocol\":\"udp\"},{\"port\":7146,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"cmiotPort\",\"netprotocol\":\"tcp\"},{\"port\":655,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"rtspPort\",\"netprotocol\":\"tcp\"},{\"port\":16998,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"otapVoicePort\",\"netprotocol\":\"tcp\"},{\"port\":7031,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"ehome5Port\",\"netprotocol\":\"tcp\"},{\"port\":7660,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"ehomePort\",\"netprotocol\":\"udp\"},{\"port\":9683,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"rtspsPort\",\"netprotocol\":\"https\"},{\"port\":7319,\"domainName\":\"hk-yzwtest01.cmqly.com\",\"ip\":\"\",\"state\":\"enable\",\"domainId\":3,\"key\":\"isupVoicePort\",\"netprotocol\":\"tcp\"}]";
        JSONArray jsonLine = JSON.parseArray(line);
        boolean isGbIpv4Port = isContainsPort(jsonLine, "sipSerPort");
        System.out.println(isGbIpv4Port);
    }
    public static boolean isContainsPort(JSONArray line, String port) {
        boolean result = false;
        if (line != null ) {
            String s = line.toString();
            if (StringUtils.isNotBlank(s)&& !StringUtils.equals("[]",s)) {
                for (Object o : line) {
                    JSONObject temp = (JSONObject) o;
                    if (StringUtils.equals(port, temp.getString("key"))) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
