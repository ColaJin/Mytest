
package hikversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelMaxSonString {
    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";

        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        System.out.println(ans);
    }
}
