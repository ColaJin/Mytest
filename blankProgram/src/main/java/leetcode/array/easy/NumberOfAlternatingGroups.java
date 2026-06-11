package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:3206.交替组I
 * @Date:2024/8/8
 */
public class NumberOfAlternatingGroups {
    public static void main(String[] args) {
        int[] colors = new int[]{0, 1, 0, 0, 1};
        System.out.println(numberOfAlternatingGroups(colors));
    }

    public static int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        int n = colors.length;
        for (int i = 0; i < n - 2; i++) {
            if (colors[i] != colors[i + 1] && colors[i + 1] != colors[i + 2]) {
                res++;
            }
        }
        if (colors[n - 1] != colors[0] && colors[0] != colors[1]) {
            res++;
        }

        if (colors[n - 2] != colors[n - 1] && colors[0] != colors[n - 1]) {
            res++;
        }
        return res;
    }
}
