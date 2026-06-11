package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:jinyandong
 * @description:测试session认证
 * @Date:2025/7/31
 */
public class TestSession {

    // 认证信息（根据实际情况修改）
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";
    private static final int MAX_RETRIES = 2; // 最大重试次数

    public static void main(String[] args) {
        String url = "http://127.0.0.1:1880/iedge/v1/getSession";
        String sessionToken = postSessionWithRetry(0, url, null);
        System.out.println("Final Session Token: " + sessionToken);
    }

    private static String postSessionWithRetry(int retryCount, String url, Map<String, String> digestParams) {
        String lastResponse = null;

        while (retryCount <= MAX_RETRIES) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(10000);
                connection.setDoOutput(true); // 允许输出请求体

                // 设置请求头
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");

                // 如果是重试且上次返回401，添加认证头
                if (retryCount > 0 && digestParams != null) {
                    String authHeader = buildDigestAuthHeader(
                            "POST",
                            "/iedge/v1/getSession",
                            USERNAME,
                            PASSWORD,
                            digestParams
                    );
                    connection.setRequestProperty("Authorization", authHeader);
                }

                int responseCode = connection.getResponseCode();
                System.out.println("Attempt " + (retryCount + 1) + " - Status Code: " + responseCode);

                // 如果是401且第一次尝试，解析WWW-Authenticate头
                if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED && retryCount == 0) {
                    String authHeader = connection.getHeaderField("WWW-Authenticate");
                    if (authHeader != null && authHeader.startsWith("Digest")) {
                        digestParams = parseDigestAuthHeader(authHeader);
                        System.out.println("Parsed Digest params: " + digestParams);
                    }
                }

                // 读取响应
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                responseCode < 400 ? connection.getInputStream() : connection.getErrorStream()
                        ))) {
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    lastResponse = response.toString();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        JSONObject jsonResponse = JSON.parseObject(lastResponse);
                        String sessionId = jsonResponse.getString("sessionId");

                        System.out.println("SessionId: " + sessionId); // 输出：86550f1d725b0064092ebdacc4e57ec9
                        return sessionId; // 直接返回sessionId
                    } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED && retryCount < MAX_RETRIES) {
                        retryCount++;
                        postSessionWithRetry(retryCount, url, digestParams);
                    } else {
                        System.err.println("Unexpected response: " + lastResponse);
                        break;
                    }
                }

            } catch (Exception e) {
                System.err.println("Request failed: " + e.getMessage());
                e.printStackTrace();
            } finally {
                retryCount++;
            }
        }

        return lastResponse != null ? lastResponse : "Failed to get session after " + MAX_RETRIES + " attempts";
    }

    private static Map<String, String> parseDigestAuthHeader(String header) {
        Map<String, String> params = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\w+)=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(header);

        while (matcher.find()) {
            params.put(matcher.group(1), matcher.group(2));
        }
        return params;
    }

    private static String buildDigestAuthHeader(
            String method,
            String uri,
            String username,
            String password,
            Map<String, String> params) {
        try {
            String realm = params.get("realm");
            String nonce = params.get("nonce");
            String qop = params.get("qop");
            String algorithm = params.get("algorithm");
            String cnonce = Long.toHexString(System.currentTimeMillis());
            String nc = "00000001";

            // 计算HA1
            String ha1 = md5(username + ":" + realm + ":" + password);
            if ("MD5-sess".equalsIgnoreCase(algorithm)) {
                ha1 = md5(ha1 + ":" + nonce + ":" + cnonce);
            }

            // 计算HA2
            String ha2 = md5(method + ":" + uri);

            // 计算response
            String response;
            if (qop != null) {
                response = md5(ha1 + ":" + nonce + ":" + nc + ":" + cnonce + ":" + qop + ":" + ha2);
            } else {
                response = md5(ha1 + ":" + nonce + ":" + ha2);
            }

            // 构建Authorization头
            return String.format(
                    "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", algorithm=\"%s\", " +
                            "qop=\"%s\", nc=%s, cnonce=\"%s\", response=\"%s\"",
                    username, realm, nonce, uri, algorithm, qop, nc, cnonce, response
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to build Digest auth header", e);
        }
    }

    private static String md5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
