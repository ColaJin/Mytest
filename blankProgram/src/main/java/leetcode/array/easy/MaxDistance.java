package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2078. 两栋颜色不同且距离最远的房子
 * @Date:2023/12/25
 */
public class MaxDistance {
    public static int maxDistance(int[] colors) {
        int rs = 0;
        int len = colors.length;

        for (int i = 0; i < len; i++) {
            int end = len - 1;
            while (i < end) {
                if (colors[end] != colors[i]) {
                    rs = Math.max(Math.abs(end - i), rs);
                    break;
                } else {
                    end--;
                }
            }
        }
        return rs;
    }
}
