package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = subdomainVisitsBetter(cpdomains);
        list.stream().forEach(System.out::println);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        // map存储
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            // 9001 discuss.leetcode.com
            int count = 0;
            if (str.indexOf(" ") != -1) {
                //计数
                count = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            }
            str = str.substring(str.indexOf(" ") + 1, str.length());
            //转义
            String[] temp = str.split("\\.");
            if (temp.length == 2) {
                StringBuffer sb = new StringBuffer();
                sb.append(temp[0]).append(".").append(temp[1]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);

                sb = new StringBuffer();
                sb.append(temp[1]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
            }
            if (temp.length == 3) {
                StringBuffer sb = new StringBuffer();
                sb.append(temp[1]).append(".").append(temp[2]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);

                sb = new StringBuffer();
                sb.append(temp[0]).append(".").append(temp[1]).append(".").append(temp[2]);
                // 需要删除掉原有的list中的数据
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);

                sb = new StringBuffer();
                sb.append(temp[2]);
                // getOrDefault(sb.toString())也要是String
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);

            }
        }

        // 遍历map然后组成list
        for (Map.Entry entry : map.entrySet()) {
            String address = (String) entry.getKey();
            Integer count = (Integer) entry.getValue();
            list.add(count + " " + address);
        }
        return list;
    }

    // 根据空白格\s分了两个数组，然后第二个数组又用\.分
    // 不要判断，直接for数组拼接字符串
    // 遍历 for (String dom: map.keySet())

    public static List<String> subdomainVisitsBetter(String[] cpdomains) {
        // map存储
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : cpdomains) {
            String[] strByNull = str.split("\\s+");
            String[] strByPoint = strByNull[1].split("\\.");
            int count = Integer.parseInt(strByNull[0]);

            String rs = "";
            for (int i = strByPoint.length - 1; i >= 0; i--) {
                // 每个字符的最后一位都不能有.
                /*rs += strByPoint[i] + (i == strByPoint.length - 1 ? "" : ".");
                map.put(rs, map.getOrDefault(rs, 0) + count);*/
                // 小于,后加不能+=
                rs = strByPoint[i] + (i < strByPoint.length - 1 ? "." : "") + rs;
                map.put(rs, map.getOrDefault(rs, 0) + count);
            }
        }

        // 遍历map然后组成list
        for (String str : map.keySet()) {
            Integer count = map.get(str);
            list.add(count + " " + str);
        }
        return list;
    }
}
