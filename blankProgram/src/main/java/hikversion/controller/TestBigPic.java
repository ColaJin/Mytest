package hikversion.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;

/**
 * @author:jinyandong
 * @description:测试上传大图片
 * @Date:2025/8/8
 */
public class TestBigPic {
    public static void main(String[] args) {
        long currnt = System.currentTimeMillis();
        try {
            // Step 1: Read image file and encode to Base64
            String imagePath = "D:/testBig.png";
            File imageFile = new File(imagePath);
            byte[] fileContent = Files.readAllBytes(imageFile.toPath());
            String base64Image = Base64.getEncoder().encodeToString(fileContent);

            // Step 2: Build request data structure
            JSONObject data = new JSONObject();
            data.put("clientId", "DEV12345");
            data.put("picBase64", new String[]{base64Image});
            data.put("checkValue", "45.6");
            data.put("checkResult", "success");
            data.put("happenTime", "2023-08-23 12:20:00");

            JSONObject requestBody = new JSONObject();
            requestBody.put("deviceIndexCode", "DEV12345");
            requestBody.put("data", data);
            requestBody.put("eventType", 1);




            // Step 3: Convert object to JSON string
            // Step 3: Convert object to JSON string
            String jsonInputString = requestBody.toJSONString();

            HashMap<String, Object> body = new HashMap<>();
            body = JSONObject.parseObject(jsonInputString, new TypeReference<HashMap<String, Object>>() {});
            System.out.println("can deal");
            String temp = JSONObject.toJSONString(body);
            System.out.println("can deal too");

            // Step 4: Send HTTP POST request
            sendPostRequest("http://10.19.214.131:17288/api/logicagent/eventreport", jsonInputString);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() - currnt);
        }
    }

    private static void sendPostRequest(String targetUrl, String jsonInputString) throws IOException {
        URL url = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        // Write JSON data to output stream
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read response
        int code = con.getResponseCode();
        System.out.println("Response Code : " + code);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Response Body: " + response.toString());
        }
    }

}
