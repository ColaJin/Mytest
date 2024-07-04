package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2496. 数组中字符串的最大值
 * @Date:2024/1/25
 */
public class MaximumValue {
    public int maximumValue(String[] strs) {
        int rs = Integer.MIN_VALUE;
        for (String str : strs) {
            // 只包含数字
           if (str.matches("\\d+")){
               int temp = Integer.valueOf(str);
               if (rs < temp) {
                   rs = temp;
               }
           }else {
               int temp = str.length();
               if (rs < temp) {
                   rs = temp;
               }
           }
        }
        return rs;
    }
}
