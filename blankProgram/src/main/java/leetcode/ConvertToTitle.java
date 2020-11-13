package leetcode;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        int n = 133334;
        String s = convertToTitle(n);
        System.out.println(s);
    }

    //除数取余法
    public static String convertToTitle(int n) {
        StringBuffer rs = new StringBuffer();
        /*int nv = n;
        //需要开多少次平方
        int count = 0;

        //800需要/26的平方，除数是收尾，然后余数，/26，除数是中间位，然后余数是最后位置
        if (n > 26) {
            while (n % 26 != 0) {
                //不知道条件为啥不对。。。。
                n = n / 26;
                count++;
            }
        }
        while (count >= 0) {
            double pow = Math.pow(26, count);
            int powi = (int) pow;
            int de = nv % powi;
            //除数转换成结果，需要注意的是整除的情况，此时余数是0,方法不行
            nv = nv / powi;
            int temp = nv + 64;
            char high = (char) temp;
            //nv变成余数
            nv = de;
            rs.append(high);
            count--;

        }*/

        while (n > 0) {
            //非常重要，逻辑上是1，实际是0，每一位都要减去！
            //当n为26时，此时计算的是25，然后计算结果就是25%26=25+65，相当于是26+64(此时是这差距是65-1)
            n--;
            rs.append((char) ((n) % 26 + 'A'));
            n /= 26;
        }
        return rs.reverse().toString();
    }
}
