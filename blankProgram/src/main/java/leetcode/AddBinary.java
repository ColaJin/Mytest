package leetcode;

import java.text.DecimalFormat;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary {
    //先转换成10进制执行加和操作后再转换2进制，这种方法不行pass因为转换成int类型长度不够，结果出错
    //根据每一位进行判断如果加和为2返回位数的值为0，且进一
    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String rs = addBinary(a, b);
        System.out.println(rs);
        if (rs.equals("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000")) {
            System.out.println(true);
        }
    }

    public static String addBinary(String a, String b) {
        //比较a和b的长度，遍历短的长度(不正确高位不是从最后开始的)；
        int lena = a.length();
        int lenb = b.length();

        //交换两个字符串，使得字符串a的长度小于b的长度
        if (lena > lenb) {
            String s = a;
            a = b;
            b = s;

        }
        lena = a.length();
        lenb = b.length();
        //返回一个新的字符串，字符串的长度；
        StringBuilder rs = new StringBuilder();
        //加一首先是false；
        boolean plus = false;

        //计算结束位置
        int over = 0;

        for (int i = lenb - 1; i >= 0; i--) {

            for (int j = lena - 1; j >= 0; j--) {
                if (plus) {
                    //把位的结果转换成int，判断如果和为2(字符1的ASCII)
                    if (i == -1) {
                        System.out.println(-1);
                    }
                    int aj = a.charAt(j) - '0';
                    int bi = b.charAt(i) - '0';
                    int sum = aj + bi + 1;
                    if (sum == 2) {
                        rs.append(0);
                        plus = true;
                    } else if (sum == 3) {
                        rs.append(1);
                        plus = true;
                    } else {
                        rs.append(sum);
                        plus = false;
                    }
                } else {
                    int aj = a.charAt(j) - '0';
                    int bi = b.charAt(i) - '0';
                    int sum = aj + bi;
                    if (sum == 2) {
                        rs.append(0);
                        plus = true;
                    } else if (sum == 3) {
                        rs.append(1);
                        plus = true;
                    } else {
                        rs.append(sum);
                        plus = false;
                    }
                }
                i--;
            }

            if (i != 0) {
                over = i;
                break;

            }
        }
        //短数组和计算后进位1,在计算+1时仍要判断高位是否进位，否则结果会存在进位是false的情况
        if (plus) {
            for (int i = over; i >= 0; i--) {
                if(plus) {
                    //把位的结果转换成int，判断如果和为2(字符1的ASCII)
                    int bi = b.charAt(i) - '0';
                    int sum = bi + 1;
                    if (sum == 2) {
                        rs.append(0);
                        plus = true;
                    } else if (sum == 3) {
                        rs.append(1);
                        plus = true;
                    } else {
                        rs.append(sum);
                        plus = false;
                    }
                }else {
                    rs.append(b.charAt(i));
                }

            }
        } else {
            //不存在进位直接返回长的字符的高位
            for (int i = over; i >= 0; i--) {
                rs.append(b.charAt(i));
            }
        }
        //此时长的字符高位进位
        if (plus) {
            rs.append(1);
        }


        //reverse返回结果
        rs.reverse();
        return rs.toString();


    }

}
