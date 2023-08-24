package hikversion;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

/**
 * @author:jinyandong
 * @description:新方法的测试使用
 * @Date:2021/12/30
 */
public class NewMethod {
    public static void main(String[] args) {
        ArrayList device = new ArrayList<String>() {{
            add("device");
        }};

        System.out.println(device.toString());

        JSONArray jsonArray= JSONArray.parseArray("['dy','dx']");
        System.out.println(jsonArray);
    }
}
