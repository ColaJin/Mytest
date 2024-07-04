package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author:jinyandong
 * @description:测试getJsonArray()
 * @Date:2024/4/2
 */
public class TestJsonArray {
    public static void main(String[] args) {
        String rs = "{\"group\":\"facilityAssets\",\"identifier\":\"lane\",\"imageId\":\"73e0a73830c0405eac25792743a4769e\",\"name\":\"......\",\"profile\":{\"capacities\":{\"support_ota\":1,\"support_user_sleep\":0,\"support_check_auth\":0,\"support_token_deviceadd\":0,\"support_childmanage\":0,\"support_user_wakeup\":0},\"attributes\":[{\"createTime\":\"2024-03-20 20:19:59\",\"creator\":\"admin\",\"desc\":\"..........................................\",\"fieldType\":\"STRING\",\"group\":\"base\",\"id\":\"a5b38a54-e193-4dd1-aef6-f75cb882e71f\",\"logo\":\"\",\"name\":\"name\",\"nameZh\":\"............\",\"orderSequence\":2147483647,\"required\":false,\"resourceCategories\":[\"SCENE\"],\"schema\":{\"createTime\":\"2024-03-20 20:19:59\",\"example\":\" \\\"......1\\\"\\n/*req, string, ............, const:, range:[0,100], enum:[], format:, pattern:, unit:, RAP:, desc:..........................................*/\",\"id\":882,\"schema\":{\"default\":\"......1\",\"maxLength\":100,\"minLength\":0,\"type\":\"string\",\"title\":\"............\",\"description\":\"..........................................\"},\"updateTime\":\"2024-03-28 16:15:08\"},\"sourceFrom\":\"LOCAL\",\"status\":\"FINAL\",\"updateTime\":\"2024-03-28 16:15:08\"}],\"resources\":[{\"uniqueIndex\":\"1aeeb0fb-13b8-4cfc-b2e8-24b26dbc1fcd\",\"identifier\":\"Video\",\"title\":\"...... \",\"resourceCategory\":\"Video\",\"localIndex\":[\"1\"],\"dynamic\":false,\"global\":false,\"domains\":[{\"uniqueIndex\":\"e2dfde48-5857-4938-9e84-9f64120ffd85\",\"id\":\"16384\",\"identifier\":\"LiveStreaming\",\"title\":\"............\",\"props\":[],\"publishVersion\":1,\"actions\":[],\"events\":[]}]}]},\"region\":\"0\"}";
        JSONObject data = JSONObject.parseObject(rs);
        JSONArray address = data.getJSONArray("deviceTemplate");
        if (address == null) {
            return;
        }
        for (Object object : address) {

        }
    }
}
