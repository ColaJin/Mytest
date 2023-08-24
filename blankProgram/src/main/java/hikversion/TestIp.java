package hikversion;

import org.apache.commons.lang3.StringUtils;
import org.python.google.common.collect.Lists;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:jinyandong
 * @description:测试是Ip还是域名
 * @Date:2023/5/18
 */
public class TestIp {
    public static void main(String[] args) {
        // System.out.println(isIp("10.1.1.1"));
        String url1 = "http://www.xx.com";

        String url2 = "w.xx.com";

        String url3 = "http://w.xx.com";

        String url4 = "ssss";

        Pattern pattern = Pattern

                .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+ ([A-Za-z0-9-~\\/])+$");

        System.out.println(pattern.matcher(url1).matches());

        System.out.println(pattern.matcher(url2).matches());

        System.out.println(pattern.matcher(url3).matches());

        System.out.println(pattern.matcher(url4).matches());
    }

    public static boolean isIp(String addr) {
        try {
            URL url = new URL(addr);
            String host = url.getHost();
            InetAddress address = null;
            address = InetAddress.getByName(host);
            if (host.equalsIgnoreCase(address.getHostAddress())) return true;
            else return false;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isIpStr(String str) {
        // 非空
        // boolean notBlank = StringUtils.isNotBlank(str);
        // 长度符合 0.0.0.0 - 255.255.255.255
        // boolean length = CommonUtils.isNumberBetween(str.length(),7,15);
        if (StringUtils.isNotBlank(str) && isNumberBetween(str.length(), 7, 15)) {
            String regex = ".";
            // 包含分隔符 且 个数正确
            if (str.contains(regex) && str.split(regex).length == 4) {
                boolean legalNumber = true;
                // 四个全部是数字，且都在合理的范围内
                for (String obj : Lists.newArrayList(str.split(regex))) {
                    if (isDigit(obj)) {
                        Integer value = Integer.parseInt(obj);
                        legalNumber = isNumberBetween(value, 0, 255);
                    } else {
                        // 任意一个不是数字，不合法
                        legalNumber = false;
                        break;
                    }
                }
                return legalNumber;
            }
        }
        return false;

    }

    public static boolean isNumberBetween(Number number, Number min, Number max) {
        return number.longValue() >= min.longValue() && number.longValue() <= max.longValue();
    }

    public static boolean isDigit(String var) {
        Matcher isNum = Pattern.compile("[0-9]*").matcher(var);
        return isNum.matches();
    }
}
