package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1732. 找到最高海拔
 * @Date:2023/12/19
 */
public class LargestAltitude {
    public static void main(String[] args) {
        int[] gain = new int[]{-4,-3,-2,-1,4,3,2};
        int rs = largestAltitude(gain);
        System.out.println(rs);
    }

    public static int largestAltitude(int[] gain) {
        // 使用0不能是最小
        int rs = 0;
        int last = 0;
        for (int i : gain) {
            int cur = last + i;
            if (rs < cur) {
                rs = cur;
            }
            last = cur;
        }
        return rs;
    }
}
