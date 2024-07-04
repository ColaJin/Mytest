package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:806. 写字符串需要的行数
 * @Date:2023/8/28
 */
public class NumberOfLines {
    public static int[] numberOfLines(int[] widths, String s) {
        int[] rs = new int[2];
        int col = 0;
        int count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            int c = s.charAt(i) - 'a';
            count += widths[c];
            if (count > 100) {
                // 超过该行此时改字符应该下一行算
                count = 0;
                col++;
                i--;
            } else {
                if (count == 100){
                    count = 0;
                    col++;
                }
            }
        }
        if (count == 0){
            rs[0] = col;
            rs[1] = 100;
        }else {
            rs[0] = col + 1;
            rs[1] = count;
        }
        return rs;
    }

    public static void main(String[] args) {
        // String s = "abcdefghijklmnopqrstuvwxyz";
        // String s = "bbbcccdddaaa";
        String s = "mqblbtpvicqhbrejb";
        // int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        // int[] widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] widths = new int[]{3,4,10,4,8,7,3,3,4,9,8,2,9,6,2,8,4,9,9,10,2,4,9,10,8,2};
        int[] rs = numberOfLines(widths, s);
        for (int r : rs) {
            System.out.println(r);
        }


    }
}
