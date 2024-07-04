package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1816. 截断句子
 * @Date:2023/12/19
 */
public class TruncateSentence {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    public static String truncateSentence(String s, int k) {
        String[] temp = s.split(" ");
        String[] change = new String[k];
        System.arraycopy(temp, 0, change, 0, k);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                sb.append(change[i]);
            } else {
                sb.append(change[i]).append(" ");
            }
        }
        return sb.toString();
    }
}
