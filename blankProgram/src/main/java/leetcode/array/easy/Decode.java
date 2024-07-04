package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1720. 解码异或后的数组
 * @Date:2023/12/19
 */
public class Decode {
    public int[] decode(int[] encoded, int first) {
        // a^b = c ， a^b^b = a， 即 c^b=a 同理 c^a =b
        // (a^b)^c = a^(b^c)
        // a^b = b^a
        // a^a = 0
        // a^0 = a
        int len = encoded.length;
        int[] rs = new int[len + 1];
        rs[0] = first;
        for (int i = 0; i < len; i++) {
            rs[i + 1] = rs[i] ^ encoded[i];
        }
        return rs;
    }
}
