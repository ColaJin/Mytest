package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1773. 统计匹配检索规则的物品数量
 * @Date:2023/12/19
 */
public class CountMatches {

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> temp1 = new ArrayList<>();
        temp1.add("phone");
        temp1.add("blue");
        temp1.add("pixel");
        List<String> temp2 = new ArrayList<>();
        temp2.add("computer");
        temp2.add("silver");
        temp2.add("lenovo");
        List<String> temp3 = new ArrayList<>();
        temp3.add("phone");
        temp3.add("gold");
        temp3.add("iphone");
        items.add(temp1);
        items.add(temp2);
        items.add(temp3);
        String ruleKey = "color";
        String ruleValue = "silver";
        int rs = countMatches(items, ruleKey, ruleValue);
        System.out.println(rs);
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int rs = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type")) {

                String s = item.get(0);
                if (s.equals(ruleValue)) {
                    rs++;
                }
            } else if (ruleKey.equals("color")) {
                String s = item.get(1);
                if (s.equals(ruleValue)) {
                    rs++;
                }
            } else {
                String s = item.get(2);
                if (s.equals(ruleValue)) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
