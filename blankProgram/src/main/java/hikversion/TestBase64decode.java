package hikversion;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author:jinyandong
 * @description:测试电信云appData
 * @Date:2026/6/9
 */
public class TestBase64decode {
    public static void main(String[] args) {
        String recvMsg = new String(Base64.getDecoder().decode("AgPmABpuYkFsYXJtRGV0AAANjAAAAAABAQEBAHEcLg=="), StandardCharsets.UTF_8);
        System.out.println(recvMsg);
    }
}
