package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1528. 重新排列字符串
 * @Date:2023/12/13
 */
public class RestoreString {
    public static void main(String[] args) {
        // 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
        // 输出："leetcode"
        String s = "codeleet";
        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        String rs = restoreString(s, indices);
        System.out.println(rs);
    }

    public static String restoreString(String s, int[] indices) {
        String rs = "";
        int len = indices.length;
        char[] temp = new char[len];
        for (int i = 0; i < s.length(); i++) {
            temp[indices[i]] = s.charAt(i);
        }
        rs = new String(temp);
        return rs;
    }
}
