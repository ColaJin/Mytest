package hikversion;

import java.security.MessageDigest;

/**
 * @author:jinyandong
 * @description:测试Md5加密
 * @Date:2025/8/1
 */
public class TestMd5 {
    public static void main(String[] args) {
        try {
            String username = "admin";
            String realm="FjDb49w1UPWlfk9o9lsR1RMu";
            String password = "123456";

            String ha1 = md5(username + ":" + realm + ":" + password);

            System.out.println(ha1);
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
