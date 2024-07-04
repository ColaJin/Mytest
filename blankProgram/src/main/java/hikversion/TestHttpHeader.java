package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @author:jinyandong
 * @description:测试HttpHeaderAdd
 * @Date:2023/9/26
 */
public class TestHttpHeader {
    public static void main(String[] args) {
        HttpHeaders headers = setHeaders();
        for (int i = 0; i < 10; i++) {
            headers.add("SecuId", "sssssss1");
            headers.add("SecuDK", "sssssss2");
        }
        System.out.println(JSONObject.toJSONString(headers));
    }

    private static HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return headers;
    }
}
