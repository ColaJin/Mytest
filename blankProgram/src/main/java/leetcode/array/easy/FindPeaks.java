package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:2951. 找出峰值
 * @Date:2024/8/6
 */
public class FindPeaks {
    public static void main(String[] args) {
        int[] mountain = new int[]{1,4,3,8,5};
        List<Integer> peaks = findPeaks(mountain);
    }

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < mountain.length - 2; i++) {
            if (mountain[i] < mountain[i + 1] && mountain[i + 2] < mountain[i + 1]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
