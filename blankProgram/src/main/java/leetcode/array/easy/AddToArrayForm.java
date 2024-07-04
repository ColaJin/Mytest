package leetcode.array.easy;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:jinyandong
 * @description:989. 数组形式的整数加法
 * @Date:2023/8/29
 */
public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> rs = new ArrayList<>();
        // 9999999999最大
        /*StringBuffer sb = new StringBuffer();
        for (int n : num) {
            sb.append(n);
        }
        int i = Integer.valueOf(sb.toString()) + k;
        String s = String.valueOf(i);

        for (char c : s.toCharArray()) {
            rs.add(Integer.valueOf(c - '0'));
        }*/
        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum >= 10) {
                k++;
                // 当前位大于10的数量
                sum -= 10;
            }
            rs.add(sum);
        }

        // 存在进一位置
        for (; k > 0; k /= 10) {
            rs.add(k % 10);
        }
        Collections.reverse(rs);
        return rs;
    }

    public static void main(String[] args) {
        int[] num = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 1;
        List<Integer> rs = addToArrayForm(num, k);
        for (Integer i : rs) {
            System.out.println(i);
        }
    }
}
