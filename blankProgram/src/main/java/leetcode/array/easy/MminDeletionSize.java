package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:944. 删列造序
 * @Date:2023/8/29
 */
public class MminDeletionSize {
    public static int minDeletionSize(String[] strs) {
        int rs = 0;
        // 行
        int n = strs.length;
        // 列
        int m = strs[0].length();
        for (int j = 0; j < m; ++j) {
            for (int i = 1; i < n; ++i) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    rs++;
                    break;
                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cba", "daf", "ghi"};
        // String[] strs = new String[]{"a","b"};
        System.out.println(minDeletionSize(strs));
    }
}
