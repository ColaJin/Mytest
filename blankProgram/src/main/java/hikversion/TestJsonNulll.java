package hikversion;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author:jinyandong
 * @description:测试Json字符串空值问题
 * @Date:2022/12/14
 */
public class TestJsonNulll {
    public static void main(String[] args) {
        NBConnectDto nbConnectDto = new NBConnectDto();
        nbConnectDto.setSensorType("");
        nbConnectDto.setAddr("127.0.0.1");
        // System.out.println(JSONObject.toJSONString(nbConnectDto));
        System.out.println(JSONObject.toJSONString(nbConnectDto, SerializerFeature.WriteNullStringAsEmpty));
    }
}
