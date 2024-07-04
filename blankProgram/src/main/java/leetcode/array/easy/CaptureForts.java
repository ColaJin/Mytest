package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2511. 最多可以摧毁的敌人城堡数目
 * @Date:2024/2/1
 */
public class CaptureForts {
    public static void main(String[] args) {
        int[] forts = new int[]{1, 0, 0, -1, 0, 0, -1, 0, 0, 1};
        System.out.println(captureForts(forts));
    }

    public static int captureForts(int[] forts) {
        int rs = 0;
        /*// 查找空地位置存在问题1,0,0,-1,0,0,-1,0,0,1
        List<Integer> list = new ArrayList<>();
        List<Integer> own = new ArrayList<>();
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == -1) {
                list.add(i);
            } else if (forts[i] == 1) {
                own.add(i);
            }
        }
        if (list.isEmpty() || own.isEmpty()) {
            return rs;
        }
        for (Integer temp : list) {
            for (Integer pos : own) {
                int last = Math.abs(pos - temp) - 1;
                if (last > rs) {
                    rs = last;
                }
            }
        }*/
        int pre = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    rs = Math.max(rs, i - pre - 1);
                }
                pre = i;
            }
        }
        return rs;
    }
}
