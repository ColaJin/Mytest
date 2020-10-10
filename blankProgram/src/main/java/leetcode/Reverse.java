package leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 */
public class Reverse {
    public static void main(String[] args) {

        int a = 1534236469;
        int result = reverse(a);
        System.out.println(result);

    }

    public static int reverse(int arg) {

        int result = 0;
        if (arg==0){
            return result;
        }
        if (arg > 0) {
            if (arg % 10 == 0) {
                String args = "" + arg + "";
                String newStr = args.replaceAll("^(0+)", "");
                StringBuffer sBuffer = new StringBuffer(newStr);
                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }

            } else {
                String args = "" + arg + "";
                StringBuffer sBuffer = new StringBuffer(args);

                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        } else {
            arg = Math.abs(arg);
            if (arg % 10 == 0) {

                String args = "" + arg + "";
                String newStr = args.replaceAll("^(0+)", "");
                StringBuffer sBuffer = new StringBuffer(newStr);
                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }
                result = 0 - result;
            } else {
                String args = "" + arg + "";
                StringBuffer sBuffer = new StringBuffer(args);

                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }
                result = 0 - result;
            }
        }
        return result;
    }

    public static int reverse1(int arg) {

        int result = 0;
        if (arg==0){
            return result;
        }
        if (arg > 0) {
            if (arg % 10 == 0) {
                String args = "" + arg + "";
                String newStr = args.replaceAll("^(0+)", "");
                StringBuffer sBuffer = new StringBuffer(newStr);
                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }

            } else {
                String args = "" + arg + "";
                StringBuffer sBuffer = new StringBuffer(args);

                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        } else {
            arg = Math.abs(arg);
            if (arg % 10 == 0) {

                String args = "" + arg + "";
                String newStr = args.replaceAll("^(0+)", "");
                StringBuffer sBuffer = new StringBuffer(newStr);
                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }
                result = 0 - result;
            } else {
                String args = "" + arg + "";
                StringBuffer sBuffer = new StringBuffer(args);

                try {
                    result = Integer.parseInt(sBuffer.reverse().toString());
                } catch (NumberFormatException e) {
                    return 0;
                }
                result = 0 - result;
            }
        }
        return result;
    }
}
