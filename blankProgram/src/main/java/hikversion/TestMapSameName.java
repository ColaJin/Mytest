package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试map同名key
 * @Date:2023/10/23
 */
public class TestMapSameName {
    public static void main(String[] args) {
        Map<String, List<String>> map =new HashMap<>();
        List<String> temp = new ArrayList<>();
        temp.add("wewqeewe");
        temp.add("uuuuuu");
        map.put("12433huysdwe78y82332",temp);
        System.out.println(JSONObject.toJSONString(map));
        map.put("12433huysdwe78y82332",new ArrayList<>());
        System.out.println(JSONObject.toJSONString(map));
    }
}
