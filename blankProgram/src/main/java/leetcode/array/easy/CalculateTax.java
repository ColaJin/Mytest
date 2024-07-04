package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2303. 计算应缴税款总额
 * @Date:2023/12/29
 */
public class CalculateTax {
    public static void main(String[] args) {
        int[][] brackets = new int[][]{{3,50},{7,10},{12,25}};
        int income = 10;
        System.out.println(calculateTax(brackets, income));
    }
    public static double calculateTax(int[][] brackets, int income) {
        double rs = 0.0;
        int last = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i][0] < income) {
                rs += (double) (brackets[i][0]-last) * brackets[i][1] / 100;
                last = brackets[i][0];
            } else {
                rs += (double)(income - last) * brackets[i][1] / 100 ;
                break;
            }
        }
        return rs;
    }
}
