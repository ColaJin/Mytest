package leetcode.array.easy;

import org.bouncycastle.jcajce.provider.symmetric.TEA;

/**
 * @author:jinyandong
 * @description:3079. 求出加密整数的和
 * @Date:2024/8/8
 */
public class SumOfEncryptedInt {
    public int sumOfEncryptedInt(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += encrypt(num);
        }
        return res;
    }

    public int encrypt(int i) {
        int res = 0;
        int max = 0;
        for (char digitChar : String.valueOf(i).toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            max = Math.max(digit, max);
        }
        char[] chars = String.valueOf(i).toCharArray();
        int length = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int temp = length; temp > 0; temp--) {
            sb.append(max);
        }
        res = Integer.valueOf(sb.toString());
        return res;
    }
}
