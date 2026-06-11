package leetcode.sstring.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:1496.判断路径是否相交
 * @Date:2024/8/14
 */
public class IsPathCrossing {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NNSWWEWSSESSWENNW"));
    }

    public static boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();

        int x = 0;
        int y = 0;
        set.add(getHash(x, y));
        int len = path.length();
        for (int i = 0; i < len; i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'N':
                    --x;
                    break;
                case 'S':
                    ++x;
                    break;
                case 'W':
                    --y;
                    break;
                case 'E':
                    ++y;
                    break;
            }
            int temp = getHash(x, y);
            if (set.contains(temp)) {
                return true;
            } else {
                set.add(temp);
            }
            // 上面逻辑可替换成
            /*if(!set.add(temp)){
                return true;
            }*/
        }

        return false;
    }

    public static int getHash(int x, int y) {
        return x * 20001 + y;
    }
}
