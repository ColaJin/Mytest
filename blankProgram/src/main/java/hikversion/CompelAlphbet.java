
package hikversion;

import java.util.*;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelAlphbet {
    public static void main(String[] args) {
        String s = "";
        String t = "d";
        if (t.length() == 1) {
            System.out.println(t);
            return;
        }
        List<Character> characterT = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            characterT.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (!characterT.contains(t.charAt(i))) {
                System.out.println(t.charAt(i));
            } else {
                // 否则报错
                characterT.remove(Character.valueOf(t.charAt(i)));
            }
        }

    }
}
