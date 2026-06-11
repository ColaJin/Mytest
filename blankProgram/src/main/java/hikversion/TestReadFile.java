package hikversion;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:测试读取文件最后一行数据
 * @Date:2025/8/22
 */
public class TestReadFile {

    public static void processScriptFile(String filePath) {
        Map<String,String> map = new HashMap<>();
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return;
        }

        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(isr)
        ) {
            StringBuilder scriptBuilder = new StringBuilder();
            List<String> lines = new ArrayList<>();
            String tempString;
            String lastLine = null;

            // 读取每一行并记录
            while ((tempString = bufferedReader.readLine()) != null) {
                scriptBuilder.append(tempString).append("\n");
                lines.add(tempString);
                lastLine = tempString;
            }

            String fileData = scriptBuilder.toString();
            System.out.println("Last line of the file: " + lastLine); // 可替换为 logger.info()

            // 查找最后一个有效的 "#topic:" 注释行
                                String onlyKey = null;
                    if (lastLine != null && lastLine.startsWith("#topic:")) {
                        onlyKey = lastLine.substring("#topic:".length()).trim();
                        map.put(onlyKey, "");
                        System.out.println(onlyKey);
                    }

        } catch (IOException e) {
            System.err.println("Error reading or processing script file: " + filePath);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        processScriptFile("E://hikvision_fp_ctwing_GT-HK11J-N+event_fire$0x0003E11B.py");
    }
}
