package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import gof23.proxy.demo02.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author:jinyandong
 * @description:测试分割字符串函数
 * @Date:2021/10/9
 */
public class TestSplit {
    public static void main(String[] args) {
        /*String configPrefixList = "das.1";
        String[] rs = StringUtils.split(configPrefixList, ",");
        for (String r : rs) {
            System.out.println(r);
        }

        if (5 > ("ehome_reg".equals("otap_iot") ? 5 : 3)) {
            System.out.println(("ehome_reg".equals("otap_iot")));
        }

        String json = "";

        JSONObject jsonobj = JSON.parseObject(json);

        // JSONObject jsonDri = jsonobj.getJSONObject("");

        for (int i = 0;i < 13;i++) {
            System.out.println(i);
        }

        System.out.println(generateSecuSID());*/


        /*UserDevice userDevice = new UserDevice();
        List<String> tempDevice = new ArrayList();
        tempDevice.add("123456");
        userDevice.setDeviceIds((String[]) tempDevice.toArray());*/

        TestNullPointerException testNullPointerException = new TestNullPointerException();
        testNullPointerException.toAttributeJson();

    }



    public static String generateSecuSID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String secuSID = str.replace("-", "");
        return secuSID;
    }

    public void launchNegotiation(String url) {
        /*try {
            // 甲方公钥
            byte[] publicKey1 = null;
            // 甲方私钥
            byte[] privateKey1 = null;
            // 甲方生成的P值
            String p = null;
            // 甲方生成的P值
            String g = null;
            // 生成DH算法中的prime值
            String prime = DHCryptUtils.randomPrime(512);
            // 生成甲方密钥对
            Map<String, Object> keyMapC = DHCryptUtils.initKey(prime, null);
            p = DHCryptUtils.getDHP(keyMapC).toString(16);
            g = DHCryptUtils.getDHG(keyMapC).toString(16);
            publicKey1 = DHCryptUtils.getPublicKey(keyMapC);
            privateKey1 = DHCryptUtils.getPrivateKey(keyMapC);

            // 组装body体
            ClientParam client = new ClientParam();
            client.setP(p);
            client.setG(g);
            client.setPublicKey(ZzSecurityUtil.bytesToHexString(publicKey1));
            client.setSecuSIDA(UUID.randomUUID().toString().replace("-", ""));
            client.setSupports(encName);

            // 生成token
            String tokenSecurity = Base64Utils.encodeBase64String(Authentication.identifyApply(client.getSecuSIDA() + ZzSecurityUtil.bytesToHexString(publicKey1) + p + g), false);
            HttpHeaders headers = new HttpHeaders();
            //headers.set("TokenSecurity", tokenSecurity);
            headers.set("Token", tokenSecurity);
            // 发送请求
            Map<String, Object> result = restService.post(url + ADDRESS_DMS, headers, new HashMap<String, Object>() {{
                put("serviceIndexCode", "iotdevls");
            }}, client);
            if (!CollectionUtils.isEmpty(result)) {
                HttpHeaders responseHeader = (HttpHeaders) result.get("header");
                ResultData resultData = (ResultData) result.get("body");
                if (responseHeader != null && StringUtils.equals(CenterErrorCode.SUCCESS, resultData.getCode())) {
                    // 取出返回的body体
                    Object data = resultData.getData();
                    NegotiateBack negotiateBack = TypeUtils.castToJavaBean(data, NegotiateBack.class);
                    if (negotiateBack != null) {
                        negotiateBack.setSupports(encName);
                        // 取出返回头中的数据
                        String token = responseHeader.getFirst("Token");
                        String secuSID = responseHeader.getFirst("SecuSID");
                        negotiateBack.setToken(token);
                        negotiateBack.setSecuSID(secuSID);
                        // 验证返回结果
                        if (StringUtils.isNotBlank(negotiateBack.getToken()) && ZzSecurityUtil.authenticateToken(negotiateBack.getToken(),
                                negotiateBack.getSecuSID() + negotiateBack.getPublicKey() + negotiateBack.getSupports() + negotiateBack.getExpireTime())) {
                            // 甲方本地密钥
                            Map<String, Object> key1 = DHCryptUtils.getSecretKey(p, g, ZzSecurityUtil.hexStringToBytes(negotiateBack.getPublicKey()), privateKey1, encName);
                            byte[] localKeya = DHCryptUtils.getLocalKey(key1);
                            byte[] localIva = DHCryptUtils.getLocalIv(key1);

                            ShankHandsDto shankHand = new ShankHandsDto();
                            shankHand.setLocalIvb(localIva);
                            shankHand.setLocalKeyb(localKeya);
                            shankHand.setSecuSID(negotiateBack.getSecuSID());
                            // 写入缓存 根据服务端地址存储缓存（加密用）
                            boolean redisSetResult = jedisService.set(getShankHandKey(url).toString(), JSONObject.toJSON(shankHand), negotiateBack.getExpireTime());

                            // 协商成功
                            if (redisSetResult) {
                                log.info(HikLog.toLog(CenterErrorCode.SUCCESS, "negotiate success:{}"), url);
                            }
                        } else {
                            log.error(HikLog.toLog(CenterErrorCode.FAILED_TO_CHECK_TOKEN, "token check error"));
                        }
                    }
                }
            } else {
                log.error(HikLog.toLog(CenterErrorCode.SECURITY_NEGOTIATE_ERROR, "negotiate error:{}"), url);
            }
        } catch (Exception e) {
            log.error(HikLog.toLog(CenterErrorCode.SECURITY_NEGOTIATE_ERROR, "negotiate error"), e);
        }*/
    }
}
