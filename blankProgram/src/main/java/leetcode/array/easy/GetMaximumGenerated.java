package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:1646. 获取生成数组中的最大值
 * @Date:2023/12/18
 */
public class GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] rs = new int[n + 1];
        rs[1] = 1;
        for (int i = 2; i <= n; i++) {
            rs[i] = rs[i / 2] + i % 2 * rs[i / 2 + 1];
        }
        return Arrays.stream(rs).max().getAsInt();
    }
}
