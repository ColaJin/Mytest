package hikversion;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author:jinyandong
 * @description:测试前端加密
 * @Date:2026/5/25
 */
public class TestPublicKeyEncrpt {
    public static String encryptByPublicKey(String data, String publicKey) throws Exception {
        // 解码Base64编码的公钥
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // 获取RSA KeyFactory
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        // 初始化加密器
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);

        // 加密数据
        byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));

        // 返回Base64编码的加密结果
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtxzUvNN40j1QAHfQbyBD92CCPukpcKWJ1aQugY+37zuRJrq/6aw29vqU+yh/9qTnrL42+H+abOxfq0JSZcT+9sFbonSF5KluU7A/VC47Iw8VkspVSDei9UCcxXjctujo95v6nDCA5xMWd6NSI+aMQkIrfA7WPZluc690Bm0JTmpnAyW60uvNCTpSofZKVa/G/i7/+lAAumBf7aEzu/ai0b/eQ7EwjZx36N099J8lV1kUFqRAL1T3jQvPKd0CoKvlULKCf0tgjG1wFKWecEo4lTMKFY9SW8KY0EHJoVh1aqgoJ7kEGhuve1RZ01C8dlMYqEOV/49bukAFqg3NhcMFYwIDAQAB";
        String password = "Abc12345";

        String encryptedPassword = encryptByPublicKey(password, publicKey);
        System.out.println("加密后的密码: " + encryptedPassword);
    }
}
