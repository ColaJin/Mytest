package leetcode.Array.easy;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123
 */
public class PlusOne {
    //转换成整数再拆分？
    //判断各位置是不是9？
    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        int[] rs = plusOne(digits);
        for (int i = 0; i < rs.length; i++) {

            System.out.println(rs[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        //如果各位都是9，例如999的情况那么需要新数组去记录结果
        /*int[] rs = new int[length + 1];*/
        //加位置为true(刚开始就要加1)
        boolean plus = true;
        for (int i = length - 1; i >= 0; i--) {
            if (plus) {
                //从最后一个位置向前判断是否是9
                if (digits[i] == 9) {
                    //判断加位是1的话，情况1：如果是9的时候呐此位置置为0；加位还是1；
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    return digits;
                }
            }
        }
        //判断加位是1而且i已经是初始位置时，需要返回新数组rs，rs是首字母为1其他位置为0的数组；
        if (plus) {
            /*rs[0] = 1;
            for (int i = 1; i < rs.length; i++) {
                rs[i] = 0;
            }*/
            //此处可以优化后返回digits不需要返回rs，默认初始化位置都是0
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

}
