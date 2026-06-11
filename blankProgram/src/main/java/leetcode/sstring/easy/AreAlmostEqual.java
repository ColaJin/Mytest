package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1790.仅执行一次字符串交换能否使两个字符串相等
 * @Date:2024/8/15
 */
public class AreAlmostEqual {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz",
                "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        // 此方式不能重复字符
        /*char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Boolean flag = false;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]){
                if (flag){
                    // 交换完了还是不一致则无效
                    return false;
                }
                flag = true;
                // 查询chars2里面的该元素
                boolean temp = false;
                for (int j = i + 1; j < chars2.length; j++) {
                    if (chars2[j] == chars1[i]){
                        // 交换处理chars2
                        temp = true;
                        char c = chars2[i];
                        chars2[i] = chars2[j];
                        chars2[j] = c;
                        break;
                    }
                }
                if (!temp){
                    // 没找到元素不能交换成功
                    return false;
                }
            }
        }
        return true;*/

        int len = s1.length();
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }
}
