package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试String转换成list
 * @Date:2023/11/20
 */
public class TestStringOrList {
    public static void main(String[] args) {
        String[] dev = new String[1];
        dev[0]="dev_asasadasdas";

        String deviceIndexCodes = JSONObject.toJSONString(dev);
        System.out.println(deviceIndexCodes);

        List<String> indexCodes = Arrays.asList(deviceIndexCodes);
        for (String indexCode : indexCodes) {
            System.out.println(indexCode);
        }
    }
}
