
package hikversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelLeast {
    public static void main(String[] args) {
        // 要判断字符串中字符种数
        // 遍历是否和之前一个字符相同
        // 相同数量不加，否则+1
        String s = "abcabc";
        int rs = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!list.contains(c)) {
                rs++;
                list.add(c);
            }
        }
        System.out.println(rs);
    }
}
